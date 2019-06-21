package fiuba.algo3.modelo;

public class BloqueMetal extends Bloque {

    public BloqueMetal() {

        this.durabilidad = 50;
        this.identificador = 'M';
    }

    public void recibirDanio(Pico pico) {

        durabilidad -= pico.getFuerzaEspecialContraMetal();

        if(durabilidad <= 0){

            throw new BloqueSeRompioException();
        }

    }

    public char getIdentificador(){
        return this.identificador;
    }


    public void recibirDanio(PicoFino picoFino){ this.durabilidad -= 0;}

    @Override
    public Material cederMaterial() {
        return new Metal();
    }

    public void recibirDanio(Hacha hacha) {
        this.durabilidad -= 0;
    }


}