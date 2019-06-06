package fiuba.algo3.modelo;

public class PicoFino extends Herramienta {

    public PicoFino() {
        this.durabilidad = 1000;
        this.fuerza = 20;
        this.material = null; // ver si creamos nuevo material
        this.desgaste = new DesgasteEspecial();
    }

    public void usarEn(BloqueMadera bloqueMadera){
        durabilidad -= 0;
    }

    public void usarEn(BloqueMetal bloqueMetal){
        durabilidad -= 0;
    }

    public void usarEn(BloquePiedra bloquePiedra){
        durabilidad -= 0;
    }

    public void usarEn(BloqueDiamante bloqueDiamante){

        bloqueDiamante.recibirDanio(this);
        durabilidad = desgaste.desgastar();
    }

}
