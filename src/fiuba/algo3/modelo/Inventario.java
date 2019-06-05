package fiuba.algo3.modelo;

import java.util.ArrayList;

public class Inventario {

    private ArrayList<Herramienta> herramientas;

    public Inventario() {
        this.herramientas = new ArrayList<>();
    }

    public void agregarHerramienta(Herramienta herramienta) {
        this.herramientas.add(herramienta);
    }

    public boolean contiene(Herramienta herramienta) {
        for (int i = 0; i < this.herramientas.size(); i++) {
            if (herramienta.getClass() == this.herramientas.get(i).getClass()) {
                return true;
            }
        }
        return false;
    }
}
