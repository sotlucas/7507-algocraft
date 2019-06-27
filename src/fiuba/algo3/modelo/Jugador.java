package fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador implements Posicionable{

    private MesaCrafteo mesaDeCrafteo;
    private Inventario inventario;
    private Posicion posicion;
    private Material materialSeleccionado = null;
    private boolean estaPosicionado;
    private Mapa mapa;
    private Herramienta herramientaSeleccionada;
    private char identificador;

    public Jugador()
    {
        this.mesaDeCrafteo = new MesaCrafteo();
        this.inventario = new Inventario();
        this.posicion = new Posicion();
        this.inventario.agregarHerramienta(new Hacha(new Madera()));
        this.estaPosicionado = false;
        this.seleccionarHerramienta(0);
        this.identificador = 'j';
    }

    public Jugador(Mapa mapa)
    {
        this();
        this.mapa = mapa;
    }

    public boolean inventarioContieneHerramienta(Herramienta herramienta)
    {
        return this.inventario.contieneHerramienta(herramienta);
    }

    public boolean inventarioContieneMaterial(Material material)
    {
        return this.inventario.contieneMaterial(material);
    }

    public void avanzar(Direccion direccion)
    {
        direccion.avanzar(mapa, this);
    }

    public void setPosicion(int fila, int columna)
    {
        this.posicion.setColumna(columna);
        this.posicion.setFila(fila);
        this.estaPosicionado = true;
    }

    public int getPosicionColumna()
    {
        return this.posicion.getColumna();
    }

    public int getPosicionFila()
    {
        return this.posicion.getFila();
    }

    public void seleccionarMaterial(int posicion)
    {
        this.materialSeleccionado = this.inventario.seleccionarMaterial(posicion);
    }

    public void seleccionarHerramienta(int posicion)
    {
        this.herramientaSeleccionada = this.inventario.seleccionarHerramienta(posicion);
    }

    public void deseleccionarHerramienta()
    {
        this.herramientaSeleccionada = null;
    }

    public void colocarEnMesa(int posicion)
    {
        this.mesaDeCrafteo.colocar(this.materialSeleccionado, posicion);
    }

    public void vaciarMesa()
    {
        this.mesaDeCrafteo.vaciar();
    }

    public void craftear()
    {
        this.inventario.agregarHerramienta(this.mesaDeCrafteo.construir());
    }

    public void agregarMaterialAInventario(Material material)
    {
        this.inventario.agregarMaterial(material);
    }

    public void agregarHerramientaAInventario(Herramienta herramienta)
    {
        this.inventario.agregarHerramienta(herramienta);
    }

    public boolean estaPosicionado()
    {
        return this.estaPosicionado;
    }

    public void golpear(Direccion direccion)
    {
        if(this.herramientaSeleccionada == null){
            throw new HerramientaNoSeleccionadaException();
        }

        direccion.golpear(mapa, herramientaSeleccionada, this);

        if(herramientaSeleccionada.getDurabilidad() <= 0){

            inventario.desecharHerramientaRota();
            this.herramientaSeleccionada = null;
        }
    }

    public void quitarDelInventarioLoQueHayEnLaMesa()
    {
        Material[] tablero = this.mesaDeCrafteo.getTablero();
        ArrayList<Material> inventario = this.inventario.getMateriales();

        for(Material material : tablero) {
            if (material != null) { inventario.remove(material); }
        }
    }

    public String getReceta()
    {
        return this.mesaDeCrafteo.getRecetaParaConstruir();
    }

    public double getDurabilidadHerramientaActual()
    {
        return this.herramientaSeleccionada.getDurabilidad();
    }

    public Material getMaterialSeleccionado()
    {
        return this.materialSeleccionado;
    }

    public Herramienta getHerramientaSeleccionada()
    {
        return this.herramientaSeleccionada;
    }

    public Inventario getInventario()
    {
        return this.inventario;
    }

    @Override
    public char getIdentificador()
    {
        return this.identificador;
    }


    //METODOS ADAPTADORES
    @Override
    public void recibirDanio(Hacha hacha) {}

    @Override
    public void recibirDanio(Pico pico) {}

    @Override
    public void recibirDanio(PicoFino picoFino) {}

    @Override
    public Material cederMaterial()
    {
        return null;
    }

    @Override
    public int getDurabilidad()
    {
        return 0;
    }

    @Override
    public boolean estaRoto(){
        return false;
    }
}
