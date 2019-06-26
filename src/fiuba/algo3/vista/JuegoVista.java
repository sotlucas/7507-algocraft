package fiuba.algo3.vista;

import fiuba.algo3.controlador.ControladorDeEscena;
import fiuba.algo3.controlador.ControladorJuego;
import fiuba.algo3.modelo.HaciaAbajo;
import fiuba.algo3.modelo.HaciaArriba;
import fiuba.algo3.modelo.HaciaDerecha;
import fiuba.algo3.modelo.HaciaIzquierda;
import fiuba.algo3.vista.animacion.ShakeTransition;
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

        // Boton mute
        Image sonido = new Image(getClass().getResourceAsStream("../../../res/sonido.png"), 34, 0, true, true);
        Image mute = new Image(getClass().getResourceAsStream("../../../res/mute.png"), 34, 0, true, true);
        Boton btnMute = new Boton(sonido);
        btnMute.setAlignment(Pos.TOP_LEFT);
        btnMute.setOnAction(e -> {
            if (controlador.musicaPausada()) {
                controlador.reproducirMusica();
                btnMute.cambiarImagen(sonido);
            }else {
                controlador.pausarMusica();
                btnMute.cambiarImagen(mute);
            }
            ShakeTransition animacion = new ShakeTransition(btnMute);
            animacion.play();
        });

        // Top menu
        HBox menu = new HBox(10);
        menu.setAlignment(Pos.CENTER);
        Boton btnInventario = new Boton("Inventario - [E]");
        Boton btnMenu = new Boton("Menu - [ESC]");
        btnInventario.setOnAction(e -> controladorDeEscena.activate("inventario"));
        btnMenu.setOnAction(e -> controladorDeEscena.activate("main"));
        menu.getChildren().addAll(btnMute, btnMenu, btnInventario);

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
        btnMoverIzquierda.setOnAction( e -> controlador.mover(new HaciaIzquierda()));
        btnMoverDerecha.setOnAction( e -> controlador.mover(new HaciaDerecha()));
        btnMoverAbajo.setOnAction( e -> controlador.mover(new HaciaAbajo()));
        btnMoverArriba.setOnAction( e -> controlador.mover(new HaciaArriba()));

        btnGolpearIzquierda.setOnAction( e -> controlador.golpear(new HaciaIzquierda()));
        btnGolpearDerecha.setOnAction( e -> controlador.golpear(new HaciaDerecha()));
        btnGolpearAbajo.setOnAction( e -> controlador.golpear(new HaciaAbajo()));
        btnGolpearArriba.setOnAction( e -> controlador.golpear(new HaciaArriba()));

        // Teclado
        main.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.E) {
                controladorDeEscena.activate("inventario");

            }
            if (event.getCode() == KeyCode.ESCAPE) {
                controladorDeEscena.activate("main");
            }
            if (event.getCode() == KeyCode.W) {
                controlador.mover(new HaciaArriba());
            }
            if (event.getCode() == KeyCode.A) {
                controlador.mover(new HaciaIzquierda());
            }
            if (event.getCode() == KeyCode.S) {
                controlador.mover(new HaciaAbajo());
            }
            if (event.getCode() == KeyCode.D) {
                controlador.mover(new HaciaDerecha());
            }
            if (event.getCode() == KeyCode.UP) {
                controlador.golpear(new HaciaArriba());
            }
            if (event.getCode() == KeyCode.LEFT) {
                controlador.golpear(new HaciaIzquierda());
            }
            if (event.getCode() == KeyCode.DOWN) {
                controlador.golpear(new HaciaAbajo());
            }
            if (event.getCode() == KeyCode.RIGHT) {
                controlador.golpear(new HaciaDerecha());
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
