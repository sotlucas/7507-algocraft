package fiuba.algo3.vista;

import fiuba.algo3.controlador.ControladorDeEscena;
import fiuba.algo3.controlador.ControladorJuego;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;

public class JuegoVista {

    private GridPane mapa;
    private ControladorJuego controlador;

    private BorderPane main;

    public JuegoVista(ControladorDeEscena controladorDeEscena, SelectorHerramientas selectorHerramientas) {
        main = new BorderPane();
        main.setId("juego-escena");

        this.mapa = new GridPane();
        mapa.setAlignment(Pos.CENTER);

        // Top menu
        HBox menu = new HBox();
        menu.setAlignment(Pos.CENTER);
        Boton btnInventario = new Boton("Inventario - [E]");
        Boton btnMenu = new Boton("Menu - [ESC]");
        btnInventario.setOnAction(e -> controladorDeEscena.activate("inventario"));
        btnMenu.setOnAction(e -> controladorDeEscena.activate("main"));
        menu.getChildren().addAll(btnMenu, btnInventario);

        // Botones para moverse
        VBox flechasMover = new VBox();
        flechasMover.setAlignment(Pos.BOTTOM_CENTER);
        HBox flechasMoverAbajo = new HBox();
        Boton btnMoverIzquierda = new Boton("A");
        Boton btnMoverDerecha = new Boton("D");
        Boton btnMoverAbajo = new Boton("S");
        flechasMoverAbajo.getChildren().addAll(btnMoverIzquierda,btnMoverAbajo,btnMoverDerecha);
        Boton btnMoverArriba = new Boton("W");
        flechasMover.getChildren().addAll(btnMoverArriba, flechasMoverAbajo);

        // Botones para golpear
        VBox flechasGolpear = new VBox();
        flechasGolpear.setAlignment(Pos.BOTTOM_CENTER);
        HBox flechasGolpearAbajo = new HBox();
        Boton btnGolpearIzquierda = new Boton("◄");
        Boton btnGolpearDerecha = new Boton("►");
        Boton btnGolpearAbajo = new Boton("▼");
        flechasGolpearAbajo.getChildren().addAll(btnGolpearIzquierda,btnGolpearAbajo,btnGolpearDerecha);
        Boton btnGolpearArriba = new Boton("▲");
        flechasGolpear.getChildren().addAll(btnGolpearArriba, flechasGolpearAbajo);

        // Main game
        main.setTop(menu);
        main.setCenter(mapa);
        main.setLeft(flechasMover);
        main.setRight(flechasGolpear);
        main.setBottom(selectorHerramientas);

        // Mouse
        btnMoverIzquierda.setOnAction( e -> controlador.moverIzquierda());
        btnMoverDerecha.setOnAction( e -> controlador.moverDerecha());
        btnMoverAbajo.setOnAction( e -> controlador.moverAbajo());
        btnMoverArriba.setOnAction( e -> controlador.moverArriba());

        btnGolpearIzquierda.setOnAction( e -> controlador.golpearIzquierda());
        btnGolpearDerecha.setOnAction( e -> controlador.golpearDerecha());
        btnGolpearAbajo.setOnAction( e -> controlador.golpearAbajo());
        btnGolpearArriba.setOnAction( e -> controlador.golpearArriba());

        // Teclado
        main.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.E) {
                controladorDeEscena.activate("inventario");
            }
            if (event.getCode() == KeyCode.ESCAPE) {
                controladorDeEscena.activate("main");
            }
            if (event.getCode() == KeyCode.W) {
                controlador.moverArriba();
            }
            if (event.getCode() == KeyCode.A) {
                controlador.moverIzquierda();
            }
            if (event.getCode() == KeyCode.S) {
                controlador.moverAbajo();
            }
            if (event.getCode() == KeyCode.D) {
                controlador.moverDerecha();
            }
            if (event.getCode() == KeyCode.UP) {
                controlador.golpearArriba();
            }
            if (event.getCode() == KeyCode.LEFT) {
                controlador.golpearIzquierda();
            }
            if (event.getCode() == KeyCode.DOWN) {
                controlador.golpearAbajo();
            }
            if (event.getCode() == KeyCode.RIGHT) {
                controlador.golpearDerecha();
            }
        });
    }

    public Pane getPane() {
        return this.main;
    }

    public void agregarElemento(String nombreImagen, int fila, int col) {
        ImageView img = new ImageView(new Image(getClass().getResourceAsStream("../../../res/"+nombreImagen+".png"), 32, 0, true, true));
        mapa.add(img, col, fila);
    }

    public void setControlador(ControladorJuego controlador) {
        this.controlador = controlador;
    }
}
