package fiuba.algo3.ejemplo1;

public class BloqueMetal extends MaterialBloque {

    public BloqueMadera() {
        this.durabilidad = 50;
    }

    public int getDurabilidad() {
        return this.durabilidad;
    }

    public void recibirDanio(Pico pico) {
        this.recibirDanioDeMaterial(pico.getMaterial());
    }

    public void recibirDanio(Hacha hacha) {
        this.durabilidad -= 0;
    }

    public void recibirDanioDeMaterial(Madera madera) {
        this.durabilidad -= 0;
    }

    public void recibirDanioDeMaterial(Piedra piedra) {
        this.durabilidad -= 0;
    }
}
