package fiuba.algo3.modelo;

public class Pico extends Herramienta {

    public Pico (Madera madera) {
        this.durabilidad = 100;
        this.fuerza = 2;
    }

    public int getDurabilidad() {
        return this.durabilidad;
    }

    public int getFuerza() {
        return this.fuerza;
    }
}
