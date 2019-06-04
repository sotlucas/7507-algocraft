package fiuba.algo3.modelo;

public class Hacha extends Herramienta{

    public Hacha (Madera madera) {
        this.durabilidad = 100;
        this.fuerza = 2;
    }

    public int getDurabilidad() {
        return this.durabilidad;
    }

    public int getFuerza() {
        return this.fuerza;
    }

    public MaterialHerramienta getMaterial() { return this.material; }
}
