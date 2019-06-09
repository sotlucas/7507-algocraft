package fiuba.algo3.modelo;

public class Jugador implements Elemento {

    Inventario inventario;
    Posicion posicion;

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

    public void setPosicion(int x, int y) {
        this.posicion.setX(x);
        this.posicion.setY(y);
    }

    public int getPosicionX() {
        return this.posicion.getX();
    }

    public int getPosicionY() {
        return this.posicion.getY();
    }
}
