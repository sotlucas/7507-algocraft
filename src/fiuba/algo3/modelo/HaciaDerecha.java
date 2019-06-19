package fiuba.algo3.modelo;

public class HaciaDerecha extends Direccion {

    @Override
    public void avanzar(Mapa mapa, Jugador jugador) {
        if(!jugador.estaPosicionado()){
            throw new JugadorNoPosicionadoException();
        }


        int columnaActualJugador = jugador.getPosicionColumna();
        int filaActualJugador = jugador.getPosicionFila();
        int columnaSiguienteJugador = columnaActualJugador + 1;
        int filaSiguienteJugador = filaActualJugador;

        //mapa.moverJugador(jugador, jugador.getPosicionColumna(), jugador.getPosicionFila(), jugador.getPosicionColumna() - 1, jugador.getPosicionFila());
        mapa.moverJugador(jugador, columnaActualJugador, filaActualJugador, columnaSiguienteJugador, filaSiguienteJugador);
        //jugador.setPosicion(filaSiguienteJugador, columnaSiguienteJugador);
    }
}
