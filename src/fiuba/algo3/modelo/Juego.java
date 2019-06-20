package fiuba.algo3.modelo;

public class Juego {

    private Mapa mapa;
    private Jugador jugador;

    public Juego(){

        mapa = new Mapa(9, 13);
        jugador = new Jugador(mapa);
        disponerElementosEnElMapa();

    }

    private void disponerElementosEnElMapa() {

        mapa.colocarJugador(jugador, 7, 7);

        mapa.colocarBloque(new BloqueMetal(),1,1);
        mapa.colocarBloque(new BloqueMetal(),1,2);
        mapa.colocarBloque(new BloqueMetal(),2,1);
        mapa.colocarBloque(new BloqueMetal(),2,2);

        mapa.colocarBloque(new BloqueMadera(),4,1);
        mapa.colocarBloque(new BloqueMadera(),4,2);
        mapa.colocarBloque(new BloqueMadera(),4,3);
        mapa.colocarBloque(new BloqueMadera(),4,4);
        mapa.colocarBloque(new BloqueMadera(),5,1);
        mapa.colocarBloque(new BloqueMadera(),5,2);
        mapa.colocarBloque(new BloqueMadera(),5,3);
        mapa.colocarBloque(new BloqueMadera(),5,4);
        mapa.colocarBloque(new BloqueMadera(),6,1);
        mapa.colocarBloque(new BloqueMadera(),6,2);
        mapa.colocarBloque(new BloqueMadera(),6,3);
        mapa.colocarBloque(new BloqueMadera(),6,4);
        mapa.colocarBloque(new BloqueMadera(),7,1);
        mapa.colocarBloque(new BloqueMadera(),7,2);
        mapa.colocarBloque(new BloqueMadera(),7,3);
        mapa.colocarBloque(new BloqueMadera(),7,4);

        mapa.colocarBloque(new BloquePiedra(),4,9);
        mapa.colocarBloque(new BloquePiedra(),4,10);
        mapa.colocarBloque(new BloquePiedra(),5,9);
        mapa.colocarBloque(new BloquePiedra(),5,10);

    }


    public int getCantidadFilasMapa() {
        return mapa.getCantidadFilas();
    }

    public int getCantidadColumnasMapa() {
        return mapa.getCantidadColumnas();
    }

    public void avanzarJugador(Direccion direccion){

        jugador.avanzar(direccion);
    }

    public int getColumnaJugador(){

        return jugador.getPosicionColumna();
    }

    public int getFilaJugador(){
        return jugador.getPosicionFila();
    }


    public boolean casillaEstaVacia(int fila, int columna) {

        return mapa.casillaEstaVacia(fila, columna);
    }

    public char getIdentificadorEnPosicion(int fila, int columna) {
        return this.mapa.getIdentificadorEnPosicion(fila, columna);
    }

    public Jugador getJugador() { return this.jugador;}
}
