package fiuba.algo3.modelo;

public class Personaje implements Elemento {

    private Casilla casilla;

    public void avanzar() {


    }

    public void avanzar(HaciaArriba direccion){

        Casilla casillaSuperior = null;
        if(casilla.hayCasillaSuperior()) {
            casillaSuperior = casilla.obtenerSuperior();
        }
        if(casillaSuperior.estaVacia()){

            casillaSuperior.colocar(this);
            casilla.vaciar();
        }
    }
}
