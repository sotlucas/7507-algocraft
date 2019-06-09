package fiuba.algo3.modelo;

public class HaciaIzquierda extends Direccion {

    @Override
    public void avanzar(Mapa mapa, Jugador jugador) {
        mapa.mover(jugador, jugador.getPosicionX(), jugador.getPosicionY(), jugador.getPosicionX() - 1, jugador.getPosicionY());
    }
}
