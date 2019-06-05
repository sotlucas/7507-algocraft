package fiuba.algo3.modelo;

public class BloquePiedra extends Bloque {

    public BloquePiedra() {
        this.durabilidad = 30;
    }

    public void recibirDanio(Pico pico) {
        this.durabilidad -= pico.getFuerza();
    }

    public void recibirDanio(Hacha hacha) {
        this.durabilidad -= 0;
    }
}