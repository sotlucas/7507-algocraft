package fiuba.algo3.modelo;

public class HaciaAbajo extends Direccion {
    
    @Override
    public void avanzar(Mapa mapa, Jugador jugador) {
        mapa.mover(jugador, jugador.getPosicionColumna(), jugador.getPosicionFila(), jugador.getPosicionColumna(), jugador.getPosicionFila() + 1);
    }
}
