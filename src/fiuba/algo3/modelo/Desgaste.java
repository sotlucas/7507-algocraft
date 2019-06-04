package fiuba.algo3.modelo;

public class Desgaste {

    private int durabilidad;
    private int fuerza;
    private int factorDesgaste;

    public Desgaste(int durabilidadInicial, int fuerza){

        this.durabilidad = durabilidadInicial;
        this.fuerza = fuerza;
        this.factorDesgaste = 1;
    }

    public Desgaste(int durabilidadInicial, int fuerza, int factorDesgaste){

        this.durabilidad = durabilidadInicial;
        this.fuerza = fuerza;
        this.factorDesgaste = factorDesgaste;
    }

    public int desgastar() {

        durabilidad -= fuerza/factorDesgaste;

        return durabilidad;
    }
}
