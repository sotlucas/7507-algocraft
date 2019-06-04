package fiuba.algo3.modelo;

public class BloqueMetal extends Bloque {

    public BloqueMetal() {
        this.durabilidad = 50;
    }

    public int getDurabilidad() {
        return this.durabilidad;
    }

    public void recibirDanio(Pico pico) {
        this.durabilidad -= 0;
    } //deberia reducirse si es un pico de piedra

    public void recibirDanio(Hacha hacha) {
        this.durabilidad -= 0;
    }
}