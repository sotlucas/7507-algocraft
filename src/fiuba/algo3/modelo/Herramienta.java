package fiuba.algo3.modelo;

public abstract class Herramienta {

    protected double durabilidad;
    protected int fuerza;
    protected Material material;
    protected Desgaste desgaste;
    protected int fuerzaEspecialContraMetal;
    protected String receta;
    protected String identificador;

    public abstract void usarEn(Posicionable posicionable);

    public int getFuerza()
    {
        return fuerza;
    }

    public double getDurabilidad()
    {
        return durabilidad;
    }

    public Material getMaterial()
    {
        return material;
    }

    public String getReceta()
    {
        return receta;
    }

    public String getIdentificador()
    {
        return this.identificador;
    }
}
























