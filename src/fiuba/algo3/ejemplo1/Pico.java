package fiuba.algo3.ejemplo1;

public class Pico {
    private int durabilidad;
    private int fuerza;

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
