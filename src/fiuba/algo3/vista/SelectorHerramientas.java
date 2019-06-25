package fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class SelectorHerramientas extends GridPane {

    public SelectorHerramientas() {
        this.setAlignment(Pos.TOP_CENTER);
        for (int i = 0; i < 9; i++)
            this.agregarCasilla(i);
    }

    private void agregarCasilla(int pos) {
        StackPane stackBack = new StackPane();
        ImageView imageView = new ImageView(
                new Image(getClass().getResourceAsStream("../../../res/casilla.png"), 48, 0, true, true));
        stackBack.getChildren().add(imageView);
        this.add(stackBack, pos, 0);
        stackBack.setId("casilla");
    }

    public void agregar(String elemento, int pos) {
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("../../../res/"+elemento+".png"), 38, 0, true, true));
        this.add(imageView, pos, 0);
    }

    public Integer getPosicion(MouseEvent event) {
        Node nodoClickeado = event.getPickResult().getIntersectedNode();
        return GridPane.getColumnIndex(nodoClickeado);
    }

    public void limpiar() {
        this.getChildren().clear();
        for (int i = 0; i < 9; i++)
            this.agregarCasilla(i);
    }

}
