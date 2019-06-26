package fiuba.algo3.vista.animacion;

import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class VaivenTransition {

    private ScaleTransition transicion;

    public VaivenTransition(Node nodo) {
        transicion = new ScaleTransition(Duration.millis(800), nodo);
        transicion.setFromX(1f);
        transicion.setByX(.05f);
        transicion.setFromY(1f);
        transicion.setByY(.05f);
        transicion.setCycleCount(Animation.INDEFINITE);
        transicion.setAutoReverse(true);
    }

    public void play() {
        transicion.playFromStart();
    }
}
