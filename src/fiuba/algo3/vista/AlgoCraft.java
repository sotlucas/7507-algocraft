package fiuba.algo3.vista;

import fiuba.algo3.controlador.ControladorDeEscena;
import fiuba.algo3.controlador.ControladorDeInventario;
import fiuba.algo3.controlador.ControladorJuego;
import fiuba.algo3.modelo.Juego;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Madera;
import fiuba.algo3.modelo.Metal;
import fiuba.algo3.modelo.Piedra;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
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
        Boton btnOpciones = new Boton("Opciones");
        Boton btnCreditos = new Boton("Creditos");
        Boton btnSalir = new Boton("Salir del Juego");

        btnJugar.setMaxWidth(Double.MAX_VALUE);
        btnOpciones.setMaxWidth(Double.MAX_VALUE);
        btnCreditos.setMaxWidth(Double.MAX_VALUE);
        btnSalir.setMaxWidth(Double.MAX_VALUE);

        // Agrego botones a VBox
        VBox vbButtons = new VBox();
        vbButtons.setAlignment(Pos.CENTER);
        vbButtons.setSpacing(10);
        vbButtons.setPadding(new Insets(0, 20, 10, 20));
        vbButtons.getChildren().addAll(logo, btnJugar, btnOpciones, btnCreditos, btnSalir);

        // Agrego VBox al BorderPane
        border.setCenter(vbButtons);

        Scene scene = new Scene(border, 832, 512);
        primaryStage.setTitle("Algocraft 0.0.1");
        primaryStage.getIcons().add(new Image(AlgoCraft.class.getResourceAsStream("../../../res/icon.png")));
        primaryStage.setScene(scene);
        scene.getStylesheets().add(AlgoCraft.class.getResource("../../../res/AlgoCraft.css").toExternalForm());
        primaryStage.show();

        // Inicialiazo controlador de escena y vistas
        ControladorDeEscena controladorDeEscena = new ControladorDeEscena(scene);
        InventarioVista inventarioVista = new InventarioVista(scene, controladorDeEscena);
        JuegoVista juegoVista = new JuegoVista(controladorDeEscena);
        Creditos creditosVista = new Creditos(scene, controladorDeEscena);
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
        jugador.agregarMaterialAInventario(new Piedra());
        jugador.agregarMaterialAInventario(new Madera());
        jugador.agregarMaterialAInventario(new Metal());
        jugador.agregarMaterialAInventario(new Madera());
        jugador.agregarMaterialAInventario(new Madera());
        jugador.agregarMaterialAInventario(new Metal());
        jugador.agregarMaterialAInventario(new Madera());
        jugador.agregarMaterialAInventario(new Madera());
        jugador.agregarMaterialAInventario(new Metal());
        jugador.agregarMaterialAInventario(new Madera());
        jugador.agregarMaterialAInventario(new Madera());
        jugador.agregarMaterialAInventario(new Metal());
        jugador.agregarMaterialAInventario(new Madera());
        jugador.agregarMaterialAInventario(new Piedra());
        jugador.agregarMaterialAInventario(new Madera());
        jugador.agregarMaterialAInventario(new Metal());
        jugador.agregarMaterialAInventario(new Madera());
        jugador.agregarMaterialAInventario(new Madera());
        jugador.agregarMaterialAInventario(new Metal());
        jugador.agregarMaterialAInventario(new Madera());
        jugador.agregarMaterialAInventario(new Madera());
        jugador.agregarMaterialAInventario(new Metal());
        jugador.agregarMaterialAInventario(new Madera());
        jugador.agregarMaterialAInventario(new Madera());
        jugador.agregarMaterialAInventario(new Metal());
        jugador.agregarMaterialAInventario(new Madera());
        ControladorDeInventario controladorDeInventario = new ControladorDeInventario(jugador.getInventario(), inventarioVista);
        // Actualizar vistas
        controladorDeInventario.actualizarVista();

        ControladorJuego controladorJuego = new ControladorJuego(juego, juegoVista);
        controladorJuego.actualizarVista();
    }
}
