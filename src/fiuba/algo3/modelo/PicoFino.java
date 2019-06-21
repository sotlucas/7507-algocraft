package fiuba.algo3.modelo;

public class PicoFino extends Herramienta {

    public PicoFino() {
        this.durabilidad = 1000;
        this.fuerza = 20;
        this.material = null; // ver si creamos nuevo material
        this.desgaste = new DesgasteEspecial();
        this.receta = "MMMpm--m-";
        this.identificador = "pico_fino";
    }

    public void usarEn(Posicionable posicionable){

        posicionable.recibirDanio(this);
        if (durabilidad < 1) {
            throw new HerramientaSeRompioException();
        }
    }

    public void desgastar(){

        durabilidad = this.desgaste.desgastar();
    }

}
