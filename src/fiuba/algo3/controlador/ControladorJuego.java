package fiuba.algo3.controlador;

import fiuba.algo3.modelo.*;
import fiuba.algo3.vista.JuegoVista;

import java.util.HashMap;

public class ControladorJuego {

    private Juego juego;
    private JuegoVista juegoVista;
    private HashMap<Character, String> BloquesHash = new HashMap<>();

    public ControladorJuego(Juego juego, JuegoVista juegoVista) {
        this.juego = juego;
        this.juegoVista = juegoVista;
        inicializarHash();
        juegoVista.setControlador(this);
    }

    private void inicializarHash() {
        this.BloquesHash.put('m', "madera_bloque");
        this.BloquesHash.put('p', "piedra_bloque");
        this.BloquesHash.put('M', "metal_bloque");
        this.BloquesHash.put('d', "diamante_bloque");
        this.BloquesHash.put('j', "jugador");
        this.BloquesHash.put('v', "pasto");
    }

    public void actualizarVista() {

        for(int row = 0; row < juego.getCantidadFilasMapa() ; row++)
        {
            for(int col = 0; col < juego.getCantidadColumnasMapa(); col++)
            {
                char identificador = juego.getIdentificadorEnPosicion(row, col);

                String nombreImagen = BloquesHash.get(identificador);

                juegoVista.agregarElemento(nombreImagen, row, col);
            }
        }
    }

    public void moverIzquierda(){
        juego.avanzarJugador(new HaciaIzquierda());
        actualizarVista();
    }

    public void moverDerecha() {
        juego.avanzarJugador(new HaciaDerecha());
        actualizarVista();
    }

    public void moverArriba() {
        juego.avanzarJugador(new HaciaArriba());
        actualizarVista();
    }

    public void moverAbajo() {
        juego.avanzarJugador(new HaciaAbajo());
        actualizarVista();
    }

    public void golpearIzquierda() {
        juego.getJugador().golpear(new HaciaIzquierda());
        actualizarVista();
    }

    public void golpearDerecha() {
        juego.getJugador().golpear(new HaciaDerecha());
        actualizarVista();
    }

    public void golpearArriba() {
        juego.getJugador().golpear(new HaciaArriba());
        actualizarVista();
    }

    public void golpearAbajo() {
        juego.getJugador().golpear(new HaciaAbajo());
        actualizarVista();
    }
}


