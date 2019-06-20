package fiuba.algo3.controlador;

import fiuba.algo3.modelo.Herramienta;
import fiuba.algo3.modelo.Inventario;
import fiuba.algo3.modelo.Material;
import fiuba.algo3.vista.InventarioVista;

import java.util.ArrayList;
import java.util.HashMap;

public class ControladorDeInventario {

    private Inventario inventario;
    private InventarioVista inventarioVista;
    private HashMap<Character, String> materialesHash = new HashMap<>();

    public ControladorDeInventario(Inventario inventario, InventarioVista inventarioVista) {
        this.inventario = inventario;
        this.inventarioVista = inventarioVista;
        inicializarHash();
    }

    public void actualizarVista() {
        ArrayList<Material> materiales = inventario.getMateriales();
        ArrayList<Herramienta> herramientas = inventario.getHerramientas();

        int j = -1;
        for (int i = 0; i < materiales.size(); i++) {
            if (i % 9 == 0) {
                j++;
            }
            inventarioVista.agregar(materialesHash.get(materiales.get(i).getIdentificador()), i % 9, j);
        }
        for (int i = 0; i < herramientas.size(); i++) {
            inventarioVista.agregar(herramientas.get(i).getIdentificador(), i, i % 9);
        }
    }

    private void inicializarHash() {
        this.materialesHash.put('m', "madera");
        this.materialesHash.put('p', "piedra");
        this.materialesHash.put('M', "metal");
        this.materialesHash.put('d', "diamante");
    }


}
