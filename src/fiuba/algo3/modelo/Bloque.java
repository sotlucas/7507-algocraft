package fiuba.algo3.modelo;

public abstract class Bloque implements Posicionable{

    protected int durabilidad;
    protected char identificador;

    public abstract Material cederMaterial();

    public int getDurabilidad() {
        return this.durabilidad;
    }

    public char getIdentificador()
    {
        return this.identificador;
    }

    @Override
    public boolean estaRoto()
    {
        return this.durabilidad <= 0;
    }

}













