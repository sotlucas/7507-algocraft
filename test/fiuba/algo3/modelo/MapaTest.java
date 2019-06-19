package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class MapaTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01AlCrearseMapaDevuelveAlgoDistintoDeNull(){

        Mapa mapa = new Mapa();
        Assert.assertNotNull(mapa);
    }

    @Test
    public void testAlCrearseMapaQuedanEstablecidasCorrectamenteLaCantidadDeFilas(){

        int cantidadFilas = 5;
        int cantidadColumnas = 8;

        Mapa mapa = new Mapa(cantidadFilas, cantidadColumnas);
        Assert.assertEquals(cantidadFilas, mapa.getCantidadFilas());
    }

    @Test
    public void testAlCrearseMapaQuedanEstablecidasCorrectamenteLaCantidadDeColumnas(){

        int cantidadFilas = 5;
        int cantidadColumnas = 8;

        Mapa mapa = new Mapa(cantidadFilas, cantidadColumnas);
        Assert.assertEquals(cantidadColumnas, mapa.getCantidadColumnas());
    }

    @Test
    public void testAlCrearseMapaSeVerificaQueSeCreanCorrectamenteTodasLasCasillas(){

        Mapa mapa = new Mapa(2, 2);

        Assert.assertNotNull(mapa.getCasilla(0, 0));
        Assert.assertNotNull(mapa.getCasilla(0, 1));
        Assert.assertNotNull(mapa.getCasilla(1, 0));
        Assert.assertNotNull(mapa.getCasilla(1, 1));
    }

    @Test
    public void testDespuesDeCrearTableroEstablezcoLaPosicionDelJugadorYEsaCasillaPasaAEstarOcupada(){

        Mapa mapa = new Mapa(10, 10);
        Jugador jugador = new Jugador(mapa);
        int fila = 5;
        int columna = 5;

        Casilla casillaIndicada = mapa.getCasilla(fila, columna);
        Assert.assertTrue(casillaIndicada.estaVacia());

        mapa.colocarJugador(jugador, fila, columna);
        Assert.assertFalse(casillaIndicada.estaVacia());
    }

    @Test
    public void testDespuesDeCrearTableroEstablezcoLaPosicionDeUnBloqueDeMaterialYEsaCasillaPasaAEstarOcupada(){

        Mapa mapa = new Mapa(10, 10);
        BloqueDiamante bloque = new BloqueDiamante();
        int cantidadFilas = 5;
        int cantidadColumnas = 5;

        mapa.colocarBloque(bloque, cantidadFilas, cantidadColumnas);
        Casilla casillaIndicada = mapa.getCasilla(cantidadFilas, cantidadColumnas);

        Assert.assertFalse(casillaIndicada.estaVacia());
    }

    @Test
    public void testSeIntentaMoverAlJugadorSinHaberEstablecidoSuPosicionYseLanzaExcepcion(){

        Mapa mapa = new Mapa(10, 10);
        BloqueDiamante bloque = new BloqueDiamante();
        Jugador jugador = new Jugador(mapa);

        thrown.expect(JugadorNoPosicionadoException.class);
        jugador.avanzar(new HaciaArriba());
    }

    @Test
    public void testJugadorIntentaAvanzarHaciaArribaAUnaCasillaLibreYSeVerificaQuePuedeHacerlo(){

        Mapa mapa = new Mapa(4, 4);
        Jugador jugador = new Jugador(mapa);

        mapa.colocarJugador(jugador, 2, 2);

        jugador.avanzar(new HaciaArriba());

        //si el personaje se movio hacia arriba, la casilla deberia pasar a estar vacia y la nueva, ocupada
        Assert.assertTrue(mapa.getCasilla(2, 2).estaVacia());
        Assert.assertFalse(mapa.getCasilla(1, 2).estaVacia()); //agregué esta para darle mas robustez
    }

    @Test
    public void testJugadorIntentaAvanzarHaciaArribaAUnaCasillaOcupadaYLanzaCasilleroEstaOcupadoException() {
        Mapa mapa = new Mapa(4, 4);
        BloquePiedra bloquePiedra = new BloquePiedra();
        Jugador jugador = new Jugador(mapa);

        mapa.colocarBloque(bloquePiedra, 1, 2);
        mapa.colocarJugador(jugador, 2, 2);

        thrown.expect(CasilleroEstaOcupadoException.class);
        jugador.avanzar(new HaciaArriba());
    }

    @Test
    public void testJugadorIntentaAvanzarHaciaAbajoAUnaCasillaLibreYLaCasillaAnteriorPasaAEstarLibre() {
        Mapa mapa = new Mapa(4, 4);
        Jugador jugador = new Jugador(mapa);

        mapa.colocarJugador(jugador, 2, 2);

        jugador.avanzar(new HaciaAbajo());

        Assert.assertTrue(mapa.getCasilla(2, 2).estaVacia());
        Assert.assertFalse(mapa.getCasilla(3, 2).estaVacia());
    }

    @Test
    public void testJugadorIntentaAvanzarHaciaAbajoAUnaCasillaOcupadaYLanzaCasilleroEstaOcupadoException() {
        Mapa mapa = new Mapa(4, 4);
        BloquePiedra bloquePiedra = new BloquePiedra();
        Jugador jugador = new Jugador(mapa);

        mapa.colocarBloque(bloquePiedra, 2, 2);
        mapa.colocarJugador(jugador, 1, 2);

        thrown.expect(CasilleroEstaOcupadoException.class);
        jugador.avanzar(new HaciaAbajo());
    }

    @Test
    public void testJugadorIntentaAvanzarHaciaDerechaAUnaCasillaLibreYLaCasillaAnteriorPasaAEstarLibre() {
        Mapa mapa = new Mapa(4, 4);
        Jugador jugador = new Jugador(mapa);

        mapa.colocarJugador(jugador, 2, 2);
        jugador.avanzar(new HaciaDerecha());

        Assert.assertTrue(mapa.getCasilla(2, 2).estaVacia());
        Assert.assertFalse(mapa.getCasilla(2, 3).estaVacia());
    }

    @Test
    public void testJugadorIntentaAvanzarHaciaDerechaAUnaCasillaOcupadaYLanzaCasilleroEstaOcupadoException() {
        Mapa mapa = new Mapa(4, 4);
        BloquePiedra bloquePiedra = new BloquePiedra();
        Jugador jugador = new Jugador(mapa);

        mapa.colocarBloque(bloquePiedra, 2, 2);
        mapa.colocarJugador(jugador, 2, 1);

        thrown.expect(CasilleroEstaOcupadoException.class);
        jugador.avanzar(new HaciaDerecha());
    }

    @Test
    public void testJugadorIntentaAvanzarHaciaIzquierdaAUnaCasillaLibreYLaCasillaAnteriorPasaAEstarLibre() {
        Mapa mapa = new Mapa(4, 4);
        Jugador jugador = new Jugador(mapa);

        mapa.colocarJugador(jugador, 2, 2);

        jugador.avanzar(new HaciaIzquierda());

        Assert.assertTrue(mapa.getCasilla(2, 2).estaVacia());
        Assert.assertFalse(mapa.getCasilla(2, 1).estaVacia());
    }

    @Test
    public void testJugadorIntentaAvanzarHaciaIzquierdaAUnaCasillaOcupadaYLanzaCasilleroEstaOcupadoException() {
        Mapa mapa = new Mapa(4, 4);
        BloquePiedra bloquePiedra = new BloquePiedra();
        Jugador jugador = new Jugador(mapa);

        mapa.colocarBloque(bloquePiedra, 2, 2);
        mapa.colocarJugador(jugador, 2, 3);

        thrown.expect(CasilleroEstaOcupadoException.class);
        jugador.avanzar(new HaciaIzquierda());
    }


    @Test
    public void testJugadorIntentaAvanzarHaciaArribaEnElBordeDelMapaYLanzaPosicionFueraDelMapaException() {
        Mapa mapa = new Mapa(2, 2);
        Jugador jugador = new Jugador(mapa);

        mapa.colocarJugador(jugador, 0, 0);

        thrown.expect(PosicionFueraDelMapaException.class);
        jugador.avanzar(new HaciaArriba());
    }

    @Test
    public void testJugadorIntentaAvanzarHaciaAbajoEnElBordeDelMapaYLanzaPosicionFueraDelMapaException() {
        Mapa mapa = new Mapa(2, 2);
        Jugador jugador = new Jugador(mapa);

        mapa.colocarJugador(jugador, 1, 0);

        thrown.expect(PosicionFueraDelMapaException.class);
        jugador.avanzar(new HaciaAbajo());
    }

    @Test
    public void testJugadorIntentaAvanzarHaciaDerechaEnElBordeDelMapaYLanzaPosicionFueraDelMapaException() {
        Mapa mapa = new Mapa(2, 2);
        Jugador jugador = new Jugador(mapa);

        mapa.colocarJugador(jugador, 1, 1);

        thrown.expect(PosicionFueraDelMapaException.class);
        jugador.avanzar(new HaciaDerecha());
    }

    @Test
    public void testJugadorIntentaAvanzarHaciaIzquierdaEnElBordeDelMapaYLanzaPosicionFueraDelMapaException() {
        Mapa mapa = new Mapa(2, 2);
        Jugador jugador = new Jugador(mapa);

        mapa.colocarJugador(jugador, 1, 0);

        thrown.expect(PosicionFueraDelMapaException.class);
        jugador.avanzar(new HaciaIzquierda());
    }
}
