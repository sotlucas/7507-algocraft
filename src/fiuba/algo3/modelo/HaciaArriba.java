package fiuba.algo3.modelo;

public class HaciaArriba extends Direccion {

    @Override
    public void avanzar(Mapa mapa, Jugador jugador) {

        if(!jugador.estaPosicionado()){
            throw new JugadorNoPosicionadoException();
        }

        int columnaActualJugador = jugador.getPosicionColumna();
        int filaActualJugador = jugador.getPosicionFila();
        int columnaSiguienteJugador = columnaActualJugador;
        int filaSiguienteJugador = filaActualJugador - 1;

        mapa.moverJugador(jugador, columnaActualJugador, filaActualJugador, columnaSiguienteJugador, filaSiguienteJugador);

    }

    @Override
    public void golpear(Mapa mapa, Herramienta herramienta, Jugador jugador){

        int columnaJugador = jugador.getPosicionColumna();
        int filaJugador = jugador.getPosicionFila();
        Casilla casillaApuntada = mapa.getCasilla(filaJugador - 1, columnaJugador);
        Posicionable posicionable = casillaApuntada.getElementoContenido();

        if(posicionable != null)
        {
            herramienta.usarEn(posicionable);
            if(posicionable.getDurabilidad() <= 0) {

                casillaApuntada.vaciar();
                jugador.agregarMaterialAInventario(posicionable.cederMaterial());
            }
        }



    }
}
