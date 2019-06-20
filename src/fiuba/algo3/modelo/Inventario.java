package fiuba.algo3.modelo;

import java.util.ArrayList;

public class Inventario {

    private ArrayList<Herramienta> herramientas;
    private ArrayList<Material> materiales;

    public Inventario() {
        this.herramientas = new ArrayList<>();
        this.materiales = new ArrayList<>();
    }

    public void agregarHerramienta(Herramienta herramienta) {
        this.herramientas.add(herramienta);
    }

    public void agregarMaterial(Material material) {
        this.materiales.add(material);
    }

    public boolean contieneHerramienta(Herramienta herramienta) {

        int indice = 0;
        boolean herramientaEncontrada = false;

        while((!herramientaEncontrada) && (indice < herramientas.size())){

            if (herramienta.getClass() == this.herramientas.get(indice).getClass()) {
                herramientaEncontrada = true;
            }

            indice++;

        }

        return herramientaEncontrada;
    }

    public boolean contieneMaterial(Material material) {

        int indice = 0;
        boolean materialEncontrado = false;

        while((!materialEncontrado) && (indice < materiales.size())){

            if (material.getClass() == this.materiales.get(indice).getClass()) {
                materialEncontrado = true;
            }

            indice++;

        }

        return materialEncontrado;
    }

    public Material seleccionarMaterial(int posicion) {
        return materiales.get(posicion);
    }

    public Herramienta seleccionarHerramienta(int posicion) {
        return herramientas.get(posicion);
    }
}
