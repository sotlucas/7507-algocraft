package fiuba.algo3.modelo;

public class EspacioVacio implements Posicionable {
    @Override
    public char getIdentificador() {
        return 'v';
    }

    @Override
    public void recibirDanio(Hacha hacha) {}

    @Override
    public void recibirDanio(Pico pico) {}

    @Override
    public void recibirDanio(PicoFino picoFino) {}

    @Override
    public Material cederMaterial()
    {
        return null;
    }

    @Override
    public int getDurabilidad()
    {
        return 0;
    }

    @Override
    public boolean estaRoto()
    {
        return false;
    }
}
