package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;

public class JuegoTest {

    @Test
    public void testAlCrearseUnaInstanciaDeJuegoElMapaPoseeLaCantidadDeFilasCorrectas() {

        Juego juego = new Juego();

        Assert.assertEquals(9, juego.getCantidadFilasMapa());
    }

    @Test
    public void testAlCrearseUnaInstanciaDeJuegoElMapaPoseeLaCantidadDeColumnasCorrectas() {

        Juego juego = new Juego();

        Assert.assertEquals(13, juego.getCantidadColumnasMapa());
    }

    @Test
    public void testAlCrearseUnaInstanciaDeJuegoElJugadorSeIniciaEnLaPosicionCorrecta() {

        Juego juego = new Juego();

        Assert.assertEquals(7, juego.getColumnaJugador());
        Assert.assertEquals(7, juego.getFilaJugador());
    }

    @Test
    public void testAlCrearseUnaInstanciaDeJuegoLosBloquesSeInicializanEnLaPosicionCorrecta(){

        Juego juego = new Juego();

        //jugador
        Assert.assertFalse(juego.casillaEstaVacia(7, 7));

        //bloques de metal
        Assert.assertFalse(juego.casillaEstaVacia(1, 1));
        Assert.assertFalse(juego.casillaEstaVacia(1, 2));
        Assert.assertFalse(juego.casillaEstaVacia(2, 1));
        Assert.assertFalse(juego.casillaEstaVacia(2, 2));

        //bloques de madera
        Assert.assertFalse(juego.casillaEstaVacia(4, 1));
        Assert.assertFalse(juego.casillaEstaVacia(4, 2));
        Assert.assertFalse(juego.casillaEstaVacia(4, 3));
        Assert.assertFalse(juego.casillaEstaVacia(4, 4));
        Assert.assertFalse(juego.casillaEstaVacia(5, 1));
        Assert.assertFalse(juego.casillaEstaVacia(5, 2));
        Assert.assertFalse(juego.casillaEstaVacia(5, 3));
        Assert.assertFalse(juego.casillaEstaVacia(5, 4));
        Assert.assertFalse(juego.casillaEstaVacia(6, 1));
        Assert.assertFalse(juego.casillaEstaVacia(6, 2));
        Assert.assertFalse(juego.casillaEstaVacia(6, 3));
        Assert.assertFalse(juego.casillaEstaVacia(6, 4));
        Assert.assertFalse(juego.casillaEstaVacia(7, 1));
        Assert.assertFalse(juego.casillaEstaVacia(7, 2));
        Assert.assertFalse(juego.casillaEstaVacia(7, 3));
        Assert.assertFalse(juego.casillaEstaVacia(7, 4));

        //bloques de piedra
        Assert.assertFalse(juego.casillaEstaVacia(4, 9));
        Assert.assertFalse(juego.casillaEstaVacia(4, 10));
        Assert.assertFalse(juego.casillaEstaVacia(5, 9));
        Assert.assertFalse(juego.casillaEstaVacia(5, 10));

    }
}
