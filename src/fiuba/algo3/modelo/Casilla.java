package fiuba.algo3.modelo;

public class Casilla {

    private Estado estado;
    private Posicionable elementoContenido;

    public Casilla(){

        estado = new Vacio();
        elementoContenido = null;
    }

    public Casilla(Posicionable elemento){

        estado = new Ocupado();
    }


    public boolean estaVacia(){

        return estado.estaVacio();
    }

    public void colocar(Posicionable elemento){

        if(!estado.estaVacio()){

            throw new CasilleroEstaOcupadoException();
        }

        elementoContenido = elemento;
        estado = new Ocupado();

    }

    public void vaciar() {

        this.elementoContenido = null;
        this.estado = new Vacio();
    }

    //METODO NO APROPIADO:
    public Posicionable getElementoContenido(){

        return elementoContenido;
    }

    public char getIdentificador() {
        if(estado.estaVacio()){
            return 'v';
        }
        else {
            return elementoContenido.getIdentificador();
        }
    }
}
