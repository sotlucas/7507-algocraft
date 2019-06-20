package fiuba.algo3.modelo;

public class Jugador implements Posicionable{

    private MesaCrafteo mesaDeCrafteo;
    private Inventario inventario;
    private Posicion posicion;
    private Material materialSeleccionado = null;
    private boolean estaPosicionado;
    private Mapa mapa;
    // El siguiente es un atributo que deberia tener:
    private Herramienta herramientaSeleccionada;

    public Jugador(){
        this.mesaDeCrafteo = new MesaCrafteo();
        this.inventario = new Inventario();
        this.posicion = new Posicion();
        this.inventario.agregarHerramienta(new Hacha(new Madera()));
        this.estaPosicionado = false;
        //Provisorio:
        this.herramientaSeleccionada = new Hacha(new Madera());
    }

    public Jugador(Mapa mapa) {
        this.mesaDeCrafteo = new MesaCrafteo();
        this.inventario = new Inventario();
        this.posicion = new Posicion();
        this.inventario.agregarHerramienta(new Hacha(new Madera()));
        this.estaPosicionado = false;
        this.mapa = mapa;
        this.herramientaSeleccionada = new Hacha(new Madera());
    }

    public boolean inventarioContieneHerramienta(Herramienta herramienta) {
        return this.inventario.contieneHerramienta(herramienta);
    }

    public boolean inventarioContieneMaterial(Material material) {
        return this.inventario.contieneMaterial(material);
    }

    public void avanzar(Direccion direccion) {
        direccion.avanzar(mapa, this);
    }

    public void setPosicion(int fila, int columna) {

        this.posicion.setColumna(columna);
        this.posicion.setFila(fila);
        this.estaPosicionado = true;
    }

    public int getPosicionColumna() {
        return this.posicion.getColumna();
    }

    public int getPosicionFila() {
        return this.posicion.getFila();
    }

    public void seleccionarMaterial(int posicion) {
        this.materialSeleccionado = this.inventario.seleccionarMaterial(posicion);
    }

    public void colocarEnMesa(int posicion) {
        this.mesaDeCrafteo.colocar(this.materialSeleccionado, posicion); 
    }

    public void craftear() {
        this.inventario.agregarHerramienta(this.mesaDeCrafteo.construir());
    }

    public void agregarMaterialAInventario(Material material) {
        this.inventario.agregarMaterial(material);
    }

    public void agregarHerramientaAInventario(Herramienta herramienta) {
        this.inventario.agregarHerramienta(herramienta);
    }

    public boolean estaPosicionado(){ return this.estaPosicionado;}

    // ---------- EL JUGADOR TENDRIA QUE TENER ESTOS METODOS:

    public void golpear(Direccion direccion){

        direccion.golpear(mapa, herramientaSeleccionada, this);
    }

    public double getDurabilidadHerramientaActual() {
        return this.herramientaSeleccionada.getDurabilidad();
    }

    public Inventario getInventario() {
        return this.inventario;
    }
}
