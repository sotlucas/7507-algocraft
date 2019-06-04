package fiuba.algo3.ejemplo1;

public abstract class Herramienta {
    public int durabilidad;
    public int fuerza;
    public MaterialHerramienta material;

    public abstract int getFuerza();
    public abstract int getDurabilidad();
    public abstract MaterialHerramienta getMaterial();
}
