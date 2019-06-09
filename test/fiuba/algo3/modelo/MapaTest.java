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
    public void test02AlCrearseMapaConDimensionesEstasQuedanEstablecidasCorrectamente(){

        int alto = 5;
        int ancho = 8;

        Mapa mapa = new Mapa(alto, ancho);
        Assert.assertEquals(alto, mapa.getAltura());
        Assert.assertEquals(ancho, mapa.getAncho());
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
        Jugador jugador = new Jugador();
        int alto = 5;
        int ancho = 5;

        Casilla casillaIndicada = mapa.getCasilla(alto, ancho);
        Assert.assertTrue(casillaIndicada.estaVacia());

        mapa.colocar(jugador, alto, ancho);
        Assert.assertFalse(casillaIndicada.estaVacia());
    }

    @Test
    public void testDespuesDeCrearTableroEstablezcoLaPosicionDeUnBloqueDeMaterialYEsaCasillaPasaAEstarOcupada(){

        Mapa mapa = new Mapa(10, 10);
        BloqueDiamante bloque = new BloqueDiamante();
        int alto = 5;
        int ancho = 5;

        mapa.colocar(bloque, alto, ancho);
        Casilla casillaIndicada = mapa.getCasilla(alto, ancho);

        Assert.assertFalse(casillaIndicada.estaVacia());
    }

    @Test
    public void testJugadorIntentaAvanzarHaciaArribaAUnaCasillaLibreYSeVerificaQuePuedeHacerlo(){

        Mapa mapa = new Mapa(4, 4);
        Jugador jugador = new Jugador();

        mapa.colocar(jugador, 2, 2);
        jugador.setPosicion(2, 2); // posicion inicial del Jugador

        jugador.avanzar(mapa, new HaciaArriba());

        //si el personaje se movio hacia arriba, la casilla deberia pasar a estar vacia
        Assert.assertTrue(mapa.getCasilla(2, 2).estaVacia());
    }

    @Test
    public void testJugadorIntentaAvanzarHaciaArribaAUnaCasillaOcupadaYLanzaCasilleroEstaOcupadoException() {
        Mapa mapa = new Mapa(4, 4);
        BloquePiedra bloquePiedra = new BloquePiedra();
        Jugador jugador = new Jugador();

        mapa.colocar(bloquePiedra, 1, 2);
        mapa.colocar(jugador, 2, 2);
        jugador.setPosicion(2, 2); // posicion inicial del Jugador

        thrown.expect(CasilleroEstaOcupadoException.class);
        jugador.avanzar(mapa, new HaciaArriba());
    }

    @Test
    public void testJugadorIntentaAvanzarHaciaAbajoAUnaCasillaLibreYLaCasillaAnteriorPasaAEstarLibre() {
        Mapa mapa = new Mapa(4, 4);
        Jugador jugador = new Jugador();

        mapa.colocar(jugador, 2, 2);
        jugador.setPosicion(2, 2); // posicion inicial del Jugador

        jugador.avanzar(mapa, new HaciaAbajo());

        Assert.assertTrue(mapa.getCasilla(2, 2).estaVacia());
    }

    @Test
    public void testJugadorIntentaAvanzarHaciaAbajoAUnaCasillaOcupadaYLanzaCasilleroEstaOcupadoException() {
        Mapa mapa = new Mapa(4, 4);
        BloquePiedra bloquePiedra = new BloquePiedra();
        Jugador jugador = new Jugador();

        mapa.colocar(bloquePiedra, 2, 2);
        mapa.colocar(jugador, 2, 1);
        jugador.setPosicion(2, 1); // posicion inicial del Jugador

        thrown.expect(CasilleroEstaOcupadoException.class);
        jugador.avanzar(mapa, new HaciaAbajo());
    }

    @Test
    public void testJugadorIntentaAvanzarHaciaDerechaAUnaCasillaLibreYLaCasillaAnteriorPasaAEstarLibre() {
        Mapa mapa = new Mapa(4, 4);
        Jugador jugador = new Jugador();

        mapa.colocar(jugador, 2, 2);
        jugador.setPosicion(2, 2); // posicion inicial del Jugador

        jugador.avanzar(mapa, new HaciaDerecha());

        Assert.assertTrue(mapa.getCasilla(2, 2).estaVacia());
    }

    @Test
    public void testJugadorIntentaAvanzarHaciaDerechaAUnaCasillaOcupadaYLanzaCasilleroEstaOcupadoException() {
        Mapa mapa = new Mapa(4, 4);
        BloquePiedra bloquePiedra = new BloquePiedra();
        Jugador jugador = new Jugador();

        mapa.colocar(bloquePiedra, 2, 2);
        mapa.colocar(jugador, 1, 2);
        jugador.setPosicion(1, 2); // posicion inicial del Jugador

        thrown.expect(CasilleroEstaOcupadoException.class);
        jugador.avanzar(mapa, new HaciaDerecha());
    }

    @Test
    public void testJugadorIntentaAvanzarHaciaIzquierdaAUnaCasillaLibreYLaCasillaAnteriorPasaAEstarLibre() {
        Mapa mapa = new Mapa(4, 4);
        Jugador jugador = new Jugador();

        mapa.colocar(jugador, 2, 2);
        jugador.setPosicion(2, 2); // posicion inicial del Jugador

        jugador.avanzar(mapa, new HaciaIzquierda());

        Assert.assertTrue(mapa.getCasilla(2, 2).estaVacia());
    }

    @Test
    public void testJugadorIntentaAvanzarHaciaIzquierdaAUnaCasillaOcupadaYLanzaCasilleroEstaOcupadoException() {
        Mapa mapa = new Mapa(4, 4);
        BloquePiedra bloquePiedra = new BloquePiedra();
        Jugador jugador = new Jugador();

        mapa.colocar(bloquePiedra, 2, 2);
        mapa.colocar(jugador, 3, 2);
        jugador.setPosicion(3, 2); // posicion inicial del Jugador

        thrown.expect(CasilleroEstaOcupadoException.class);
        jugador.avanzar(mapa, new HaciaIzquierda());
    }
}
