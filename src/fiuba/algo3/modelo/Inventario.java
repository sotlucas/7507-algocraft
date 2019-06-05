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

        int indice = 0;
        boolean herramientaEncontrada = false;

        while((!herramientaEncontrada) && (indice < herramientas.size())){

            if (herramienta.getClass() == this.herramientas.get(indice).getClass()) {
                herramientaEncontrada = true;
            }

            indice++;

        }

        return herramientaEncontrada;
/*
        for (int i = 0; i < this.herramientas.size(); i++) {
            if (herramienta.getClass() == this.herramientas.get(i).getClass()) {
                return true;
            }
        }
        return false;*/
    }
}
