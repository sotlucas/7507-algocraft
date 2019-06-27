package fiuba.algo3.modelo;

public class DesgasteNormal extends Desgaste{

    private int fuerza;

    public DesgasteNormal(double durabilidadInicial, int fuerza)
    {
        this.durabilidad = durabilidadInicial;
        this.fuerza = fuerza;
        this.factor = 1;
    }

    public DesgasteNormal(double durabilidadInicial, int fuerza, double factorDesgaste)
    {
        this.durabilidad = durabilidadInicial;
        this.fuerza = fuerza;
        this.factor = factorDesgaste;
    }

    public double desgastar()
    {
        durabilidad -= fuerza/factor;
        return durabilidad;
    }
}
