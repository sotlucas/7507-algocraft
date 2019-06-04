package fiuba.algo3.modelo;

public class BloqueMetal extends MaterialBloque {

    public BloqueMetal() {
        this.durabilidad = 50;
    }

    public int getDurabilidad() {
        return this.durabilidad;
    }

    public void recibirDanio(Pico pico) {
        this.durabilidad -= 0;
    }

    public void recibirDanio(Hacha hacha) {
        this.durabilidad -= 0;
    }
}