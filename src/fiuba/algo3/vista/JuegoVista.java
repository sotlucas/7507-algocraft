package fiuba.algo3.vista;

import fiuba.algo3.controlador.ControladorDeEscena;
import fiuba.algo3.controlador.ControladorMapa;
import fiuba.algo3.modelo.Juego;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;

public class JuegoVista {

    GridPane mapa;
    ControladorMapa controlador;

    private BorderPane main;

    public JuegoVista(ControladorDeEscena controladorDeEscena) {
        main = new BorderPane();
        main.setId("juego-escena");

        this.mapa = new GridPane();
        mapa.setAlignment(Pos.CENTER);
        // Top menu
        HBox menu = new HBox();
        menu.setAlignment(Pos.CENTER);
        Boton btnInventario = new Boton("Inventario - [E]");
        Boton btnMenu = new Boton("Menu - [ESC]");
        btnInventario.setOnAction(e -> {
            controladorDeEscena.activate("inventario");
        });
        btnMenu.setOnAction(e -> {
            controladorDeEscena.activate("main");
        });
        menu.getChildren().addAll(btnMenu, btnInventario);

        //Botones para moverse

        VBox flechas = new VBox();
        flechas.setAlignment(Pos.BOTTOM_CENTER);
        HBox flechasAbajo = new HBox();
        Boton btnIzquierda = new Boton("A");
        Boton btnDerecha = new Boton("D");
        Boton btnAbajo = new Boton("S");
        flechasAbajo.getChildren().addAll(btnIzquierda,btnAbajo,btnDerecha);
        Boton btnArriba = new Boton("W");
        flechas.getChildren().addAll(btnArriba, flechasAbajo);

        btnIzquierda.setOnAction( e -> {
            controlador.moverIzquierda();
        });
        btnDerecha.setOnAction( e -> {
            controlador.moverDerecha();
        });
        btnAbajo.setOnAction( e -> {
            controlador.moverAbajo();
        });
        btnArriba.setOnAction( e -> {
            controlador.moverArriba();
        });
        //Boton pegar
        Boton pegar = new Boton("Pegar");

        // Main game
        main.setTop(menu);
        main.setCenter(mapa);
        main.setLeft(flechas);
        main.setRight(pegar);
        main.setAlignment(pegar, Pos.BOTTOM_CENTER);

        main.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.E) {
                controladorDeEscena.activate("inventario");
            }
            if (event.getCode() == KeyCode.ESCAPE) {
                controladorDeEscena.activate("main");
            }

        });
    }

    private ImageView getImagen(String nombre, int tamanio) {
        return new ImageView(new Image(getClass().getResourceAsStream("../../../res/"+nombre+".png"), tamanio, 0, true, true));
    }

    public Pane getPane() {
        return this.main;
    }

    public void agregarElemento(String nombreImagen, int fila, int col) {
        ImageView img = new ImageView(new Image(getClass().getResourceAsStream("../../../res/"+nombreImagen+".png"), 32, 0, true, true));
        mapa.add(img, col, fila);
    }

    public void setControlador(ControladorMapa controlador) {
        this.controlador = controlador;
    }
}
