package fiuba.algo3.modelo;

public class BloqueMetal extends Bloque {

    public BloqueMetal() {
        this.durabilidad = 50;
    }

    public void recibirDanio(Pico pico) {

        MaterialHerramienta materialPico = pico.getMaterial();

        if(materialPico.getClass() == Piedra.class) {
            durabilidad -= pico.getFuerza();
        }

    }

    public void recibirDanio(Hacha hacha) {
        this.durabilidad -= 0;
    }


}