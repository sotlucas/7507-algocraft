package fiuba.algo3.modelo;

public class Hacha extends Herramienta{

    public Hacha(Madera madera) {
        this.durabilidad = 100;
        this.fuerza = 2;
        this.desgaste = new Desgaste(100, 2);
    }

    public Hacha(Piedra piedra){

        this.durabilidad = 200;
        this.fuerza = 5;
        this.desgaste = new Desgaste(200, 5);
    }

    public Hacha(Metal metal){

        this.durabilidad = 400;
        this.fuerza = 10;
        this.desgaste = new Desgaste(400, 10, 2);
    }

    public void usarEn(Bloque bloqueMaterial){

        bloqueMaterial.recibirDanio(this);
        durabilidad = desgaste.desgastar();
    }

}
