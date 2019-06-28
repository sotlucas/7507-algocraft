package fiuba.algo3.vista;

import fiuba.algo3.controlador.ControladorDeEscena;
import fiuba.algo3.controlador.ControladorDeInventario;
import fiuba.algo3.modelo.Herramienta;
import fiuba.algo3.modelo.RecetaNoExisteException;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

public class InventarioVista {
    private BorderPane root;
    private ImageView seleccionado = null;
    private GridPane inventario;
    private ControladorDeInventario controlador;
    private int x_seleccionado;
    private int y_seleccionado;
    private HBox vistaMesaCrafteo;

    public InventarioVista(ControladorDeEscena controladorDeEscena) {
        root = new BorderPane();
        root.setId("background");

        VBox contenedor = new VBox();
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setId("contenedor-casillas");

        Label titulo1 = new Label("Crafting");
        titulo1.setId("titulo-inventario");
        this.inventario = crearInventario(3, 9, false);
        Label titulo2 = new Label("Inventario");
        titulo2.setId("titulo-inventario");
        HBox mesaDeCrafteo = crearMesa();
        this.vistaMesaCrafteo = mesaDeCrafteo;

        contenedor.getChildren().addAll(titulo1, mesaDeCrafteo, titulo2, inventario);

        HBox menu = new HBox();
        menu.setAlignment(Pos.CENTER);
        Boton cerrar = new Boton("Cerrar - [E]");
        cerrar.setOnAction(e -> {
            controladorDeEscena.activate("juego");
            vaciar(mesaDeCrafteo);
            controlador.actualizarVista();
            controlador.vaciarMesa();
            this.seleccionado = null;
        });
        menu.getChildren().addAll(cerrar);

        root.setTop(menu);
        root.setCenter(contenedor);

        root.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.E) {
                controladorDeEscena.activate("juego");
            }
        });
    }

    public Pane getPane() {
        return this.root;
    }

    private GridPane crearInventario(int maxFil, int maxCol, boolean es_mesa) {
        GridPane inventario = new GridPane();
        inventario.setAlignment(Pos.CENTER);
        // Agrego casillas
        for(int fila = 0; fila < maxFil; fila++) {
            for(int col = 0; col < maxCol; col++) {
                agregarCasilla(inventario, col, fila, es_mesa);
            }
        }

        return inventario;
    }

    private HBox crearMesa() {
        HBox contenedor = new HBox(10);
        contenedor.setAlignment(Pos.CENTER);
        GridPane mesa = crearInventario(3, 3, true);

        ImageView flecha = getImagen("flecha", 48);

        Boton crear = new Boton("Crear");
        crear.setOnAction(e -> {
            try {
                controlador.crearHerramienta();
                controlador.quitarDelInventario();
                vaciar(contenedor);
                controlador.vaciarMesa();
                controlador.actualizarVista();
            } catch (RecetaNoExisteException ex) {
            }
        });

        contenedor.getChildren().addAll(mesa, flecha,crear);

        return contenedor;
    }

    private void agregarElemento(GridPane inventario, String elemento, int fila, int columna) {
        if (elemento == null) return;
        StackPane stack = new StackPane();
        Image itemImage = new Image(getClass().getResourceAsStream("../../../res/"+elemento+".png"), 38, 0, true, true);
        ImageView imageView = new ImageView(itemImage);
        imageView.setId(String.valueOf(elemento.charAt(0)));
        stack.getChildren().add(imageView);
        inventario.add(stack, fila, columna);
        stack.setId("casilla");
        imageView.setOnMouseClicked(e -> {
            System.out.println("IMAGEN");
            this.seleccionado = imageView;
            this.x_seleccionado = fila;
            this.y_seleccionado = columna;
        });
        stack.setOnMouseReleased(e -> {
            if (this.seleccionado != null) {
                System.out.println("PONGO");
                stack.getChildren().clear();
                stack.getChildren().add(this.seleccionado);
                this.seleccionado = null;
            }
        });
    }

    private void agregarCasilla(GridPane inventario, int col, int fila, boolean es_mesa) {
        StackPane stackBack = new StackPane();
        ImageView imageView = new ImageView(
                new Image(getClass().getResourceAsStream("../../../res/casilla.png"), 48, 0, true, true));
        stackBack.getChildren().add(imageView);
        inventario.add(stackBack, col, fila);
        stackBack.setId("casilla");
        stackBack.setOnMouseReleased(e -> {
            if (this.seleccionado != null) {
                System.out.println("BACK");
                stackBack.getChildren().clear();
                stackBack.getChildren().addAll(imageView, this.seleccionado);
                if (es_mesa) {
                    int pos = (fila * 3) + col;
                    int pos_seleccionado = this.x_seleccionado + this.y_seleccionado * 3;
                    System.out.print(pos);
                    System.out.print(pos_seleccionado);
                    this.controlador.agregarAMesaCrafteo(this.seleccionado.getId().charAt(0),pos, pos_seleccionado);
                }
                this.seleccionado = null;
            }
        });
    }

    private ImageView getImagen(String nombre, int tamanio) {
        return new ImageView(new Image(getClass().getResourceAsStream("../../../res/"+nombre+".png"), tamanio, 0, true, true));
    }

    public void agregar(String elemento, int fila, int columna) {
        this.agregarElemento(this.inventario, elemento, fila, columna);
    }

    public void limpiar() {
        this.inventario.getChildren().clear();
        for(int fila = 0; fila < 3; fila++) {
            for(int col = 0; col < 9; col++) {
                agregarCasilla(this.inventario, col, fila, false);
            }
        }
    }

    public void setControlador(ControladorDeInventario controladorDeInventario) {
        this.controlador = controladorDeInventario;
    }

    public void vaciar(HBox mesa) {
        mesa.getChildren().clear();
        GridPane mesaCrafteo = crearInventario(3, 3, true);

        ImageView flecha = getImagen("flecha", 48);

        Boton crear = new Boton("Crear");
        crear.setOnAction(e -> {
            try {
                controlador.crearHerramienta();
                controlador.quitarDelInventario();
                vaciar(mesa);
                controlador.actualizarVista();
            } catch (RecetaNoExisteException ex) {
            }
        });

        mesa.getChildren().addAll(mesaCrafteo, flecha,crear);
    }
}
