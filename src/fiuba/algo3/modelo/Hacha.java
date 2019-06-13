package fiuba.algo3.modelo;

public class Hacha extends Herramienta{

    public Hacha(Madera madera) {
        this.durabilidad = 100;
        this.fuerza = 2;
        this.material = madera;
        this.desgaste = new DesgasteNormal(100, 2);
    }

    public Hacha(Piedra piedra){
        this.durabilidad = 200;
        this.fuerza = 5;
        this.material = piedra;
        this.desgaste = new DesgasteNormal(200, 5);
    }

    public Hacha(Metal metal){
        this.durabilidad = 400;
        this.fuerza = 10;
        this.material = metal;
        this.desgaste = new DesgasteNormal(400, 10, 2);
    }

    public void usarEn(Bloque bloqueMaterial){

        bloqueMaterial.recibirDanio(this);
        durabilidad = desgaste.desgastar();
        if (durabilidad <= 0){
            throw new HerramientaSeRompioException();
        }
    }

}
