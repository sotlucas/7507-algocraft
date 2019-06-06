package fiuba.algo3.modelo;

public class DesgasteEspecial {

    private double durabilidad;
    private double factor;

    public DesgasteEspecial(){

        durabilidad = 1000;
        factor = 0.1;
    }

    public double desgastar(){

        durabilidad -= durabilidad*factor;
        if(durabilidad < 1){
            durabilidad = 0;
        }
        return durabilidad;
    }


}
