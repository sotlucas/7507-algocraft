package fiuba.algo3.modelo;

public abstract class Bloque {

    public int durabilidad;

    public abstract void recibirDanio(Pico pico);
    public abstract void recibirDanio(Hacha hacha);

}
