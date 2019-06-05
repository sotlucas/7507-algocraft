package fiuba.algo3.modelo;

public class Pico extends Herramienta {

    public Pico(Madera madera) {
        this.durabilidad = 100;
        this.fuerza = 2;
        this.material = madera;
        this.desgaste = new Desgaste(100, 2);
    }

    public Pico(Piedra piedra) {
        this.durabilidad = 200;
        this.fuerza = 4;
        this.material = piedra;
        this.desgaste = new Desgaste(200, 4, 1.5);
    }

    public Pico(Metal metal) {
        this.durabilidad = 400;
        this.fuerza = 12;
        this.material = metal;
        this.desgaste = new Desgaste(400, 12, 0.3);
    }

    public void usarEn(Bloque bloqueMaterial){

        //bloqueMaterial.recibirImpacto(this);
        durabilidad = desgaste.desgastar();
    }

}
