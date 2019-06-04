package fiuba.algo3.modelo;

public class Pico extends Herramienta {

    public Pico(Madera madera) {
        this.durabilidad = 100;
        this.fuerza = 2;
        this.material = madera;
    }

    public Pico(Piedra piedra) {
        this.durabilidad = 200;
        this.fuerza = 4;
        this.material = piedra;
    }

    public Pico(Metal metal) {
        this.durabilidad = 400;
        this.fuerza = 12;
        this.material = metal;
    }

}
