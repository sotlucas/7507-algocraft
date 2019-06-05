package fiuba.algo3.modelo;

public class Jugador {

    Inventario inventario;

    public Jugador() {
        this.inventario = new Inventario();
        this.inventario.agregarHerramienta(new Hacha(new Madera()));
    }

    public boolean inventarioContiene(Herramienta herramienta) {
        return this.inventario.contiene(herramienta);
    }
}
