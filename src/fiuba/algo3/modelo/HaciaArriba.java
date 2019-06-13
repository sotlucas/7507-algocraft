package fiuba.algo3.modelo;

public class HaciaArriba extends Direccion {

    @Override
    public void avanzar(Mapa mapa, Jugador jugador) {
        int columnaActualJugador = jugador.getPosicionColumna();
        int filaActualJugador = jugador.getPosicionFila();
        int columnaSiguienteJugador = columnaActualJugador;
        int filaSiguienteJugador = filaActualJugador - 1;

        //mapa.mover(jugador, jugador.getPosicionColumna(), jugador.getPosicionFila(), jugador.getPosicionColumna() - 1, jugador.getPosicionFila());
        mapa.mover(jugador, columnaActualJugador, filaActualJugador, columnaSiguienteJugador, filaSiguienteJugador);
        jugador.setPosicion(filaSiguienteJugador, columnaSiguienteJugador);}
}
