package fiuba.algo3.modelo;

public class DesgasteEspecial extends Desgaste{


    public DesgasteEspecial()
    {
        durabilidad = 1000;
        factor = 0.1;
    }

    public double desgastar()
    {
        durabilidad -= durabilidad*factor;
        return durabilidad;
    }
}
