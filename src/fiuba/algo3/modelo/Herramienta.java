package fiuba.algo3.modelo;

public abstract class Herramienta {

    protected double durabilidad;
    protected int fuerza;
    protected Material material;
    protected Desgaste desgaste;
    protected int fuerzaEspecialContraMetal;

    public int getFuerza(){
        return fuerza;
    }

    public double getDurabilidad(){
        return durabilidad;
    }

    public Material getMaterial(){
        return material;
    }
}
