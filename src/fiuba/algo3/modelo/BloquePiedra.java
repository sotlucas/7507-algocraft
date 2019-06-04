package fiuba.algo3.modelo;

class BloquePiedra extends MaterialBloque {

    public BloquePiedra() {
        this.durabilidad = 30;
    }

    public int getDurabilidad() {
        return this.durabilidad;
    }

    public void recibirDanio(Pico pico) {
        this.durabilidad -= pico.getFuerza();
    }

    public void recibirDanio(Hacha hacha) {
        this.durabilidad -= 0;
    }

}