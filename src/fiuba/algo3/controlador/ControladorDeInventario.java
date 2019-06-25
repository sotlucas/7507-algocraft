package fiuba.algo3.controlador;

import fiuba.algo3.modelo.*;
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
    private MesaCrafteo mesaCrafteo = new MesaCrafteo();

    public ControladorDeInventario(Inventario inventario, InventarioVista inventarioVista, SelectorHerramientas selectorHerramientas) {
        this.materiales = inventario.getMateriales();
        this.herramientas = inventario.getHerramientas();
        this.selectorHerramientas = selectorHerramientas;
        this.inventarioVista = inventarioVista;
        inicializarHash();
        inventarioVista.setControlador(this);
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

    public void agregarAMesaCrafteo(char identificador, int pos){
        Material[] materiales = new Material[4];
        materiales[0] = new Madera();
        materiales[1] = new Metal();
        materiales[2] = new Piedra();
        materiales[3] = new Diamante();
        Material material = null;
        int index = 0;
        while (material == null || index < 4){
            if (identificador == materiales[index].getIdentificador()){
                material = materiales[index];
            }
            index++;
        }
        mesaCrafteo.colocar(material, pos);
    }

    public Herramienta crearHerramienta() {
        return mesaCrafteo.construir();
    }
}
