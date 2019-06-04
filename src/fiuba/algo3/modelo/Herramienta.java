package fiuba.algo3.modelo;

public abstract class Herramienta {

    protected double durabilidad;
    protected int fuerza;
    protected MaterialHerramienta material;
    protected Desgaste desgaste;

    //public abstract void usarEn(Bloque bloqueMaterial);

    public int getFuerza(){
        return fuerza;
    }

    public double getDurabilidad(){
        return durabilidad;
    }
    public MaterialHerramienta getMaterial(){
        return material;
    }
}
