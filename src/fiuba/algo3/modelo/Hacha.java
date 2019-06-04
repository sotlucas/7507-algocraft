package fiuba.algo3.modelo;

public class Hacha extends Herramienta{

    public Hacha(Madera madera) {
        this.durabilidad = 100;
        this.fuerza = 2;
    }

    public Hacha(Piedra piedra){

        this.durabilidad = 200;
        this.fuerza = 5;
    }

    public Hacha(Metal metal){

        this.durabilidad = 400;
        this.fuerza = 10;
    }

    public void usarEn(Bloque bloqueMaterial){

        //bloqueMaterial.recibirImpacto(this);
        //material.desgastarse(this);
        this.durabilidad -= this.fuerza;
    }

}
