package fiuba.algo3.modelo;

public class Posicion {
    
    private int x;
    private int y;

    public void setColumna(int x) {
        this.x = x;
    }

    public void setFila(int y) {
        this.y = y;
    }

    public int getColumna() {
        return this.x;
    }

    public int getFila() {
        return this.y;
    }
}
