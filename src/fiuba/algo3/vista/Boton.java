package fiuba.algo3.vista;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Boton extends Button {

    public Boton(Image imagen) {
        super();
        this.setGraphic(new ImageView(imagen));
    }

    public Boton(String text) {
        super();
        this.setGraphic(new Label(text));
    }

    public void cambiarImagen(Image imagen) {
        this.setGraphic(new ImageView(imagen));
    }



}
