package fiuba.algo3.modelo;

public class Casilla {

    private Estado estado;
    private Elemento elementoContenido;

    public Casilla(){

        estado = new Vacio();
        elementoContenido = null;
    }

    public Casilla(Elemento elemento){

        estado = new Ocupado();
    }


    public boolean estaVacia(){

        return estado.estaVacio();
    }

    public void colocar(Elemento elemento){

        if(!estado.estaVacio()){

            throw new CasilleroEstaOcupadoException();
        }

        estado = new Ocupado();

    }

    public void vaciar() {

        this.elementoContenido = null;
        this.estado = new Vacio();
    }
}
