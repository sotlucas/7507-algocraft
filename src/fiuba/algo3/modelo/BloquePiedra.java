package fiuba.algo3.modelo;

class BloquePiedra extends Bloque {

    public BloquePiedra() {
        this.durabilidad = 30;
    }

    public int getDurabilidad() {
        return this.durabilidad;
    }

    public void recibirDanio(Herramienta herramienta) {
        this.durabilidad -= herramienta.getFuerza();
    }
}