package fiuba.algo3.modelo;

public class Desgaste {

    private double durabilidad;
    private int fuerza;
    private double factorDesgaste;

    public Desgaste(double durabilidadInicial, int fuerza){

        this.durabilidad = durabilidadInicial;
        this.fuerza = fuerza;
        this.factorDesgaste = 1;
    }

    public Desgaste(double durabilidadInicial, int fuerza, double factorDesgaste){

        this.durabilidad = durabilidadInicial;
        this.fuerza = fuerza;
        this.factorDesgaste = factorDesgaste;
    }

    public double desgastar() {

        durabilidad -= fuerza/factorDesgaste;

        return durabilidad;
    }
}
