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

    }

}
