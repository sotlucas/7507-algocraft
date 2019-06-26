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
    private Jugador jugador;

    public ControladorDeInventario(Inventario inventario, InventarioVista inventarioVista, SelectorHerramientas selectorHerramientas, Jugador jugador) {
        this.materiales = inventario.getMateriales();
        this.herramientas = inventario.getHerramientas();
        this.selectorHerramientas = selectorHerramientas;
        this.inventarioVista = inventarioVista;
        this.jugador = jugador;
        inicializarHash();
        inventarioVista.setControlador(this);

        this.selectorHerramientas.setOnMouseClicked(e -> {
            Integer posicion = selectorHerramientas.getPosicion(e);
            if (posicion != null) {
                System.out.println(posicion);
                jugador.seleccionarHerramienta(posicion);
                this.actualizarSelectorHerramientas();
            }
        });
    }

    public void actualizarVista() {
        this.actualizarInventario();
        this.actualizarSelectorHerramientas();
    }

    private void actualizarInventario() {
        this.inventarioVista.limpiar();
        int j = -1;
        for (int i = 0; i < this.materiales.size(); i++) {
            if (i % 9 == 0) {
                j++;
            }
            inventarioVista.agregar(materialesHash.get(this.materiales.get(i).getIdentificador()), i % 9, j);
        }
    }

    private void actualizarSelectorHerramientas() {
        this.selectorHerramientas.limpiar();
        for (int i = 0; i < herramientas.size(); i++) {
            Herramienta herramientaActual = jugador.getHerramientaSeleccionada();
            if (herramientaActual != null && herramientaActual.equals(herramientas.get(i))) {
                this.selectorHerramientas.agregarSeleccionado(herramientas.get(i).getIdentificador(), i, herramientas.get(i).getDurabilidad());
            } else {
                this.selectorHerramientas.agregar(herramientas.get(i).getIdentificador(), i, herramientas.get(i).getDurabilidad());
            }
        }
    }

    private void inicializarHash() {
        this.materialesHash.put('m', "madera");
        this.materialesHash.put('p', "piedra");
        this.materialesHash.put('M', "metal");
        this.materialesHash.put('d', "diamante");
    }

    public void agregarAMesaCrafteo(char identificador, int pos, int pos_material){
        Material[] materiales = new Material[4];
        materiales[0] = new Madera();
        materiales[1] = new Metal();
        materiales[2] = new Piedra();
        materiales[3] = new Diamante();
        Material material = null;
        int index = 0;
        while (material == null || index < 4){
            if (identificador == materiales[index].getIdentificador()){
                jugador.seleccionarMaterial(pos_material);
                break;
            }
            index++;
        }
        jugador.colocarEnMesa(pos);
    }

    public void crearHerramienta() {
        jugador.craftear();
    }

    public void vaciarMesa(){
        this.jugador.vaciarMesa();
    }

    public void quitarDelInventario() {
        this.jugador.quitarDelInventarioLoQueHayEnLaMesa();
    }
}
