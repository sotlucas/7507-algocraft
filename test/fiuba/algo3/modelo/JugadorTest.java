package fiuba.algo3.modelo;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class JugadorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testAlCrearJugadorEsDistintoDeNull(){
        Jugador jugador = new Jugador();

        Assert.assertNotNull(jugador);
    }

    @Test
    public void testJugadorRecienCreadoIniciaConHachaDeMaderaEnElInventario() {
        Jugador jugador = new Jugador();
        Madera madera = new Madera();
        Hacha hachaDeMadera = new Hacha(madera);

        Assert.assertTrue(jugador.inventarioContieneHerramienta(hachaDeMadera));
    }

    @Test
    public void testJugadorAgregaUnaMaderaASuInventarioYSeVerificaQueSeGuardo() {
        Jugador jugador = new Jugador();
        Madera madera = new Madera();

        jugador.agregarMaterialAInventario(madera);

        Assert.assertTrue(jugador.inventarioContieneMaterial(madera)); 
    }

    @Test
    public void testJugadorCrafteaHachaDeMaderaPosicionandoMaterialesEnMesaDeCrafteo() {
        Jugador jugador = new Jugador();

        for (int i = 0; i < 5; i++) {
            jugador.agregarMaterialAInventario(new Madera());
        }

        jugador.seleccionarMaterial(0);
        jugador.colocarEnMesa(0);
        jugador.seleccionarMaterial(1);
        jugador.colocarEnMesa(1);
        jugador.seleccionarMaterial(2);
        jugador.colocarEnMesa(3);
        jugador.seleccionarMaterial(3);
        jugador.colocarEnMesa(4);
        jugador.seleccionarMaterial(4);
        jugador.colocarEnMesa(7);

        jugador.craftear();

        Assert.assertTrue(jugador.inventarioContieneHerramienta(new Hacha(new Madera()))); 
    }

    @Test
    public void testJugadorPosicionaMalMaterialesEnMesaDeCrafteoLanzaRecetaNoExisteException() {
        Jugador jugador = new Jugador();

        for (int i = 0; i < 5; i++) {
            jugador.agregarMaterialAInventario(new Madera());
        }

        jugador.seleccionarMaterial(0);
        jugador.colocarEnMesa(0);
        jugador.seleccionarMaterial(1);
        jugador.colocarEnMesa(1);
        jugador.seleccionarMaterial(2);
        jugador.colocarEnMesa(2);
        jugador.seleccionarMaterial(3);
        jugador.colocarEnMesa(3);
        jugador.seleccionarMaterial(4);
        jugador.colocarEnMesa(4);

        thrown.expect(RecetaNoExisteException.class);
        jugador.craftear();
    }
}
