package fiuba.algo3.controlador;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import java.util.HashMap;

public class ControladorDeEscena {
    private HashMap<String, Pane> escenas = new HashMap<>();
    private Scene main;

    public ControladorDeEscena(Scene main) {
        this.main = main;
    }

    public void agregarEscena(String nombre, Pane pane){
        escenas.put(nombre, pane);
    }

    public void eliminarEscena(String nombre){
        escenas.remove(nombre);
    }

    public void activate(String nombre){
        main.setRoot(escenas.get(nombre));
    }
}

