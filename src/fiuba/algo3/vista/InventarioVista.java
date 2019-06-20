package fiuba.algo3.vista;

import fiuba.algo3.controlador.ControladorDeEscena;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class InventarioVista {
    private BorderPane root;
    private ImageView seleccionado = null;
    private Scene scene;
    private GridPane inventario;

    public InventarioVista(Scene scene, ControladorDeEscena controladorDeEscena) {
        this.scene = scene;
        root = new BorderPane();
        root.setId("background");

        VBox contenedor = new VBox();
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setId("contenedor-casillas");

        Label titulo1 = new Label("Crafting");
        titulo1.setId("titulo-inventario");
        this.inventario = crearInventario(3, 9);
        Label titulo2 = new Label("Inventario");
        titulo2.setId("titulo-inventario");
        HBox mesaDeCrafteo = crearMesa();

        contenedor.getChildren().addAll(titulo1, mesaDeCrafteo, titulo2, inventario);

        HBox menu = new HBox();
        menu.setAlignment(Pos.CENTER);
        Boton cerrar = new Boton("Cerrar - [E]");
        cerrar.setOnAction(e -> {
            controladorDeEscena.activate("juego");
        });
        menu.getChildren().addAll(cerrar);

        root.setTop(menu);
        root.setCenter(contenedor);
    }

    public Pane getPane() {
        return this.root;
    }

    private GridPane crearInventario(int maxFil, int maxCol) {
        GridPane inventario = new GridPane();
        inventario.setAlignment(Pos.CENTER);
        // Agrego casillas
        for(int fila = 0; fila < maxFil; fila++) {
            for(int col = 0; col < maxCol; col++) {
                agregarCasilla(inventario, col, fila);
            }
        }

        return inventario;
    }

    private HBox crearMesa() {
        HBox contenedor = new HBox(10);
        contenedor.setAlignment(Pos.CENTER);
        GridPane mesa = crearInventario(3, 3);

        ImageView flecha = getImagen("flecha", 48);
        ImageView resultado = getImagen("casilla", 64);
        resultado.setId("casilla");

        contenedor.getChildren().addAll(mesa, flecha, resultado);

        return contenedor;
    }

    private void agregarElemento(GridPane inventario, String elemento, int fila, int columna) {
        if (elemento == null) return;
        StackPane stack = new StackPane();
        Image itemImage = new Image(getClass().getResourceAsStream("../../../res/"+elemento+".png"), 38, 0, true, true);
        ImageView imageView = new ImageView(itemImage);
        stack.getChildren().add(imageView);
        inventario.add(stack, fila, columna);
        stack.setId("casilla");
        imageView.setOnMouseClicked(e -> {
            System.out.println("IMAGEN");
            stack.getChildren().clear();
            this.seleccionado = imageView;
        });
        stack.setOnMouseReleased(e -> {
            if (this.seleccionado != null) {
                System.out.println("PONGO");
                stack.getChildren().add(this.seleccionado);
                this.seleccionado = null;
            }
        });
    }

    private void agregarCasilla(GridPane inventario, int col, int fila) {
        StackPane stackBack = new StackPane();
        ImageView imageView = new ImageView(
                new Image(getClass().getResourceAsStream("../../../res/casilla.png"), 48, 0, true, true));
        stackBack.getChildren().add(imageView);
        inventario.add(stackBack, col, fila);
        stackBack.setId("casilla");
        stackBack.setOnMouseReleased(e -> {
            if (this.seleccionado != null) {
                System.out.println("BACK");
                stackBack.getChildren().add(this.seleccionado);
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
}
