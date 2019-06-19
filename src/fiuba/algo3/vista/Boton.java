package fiuba.algo3.vista;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Boton extends Button {

    public Boton(String text) {
        super();
        this.setGraphic(new Label(text));
    }
}
