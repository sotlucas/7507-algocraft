package fiuba.algo3.ejemplo1;

public class Pico extends Herramienta {

    public Pico (MaterialHerramienta material) {
        this.durabilidad = 100;
        this.fuerza = 2;
        this.material = material;
    }

    public int getDurabilidad() {
        return this.durabilidad;
    }

    public int getFuerza() {
        return this.fuerza;
    }

    public MaterialHerramienta getMaterial() { return this.material; }
}
