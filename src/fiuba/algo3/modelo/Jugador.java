package fiuba.algo3.modelo;

public class Jugador implements Elemento {

    private Inventario inventario;
    private Posicion posicion;

    public Jugador() {
        this.inventario = new Inventario();
        this.posicion = new Posicion();
        this.inventario.agregarHerramienta(new Hacha(new Madera()));
    }

    public boolean inventarioContiene(Herramienta herramienta) {
        return this.inventario.contiene(herramienta);
    }

    public void avanzar(Mapa mapa, Direccion direccion) {
        direccion.avanzar(mapa, this);
    }

    public void setPosicion(int fila, int columna) {
        this.posicion.setColumna(columna);
        this.posicion.setFila(fila);
    }

    public int getPosicionColumna() {
        return this.posicion.getColumna();
    }

    public int getPosicionFila() {
        return this.posicion.getFila();
    }
}
