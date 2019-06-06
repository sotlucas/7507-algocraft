package fiuba.algo3.modelo;

public abstract class Bloque {

    protected int durabilidad;

    public int getDurabilidad() {
        return this.durabilidad;
    }
    public abstract void recibirDanio(Pico pico);
    public abstract void recibirDanio(Hacha hacha);
    public abstract void recibirDanio(PicoFino picoFino);

}
