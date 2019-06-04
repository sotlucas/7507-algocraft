package fiuba.algo3.modelo;

public abstract class Herramienta {

    public int durabilidad;
    public int fuerza;
    public MaterialHerramienta material;

    public abstract int getFuerza();
    public abstract int getDurabilidad();
    public abstract MaterialHerramienta getMaterial();
}
