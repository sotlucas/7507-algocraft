package fiuba.algo3.controlador;

import fiuba.algo3.modelo.Herramienta;
import fiuba.algo3.modelo.Inventario;
import fiuba.algo3.modelo.Material;
import fiuba.algo3.vista.InventarioVista;
import fiuba.algo3.vista.SelectorHerramientas;

import java.util.ArrayList;
import java.util.HashMap;

public class ControladorDeInventario {

    private SelectorHerramientas selectorHerramientas;
    private ArrayList<Material> materiales;
    private ArrayList<Herramienta> herramientas;
    private InventarioVista inventarioVista;
    private HashMap<Character, String> materialesHash = new HashMap<>();

    public ControladorDeInventario(Inventario inventario, InventarioVista inventarioVista, SelectorHerramientas selectorHerramientas) {
        this.materiales = inventario.getMateriales();
        this.herramientas = inventario.getHerramientas();
        this.selectorHerramientas = selectorHerramientas;
        this.inventarioVista = inventarioVista;
        inicializarHash();
    }

    public void actualizarVista() {
        this.inventarioVista.limpiar();
        int j = -1;
        for (int i = 0; i < this.materiales.size(); i++) {
            if (i % 9 == 0) {
                j++;
            }
            inventarioVista.agregar(materialesHash.get(this.materiales.get(i).getIdentificador()), i % 9, j);
        }

        this.selectorHerramientas.limpiar();
        for (int i = 0; i < herramientas.size(); i++) {
            this.selectorHerramientas.agregar(herramientas.get(i).getIdentificador(), i);
        }
    }

    private void inicializarHash() {
        this.materialesHash.put('m', "madera");
        this.materialesHash.put('p', "piedra");
        this.materialesHash.put('M', "metal");
        this.materialesHash.put('d', "diamante");
    }

}
