package fiuba.algo3.ejemplo1;

public class Bloque {
    int durabilidad;
}

class Piedra extends Bloque {

    public Piedra() {
        this.durabilidad = 30;
    }

    public int getDurabilidad() {
        return this.durabilidad;
    }
}
