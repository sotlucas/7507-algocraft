package fiuba.algo3.vista;

import fiuba.algo3.controlador.ControladorDeEscena;
import fiuba.algo3.controlador.ControladorDeInventario;
import fiuba.algo3.controlador.ControladorJuego;
import fiuba.algo3.modelo.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AlgoCraft extends Application {

    @Override
    public void start(Stage primaryStage) {
        Font.loadFont(getClass().getResourceAsStream("../../../res/fonts/Minecraft-Regular.otf"), 10);

        BorderPane border = new BorderPane();
        border.setPadding(new Insets(20, 0, 20, 20));
        border.setId("background");

        // Logo
        ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("../../../res/algocraft.png"), 600, 0, true, true));
        logo.setId("logo");

        // Botones
        Boton btnJugar = new Boton("Jugar");
        Boton btnCreditos = new Boton("Creditos");
        Boton btnSalir = new Boton("Salir del Juego");

        btnJugar.setMaxWidth(Double.MAX_VALUE);
        btnCreditos.setMaxWidth(Double.MAX_VALUE);
        btnSalir.setMaxWidth(Double.MAX_VALUE);

        // Agrego botones a VBox
        VBox vbButtons = new VBox();
        vbButtons.setAlignment(Pos.CENTER);
        vbButtons.setSpacing(10);
        vbButtons.setPadding(new Insets(0, 20, 10, 20));
        vbButtons.getChildren().addAll(logo, btnJugar, btnCreditos, btnSalir);

        // Copyright
        Label copyright = new Label("TP2 Algoritmos 3 FIUBA. Do not distribute!");
        copyright.setAlignment(Pos.BOTTOM_CENTER);

        // Agrego lo anterior al BorderPane
        border.setCenter(vbButtons);
        border.setBottom(copyright);

        Scene scene = new Scene(border, 832, 512);
        primaryStage.setTitle("Algocraft 0.0.1");
        primaryStage.getIcons().add(new Image(AlgoCraft.class.getResourceAsStream("../../../res/icon.png")));
        primaryStage.setScene(scene);
        scene.getStylesheets().add(AlgoCraft.class.getResource("../../../res/AlgoCraft.css").toExternalForm());
        primaryStage.show();

        // Inicialiazo controlador de escena y vistas
        ControladorDeEscena controladorDeEscena = new ControladorDeEscena(scene);
        SelectorHerramientas selectorHerramientas = new SelectorHerramientas();
        InventarioVista inventarioVista = new InventarioVista(controladorDeEscena);
        JuegoVista juegoVista = new JuegoVista(controladorDeEscena, selectorHerramientas);
        Creditos creditosVista = new Creditos(controladorDeEscena);
        controladorDeEscena.agregarEscena("main", border);
        controladorDeEscena.agregarEscena("inventario", inventarioVista.getPane());
        controladorDeEscena.agregarEscena("juego", juegoVista.getPane());
        controladorDeEscena.agregarEscena("creditos", creditosVista.getPane());
        btnJugar.setOnAction(e -> {
            controladorDeEscena.activate("juego");
        });
        btnCreditos.setOnAction(e -> {
            controladorDeEscena.activate("creditos");
        });
        btnSalir.setOnAction(e -> {
            Platform.exit();
        });

        // PRUEBA
        Juego juego = new Juego();
        Jugador jugador = juego.getJugador();
        jugador.agregarHerramientaAInventario(new Pico(new Piedra()));
        ControladorDeInventario controladorDeInventario = new ControladorDeInventario(jugador.getInventario(), inventarioVista, selectorHerramientas,juego.getJugador());
        controladorDeInventario.actualizarVista();

        ControladorJuego controladorJuego = new ControladorJuego(juego, juegoVista, controladorDeInventario);
        controladorJuego.actualizarVista();
    }
}
