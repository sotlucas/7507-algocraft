package fiuba.algo3.modelo;

public class BloqueMadera extends Bloque {

    public BloqueMadera() { this.durabilidad = 10; }

    public void recibirDanio(Pico pico) {
        this.durabilidad -= 0;
    }

    public void recibirDanio(Hacha hacha) {
        this.durabilidad -= hacha.getFuerza();
    }
}