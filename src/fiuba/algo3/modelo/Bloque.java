package fiuba.algo3.modelo;

public abstract class Bloque implements Posicionable{

    protected int durabilidad;
    protected char identificador;

    public int getDurabilidad() {
        return this.durabilidad;
    }
    public char getIdentificador(){
        return this.identificador;
    }
    public abstract void recibirDanio(Pico pico);
    public abstract void recibirDanio(Hacha hacha);
    public abstract void recibirDanio(PicoFino picoFino);
    public abstract Material cederMaterial();

    @Override
    public boolean estaRoto(){
        return this.durabilidad <= 0;
    }

}
