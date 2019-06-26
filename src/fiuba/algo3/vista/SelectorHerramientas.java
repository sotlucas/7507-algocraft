package fiuba.algo3.vista;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ProgressBar;
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
                new Image(getClass().getResourceAsStream("../../../res/casilla_selector.png"), 48, 0, true, true));
        stackBack.getChildren().add(imageView);
        this.add(stackBack, pos, 0);
        stackBack.setId("casilla");
    }

    private void agregarCasillaSeleccionada(int pos) {
        StackPane stackBack = new StackPane();
        ImageView imageView = new ImageView(
                new Image(getClass().getResourceAsStream("../../../res/seleccionado.png"), 54, 0, true, true));
        stackBack.getChildren().add(imageView);
        this.add(stackBack, pos, 0);
        stackBack.setId("casilla");
    }

    public void agregar(String elemento, int pos, double durabilidad) {
        // Imagen de herramienta
        StackPane herramienta = new StackPane();
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("../../../res/"+elemento+".png"), 38, 0, true, true));
        herramienta.getChildren().add(imageView);

        // Barra de vida de la herramienta
        StackPane contenedorVida = new StackPane();
        contenedorVida.setAlignment(Pos.BOTTOM_CENTER);
        contenedorVida.setId("durabilidad-herramienta");
        DoubleProperty vidaHerramienta = new SimpleDoubleProperty(durabilidad);
        ProgressBar barraDeVida = new ProgressBar();
        barraDeVida.setPrefSize(35, 1);
        barraDeVida.progressProperty().bind(vidaHerramienta.divide(100));
        contenedorVida.getChildren().add(barraDeVida);

        this.add(herramienta, pos, 0);
        this.add(contenedorVida, pos, 0);
        herramienta.setId("casilla");
    }

    public void agregarSeleccionado(String elemento, int pos, double durabilidad) {
        this.agregarCasillaSeleccionada(pos);
        this.agregar(elemento, pos, durabilidad);
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
