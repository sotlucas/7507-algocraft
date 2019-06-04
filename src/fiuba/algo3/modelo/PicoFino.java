package fiuba.algo3.modelo;

public class PicoFino extends Herramienta {

    public PicoFino(Piedra piedra) {
        this.durabilidad = 1000;
        this.fuerza = 20;
        this.material = piedra;
    }

    public PicoFino(Metal metal) {
        this.durabilidad = 1000;
        this.fuerza = 20;
        this.material = metal;
    }

    public int getDurabilidad() {
        return this.durabilidad;
    }

    public int getFuerza() {
        return this.fuerza;
    }

    public MaterialHerramienta getMaterial() { return this.material; }
}
