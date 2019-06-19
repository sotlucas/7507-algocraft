package fiuba.algo3.modelo;

public class HaciaIzquierda extends Direccion {

    @Override
    public void avanzar(Mapa mapa, Jugador jugador) {

        if(!jugador.estaPosicionado()){
            throw new JugadorNoPosicionadoException();
        }

        int columnaActualJugador = jugador.getPosicionColumna();
        int filaActualJugador = jugador.getPosicionFila();
        int columnaSiguienteJugador = columnaActualJugador - 1;
        int filaSiguienteJugador = filaActualJugador;

        //mapa.moverJugador(jugador, jugador.getPosicionColumna(), jugador.getPosicionFila(), jugador.getPosicionColumna() - 1, jugador.getPosicionFila());
        mapa.moverJugador(jugador, jugador.getPosicionColumna(), jugador.getPosicionFila(), jugador.getPosicionColumna() - 1, jugador.getPosicionFila());
        //jugador.setPosicion(filaSiguienteJugador, columnaSiguienteJugador);

    }
}
