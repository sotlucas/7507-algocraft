package fiuba.algo3.controlador;

import fiuba.algo3.modelo.*;
import fiuba.algo3.vista.JuegoVista;

import java.util.HashMap;

public class ControladorJuego {

    private Juego juego;
    private JuegoVista juegoVista;
    private HashMap<Character, String> BloquesHash = new HashMap<>();
    private ControladorDeInventario controladorDeInventario;
    private ReproductorSonidos reproductor;

    public ControladorJuego(Juego juego, JuegoVista juegoVista, ControladorDeInventario controladorDeInventario) {
        this.reproductor = new ReproductorSonidos();
        this.reproductor.reproducirMusica();
        this.controladorDeInventario = controladorDeInventario;
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

    public void mover(Direccion direccion) {
        juego.avanzarJugador(direccion);
        actualizarVista();
    }

    public void golpear(Direccion direccion) {
        try {
            juego.getJugador().golpear(direccion);
            this.reproductor.reproducirGolpear();
        } catch (HerramientaNoSeleccionadaException e) {
        } catch (PosicionFueraDelMapaException ex) {
        }
        actualizarVista();
        controladorDeInventario.actualizarVista();
    }

    public void reproducirMusica() {
        this.reproductor.reproducirMusica();
    }

    public void pausarMusica() {
        this.reproductor.pausarMusica();
    }

    public boolean musicaPausada() {
        return this.reproductor.musicaPausada();
    }
}