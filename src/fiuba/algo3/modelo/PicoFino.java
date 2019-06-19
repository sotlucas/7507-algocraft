package fiuba.algo3.modelo;

public class PicoFino extends Herramienta {

    public PicoFino() {
        this.durabilidad = 1000;
        this.fuerza = 20;
        this.material = null; // ver si creamos nuevo material
        this.desgaste = new DesgasteEspecial();
        this.receta = "MMMpm--m-";
    }
/*
    public void usarEn(BloqueMadera bloqueMadera){
        durabilidad -= 0;
    }

    public void usarEn(BloqueMetal bloqueMetal){
        durabilidad -= 0;
    }

    public void usarEn(BloquePiedra bloquePiedra){
        durabilidad -= 0;
    }
*/
    public void usarEn(Bloque bloque){

        bloque.recibirDanio(this);
        if (durabilidad < 1) {
            throw new HerramientaSeRompioException();
        }
    }

    public void desgastar(){

        durabilidad = this.desgaste.desgastar();
    }

}
