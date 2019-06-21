package fiuba.algo3.modelo;

public class BloqueDiamante extends Bloque{

    public BloqueDiamante() {
        this.durabilidad = 100;
        this.identificador = 'd';
    }

    public void recibirDanio(Pico pico) {
        this.durabilidad -= 0;
    }

    public void recibirDanio(Hacha hacha) {
        this.durabilidad -= 0;
    }

    public void recibirDanio(PicoFino picoFino) {

        durabilidad -= picoFino.getFuerza();
        picoFino.desgastar();

        if(durabilidad <= 0){

            throw new BloqueSeRompioException();
        }
    }

    public char getIdentificador(){
        return this.identificador;
    }

    @Override
    public Material cederMaterial() {
        return new Diamante();
    }


}
