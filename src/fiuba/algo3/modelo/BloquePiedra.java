package fiuba.algo3.modelo;

public class BloquePiedra extends Bloque {

    public BloquePiedra() {

        this.durabilidad = 30;
        this.identificador = 'p';
    }

    public void recibirDanio(Pico pico) {
        if(durabilidad <= 0){
            throw new BloqueSeRompioException();
        }
        durabilidad -= pico.getFuerza();
    }

    public void recibirDanio(Hacha hacha) {
        this.durabilidad -= 0;
    }

    public void recibirDanio(PicoFino picoFino){ this.durabilidad -= 0;}

    @Override
    public Material cederMaterial() {
        return new Piedra();
    }

}