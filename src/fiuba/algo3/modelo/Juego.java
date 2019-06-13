package fiuba.algo3.modelo;

public class Juego {

    private Mapa mapa;
    private Jugador jugador;


    public Juego(){

        mapa = new Mapa(9, 13);
        disponerElementosEnElMapa();

    }

    private void disponerElementosEnElMapa() {

        jugador = new Jugador();
        mapa.colocar(jugador, 7, 7);
        jugador.setPosicion(7, 7);

        mapa.colocar(new BloqueMetal(),1,1);
        mapa.colocar(new BloqueMetal(),1,2);
        mapa.colocar(new BloqueMetal(),2,1);
        mapa.colocar(new BloqueMetal(),2,2);

        mapa.colocar(new BloqueMadera(),4,1);
        mapa.colocar(new BloqueMadera(),4,2);
        mapa.colocar(new BloqueMadera(),4,3);
        mapa.colocar(new BloqueMadera(),4,4);
        mapa.colocar(new BloqueMadera(),5,1);
        mapa.colocar(new BloqueMadera(),5,2);
        mapa.colocar(new BloqueMadera(),5,3);
        mapa.colocar(new BloqueMadera(),5,4);
        mapa.colocar(new BloqueMadera(),6,1);
        mapa.colocar(new BloqueMadera(),6,2);
        mapa.colocar(new BloqueMadera(),6,3);
        mapa.colocar(new BloqueMadera(),6,4);
        mapa.colocar(new BloqueMadera(),7,1);
        mapa.colocar(new BloqueMadera(),7,2);
        mapa.colocar(new BloqueMadera(),7,3);
        mapa.colocar(new BloqueMadera(),7,4);

        mapa.colocar(new BloquePiedra(),4,9);
        mapa.colocar(new BloquePiedra(),4,10);
        mapa.colocar(new BloquePiedra(),5,9);
        mapa.colocar(new BloquePiedra(),5,10);

    }


    public int getCantidadFilasMapa() {
        return mapa.getCantidadFilas();
    }

    public int getCantidadColumnasMapa() {
        return mapa.getCantidadColumnas();
    }

    public void avanzarJugadorHacia(Direccion direccion){

        jugador.avanzar(mapa, direccion);
    }


}
