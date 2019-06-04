package fiuba.algo3.modelo;

public class Pico extends Herramienta {

    public Pico(Madera madera) {
        this.durabilidad = 100;
        this.fuerza = 2;
    }

    public Pico(Piedra piedra) {
        this.durabilidad = 200;
        this.fuerza = 4;
    }

    public Pico(Metal metal) {
        this.durabilidad = 400;
        this.fuerza = 12;
    }

    public int getDurabilidad() {
        return this.durabilidad;
    }

    public int getFuerza() {
        return this.fuerza;
    }
}
