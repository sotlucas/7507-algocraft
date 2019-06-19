package fiuba.algo3.vista;

import fiuba.algo3.controlador.ControladorDeEscena;
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

        // Cierra correctamente el programa con la "x" de la ventana
        primaryStage.setOnCloseRequest(e -> Platform.exit());

        // Logo
        ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("../../../res/logo_mc.png"), 600, 0, true, true));
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
        primaryStage.setTitle("AlgoCraft - v.0.0.1");
        primaryStage.setScene(scene);
        scene.getStylesheets().add(AlgoCraft.class.getResource("../../../res/AlgoCraft.css").toExternalForm());
        primaryStage.show();

        // Inicialiazo controlador de escena
        ControladorDeEscena controladorDeEscena = new ControladorDeEscena(scene);
        controladorDeEscena.agregarEscena("main", border);
        controladorDeEscena.agregarEscena("inventario", (new Inventario(scene, controladorDeEscena)).getPane());
        controladorDeEscena.agregarEscena("juego", (new Juego(controladorDeEscena)).getPane());
        controladorDeEscena.agregarEscena("creditos", (new Creditos(scene, controladorDeEscena)).getPane());
        btnJugar.setOnAction(e -> {
                controladorDeEscena.activate("juego");
        });
        btnCreditos.setOnAction(e -> {
                controladorDeEscena.activate("creditos");
        });
        btnSalir.setOnAction(e -> {
            Platform.exit();
        });
    }
}
