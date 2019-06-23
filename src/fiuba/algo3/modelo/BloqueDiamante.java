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

        if(durabilidad <= 0) {
            throw new BloqueSeRompioException();
        }
        durabilidad -= picoFino.getFuerza();
        picoFino.desgastar();

    }

    @Override
    public Material cederMaterial() {
        return new Diamante();
    }

}
