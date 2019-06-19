package fiuba.algo3.vista;

import fiuba.algo3.controlador.ControladorDeEscena;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Juego {

    private VBox main;

    public Juego(ControladorDeEscena controladorDeEscena) {
        main = new VBox();
        main.setId("juego-escena");

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

        // Main game
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        for(int row = 0; row < 15 ; row++)
        {
            for(int col = 30; col >= 0 ; col--)
            {
                ImageView imageView;
                if((col == 15 && row == 0)) {
                    imageView = new ImageView(new Image(getClass().getResourceAsStream("../../../res/jugador.png"), 32, 0, true, true));
                } else if ((col * row % 2 == 0)) {
                    imageView = new ImageView(new Image(getClass().getResourceAsStream("../../../res/piedra_bloque.png"), 32, 0, true, true));
                } else {
                    imageView = new ImageView(new Image(getClass().getResourceAsStream("../../../res/diamante_bloque.png"), 32, 0, true, true));
                }
                imageView.setId("bloque");
                imageView.setOnMouseClicked(e -> {
                    imageView.setOpacity(0);
                });

                grid.add(imageView, col, row);
            }
        }

        main.setAlignment(Pos.CENTER);
        main.getChildren().addAll(menu, grid);

        main.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.E) {
                controladorDeEscena.activate("inventario");
            }
            if (event.getCode() == KeyCode.ESCAPE) {
                controladorDeEscena.activate("main");
            }

        });
    }

    public Pane getPane() {
        return this.main;
    }
}
