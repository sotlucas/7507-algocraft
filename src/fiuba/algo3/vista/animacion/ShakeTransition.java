package fiuba.algo3.vista.animacion;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class ShakeTransition {

    private TranslateTransition transicion;

    public ShakeTransition(Node nodo) {
        transicion = new TranslateTransition(Duration.millis(50), nodo);
        transicion.setFromX(0f);
        transicion.setByX(10f);
        transicion.setCycleCount(2);
        transicion.setAutoReverse(true);
    }

    public void play() {
        transicion.playFromStart();
    }
}
