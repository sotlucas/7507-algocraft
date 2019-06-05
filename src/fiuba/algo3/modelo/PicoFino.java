package fiuba.algo3.modelo;

public class PicoFino extends Herramienta {

    public PicoFino() {
        this.durabilidad = 1000;
        this.fuerza = 20;
        this.material = null; // ver si creamos nuevo material
        this.desgaste = new Desgaste(1000,1000,10);
    }

    public void usarEn(BloqueMadera bloqueMadera){

        //bloqueMaterial.recibirImpacto(this);
        durabilidad -= 0;
    }

    public void usarEn(BloqueMetal bloqueMetal){

        //bloqueMaterial.recibirImpacto(this);
        durabilidad -= 0;
    }

    public void usarEn(BloquePiedra bloquePiedra){

        //bloqueMaterial.recibirImpacto(this);
        durabilidad -= 0;
    }

    public void usarEn(BloqueDiamante bloqueDiamante){

        //bloqueMaterial.recibirImpacto(this);
        durabilidad = desgaste.desgastar();
    }

}
