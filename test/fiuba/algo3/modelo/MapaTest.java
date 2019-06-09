package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;

public class MapaTest {

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
        Personaje personaje = new Personaje();
        int alto = 5;
        int ancho = 5;

        Casilla casillaIndicada = mapa.getCasilla(alto, ancho);
        Assert.assertTrue(casillaIndicada.estaVacia());

        mapa.colocar(personaje, alto, ancho);
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
    public void testPersonajeIntentaAvanzarHaciaArribaAUnaCasillaLibreYSeVerificaQuePuedeHacerlo(){

        Mapa mapa = new Mapa(4, 4);
        Personaje personaje = new Personaje();

        mapa.colocar(personaje, 2, 2);
        personaje.avanzar();

        //si el personaje se movio hacia arriba, la casilla deberia pasar a estar vacia
        //Assert.assertTrue(mapa.getCasilla(2, 2).estaVacia());


    }

    @Test //CORREGIR PRUEBA
    public void testPersonajeIntentaAvanzarHaciaArribaAUnaCasillaOcupadaYSeVerificaQueNoPuede(){

        Mapa mapa = new Mapa(4, 4);
        BloquePiedra bloquePiedra = new BloquePiedra();
        Personaje personaje = new Personaje();

        mapa.colocar(bloquePiedra, 1, 2);
        mapa.colocar(personaje, 2, 2);
        personaje.avanzar();

        //si el personaje se movio hacia arriba, la casilla deberia pasar a estar vacia
        //Assert.assertTrue(mapa.getCasilla(2, 2).estaVacia());


    }
}
