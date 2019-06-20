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

    @Test
    public void testJugadorGolpeaUnBloqueUbicadoPorEncimaSuyoYSeVerificaQueSeDaniaLaHerramienta(){

        Mapa mapa = new Mapa(5, 5);
        Jugador jugador = new Jugador(mapa);
        mapa.colocarJugador(jugador, 2, 2);
        BloqueMadera bloqueMadera = new BloqueMadera();

        mapa.colocarBloque(bloqueMadera, 1, 2);

        double durabilidadHerramienta = jugador.getDurabilidadHerramientaActual();

        jugador.golpear(new HaciaArriba());
        Assert.assertEquals(durabilidadHerramienta - 2, jugador.getDurabilidadHerramientaActual(), 0);
    }

    @Test
    public void testJugadorGolpeaUnBloqueUbicadoPorDebajoSuyoYSeVerificaQueSeDaniaLaHerramienta(){

        Mapa mapa = new Mapa(5, 5);
        Jugador jugador = new Jugador(mapa);
        mapa.colocarJugador(jugador, 2, 2);
        BloqueMadera bloqueMadera = new BloqueMadera();

        mapa.colocarBloque(bloqueMadera, 3, 2);

        double durabilidadHerramienta = jugador.getDurabilidadHerramientaActual();

        jugador.golpear(new HaciaAbajo());
        Assert.assertEquals(durabilidadHerramienta - 2, jugador.getDurabilidadHerramientaActual(), 0);
    }

    @Test
    public void testJugadorGolpeaUnBloqueUbicadoASuIzquierdaYSeVerificaQueSeDaniaLaHerramienta(){

        Mapa mapa = new Mapa(5, 5);
        Jugador jugador = new Jugador(mapa);
        mapa.colocarJugador(jugador, 2, 2);
        BloqueMadera bloqueMadera = new BloqueMadera();

        mapa.colocarBloque(bloqueMadera, 2, 1);

        double durabilidadHerramienta = jugador.getDurabilidadHerramientaActual();

        jugador.golpear(new HaciaIzquierda());
        Assert.assertEquals(durabilidadHerramienta - 2, jugador.getDurabilidadHerramientaActual(), 0);
    }

    @Test
    public void testJugadorGolpeaUnBloqueUbicadoASuDerechaYSeVerificaQueSeDaniaLaHerramienta(){

        Mapa mapa = new Mapa(5, 5);
        Jugador jugador = new Jugador(mapa);
        mapa.colocarJugador(jugador, 2, 2);
        BloqueMadera bloqueMadera = new BloqueMadera();

        mapa.colocarBloque(bloqueMadera, 2, 3);

        double durabilidadHerramienta = jugador.getDurabilidadHerramientaActual();

        jugador.golpear(new HaciaDerecha());
        Assert.assertEquals(durabilidadHerramienta - 2, jugador.getDurabilidadHerramientaActual(), 0);
    }

    @Test
    public void testJugadorGolpeaContraCasillaVaciaHaciaArribaYSeVerificaQueNoSeDaniaLaHerramienta(){

        Mapa mapa = new Mapa(5, 5);
        Jugador jugador = new Jugador(mapa);
        mapa.colocarJugador(jugador, 2, 2);

        double durabilidadHerramienta = jugador.getDurabilidadHerramientaActual();

        jugador.golpear(new HaciaArriba());
        Assert.assertEquals(durabilidadHerramienta, jugador.getDurabilidadHerramientaActual(), 0);
    }

    @Test
    public void testJugadorGolpeaContraCasillaVaciaHaciaAbajoYSeVerificaQueNoSeDaniaLaHerramienta(){

        Mapa mapa = new Mapa(5, 5);
        Jugador jugador = new Jugador(mapa);
        mapa.colocarJugador(jugador, 2, 2);

        double durabilidadHerramienta = jugador.getDurabilidadHerramientaActual();

        jugador.golpear(new HaciaAbajo());
        Assert.assertEquals(durabilidadHerramienta, jugador.getDurabilidadHerramientaActual(), 0);
    }

    @Test
    public void testJugadorGolpeaContraCasillaVaciaASuIzquierdaYSeVerificaQueNoSeDaniaLaHerramienta(){

        Mapa mapa = new Mapa(5, 5);
        Jugador jugador = new Jugador(mapa);
        mapa.colocarJugador(jugador, 2, 2);

        double durabilidadHerramienta = jugador.getDurabilidadHerramientaActual();

        jugador.golpear(new HaciaIzquierda());
        Assert.assertEquals(durabilidadHerramienta, jugador.getDurabilidadHerramientaActual(), 0);
    }

    @Test
    public void testJugadorGolpeaContraCasillaVaciaASuDerechaYSeVerificaQueNoSeDaniaLaHerramienta(){

        Mapa mapa = new Mapa(5, 5);
        Jugador jugador = new Jugador(mapa);
        mapa.colocarJugador(jugador, 2, 2);

        double durabilidadHerramienta = jugador.getDurabilidadHerramientaActual();

        jugador.golpear(new HaciaDerecha());
        Assert.assertEquals(durabilidadHerramienta, jugador.getDurabilidadHerramientaActual(), 0);
    }

    @Test
    public void testJugadorGolpeaContraHaciaArribaContraLimiteDelMapaYSeLanzaExcepcionPosicionFueraDelMapa(){

        Mapa mapa = new Mapa(5, 5);
        Jugador jugador = new Jugador(mapa);
        mapa.colocarJugador(jugador, 0, 2);

        double durabilidadHerramienta = jugador.getDurabilidadHerramientaActual();

        thrown.expect(PosicionFueraDelMapaException.class);
        jugador.golpear(new HaciaArriba());
    }

    @Test
    public void testJugadorGolpeaContraHaciaAbajoContraLimiteDelMapaYSeLanzaExcepcionPosicionFueraDelMapa(){

        Mapa mapa = new Mapa(5, 5);
        Jugador jugador = new Jugador(mapa);
        mapa.colocarJugador(jugador, 4, 2);

        double durabilidadHerramienta = jugador.getDurabilidadHerramientaActual();

        thrown.expect(PosicionFueraDelMapaException.class);
        jugador.golpear(new HaciaAbajo());
    }

    @Test
    public void testJugadorGolpeaContraHaciaLaIzquierdaContraLimiteDelMapaYSeLanzaExcepcionPosicionFueraDelMapa(){

        Mapa mapa = new Mapa(5, 5);
        Jugador jugador = new Jugador(mapa);
        mapa.colocarJugador(jugador, 3, 0);

        double durabilidadHerramienta = jugador.getDurabilidadHerramientaActual();

        thrown.expect(PosicionFueraDelMapaException.class);
        jugador.golpear(new HaciaIzquierda());
    }

    @Test
    public void testJugadorGolpeaContraHaciaLaDerechaContraLimiteDelMapaYSeLanzaExcepcionPosicionFueraDelMapa(){

        Mapa mapa = new Mapa(5, 5);
        Jugador jugador = new Jugador(mapa);
        mapa.colocarJugador(jugador, 3, 4);

        double durabilidadHerramienta = jugador.getDurabilidadHerramientaActual();

        thrown.expect(PosicionFueraDelMapaException.class);
        jugador.golpear(new HaciaDerecha());
    }




}
