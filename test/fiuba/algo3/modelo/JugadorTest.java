package fiuba.algo3.modelo;

import org.junit.Test;

import org.junit.Assert;

public class JugadorTest {

    @Test
    public void test01JugadorRecienCreadoIniciaConHachaDeMaderaEnElInventario() {
        Jugador jugador = new Jugador();
        Madera madera = new Madera();
        Hacha hachaDeMadera = new Hacha(madera);

        Assert.assertTrue(jugador.inventarioContiene(hachaDeMadera));
    }
}
