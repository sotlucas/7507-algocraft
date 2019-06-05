package fiuba.algo3.modelo;

public abstract class Bloque {

    protected int durabilidad;
    protected Desgaste desgaste;

    public abstract void recibirDanio(Pico pico);
    public abstract void recibirDanio(Hacha hacha);

}
