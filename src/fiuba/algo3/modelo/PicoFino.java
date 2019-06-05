package fiuba.algo3.modelo;

public class PicoFino extends Herramienta {

    public PicoFino() {
        this.durabilidad = 1000;
        this.fuerza = 20;
        this.material = null; // ver si creamos nuevo material
    }

    public double getDurabilidad() {
        return this.durabilidad;
    }

    public int getFuerza() {
        return this.fuerza;
    }

    public MaterialHerramienta getMaterial() { return this.material; }
}
