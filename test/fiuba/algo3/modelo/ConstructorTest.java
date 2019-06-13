package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import fiuba.algo3.modelo.Constructor;

public class ConstructorTest {

    private Constructor constructor = new Constructor();

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Test
    public void testMandoRecetaDeHachaDeMaderaYReciboUnHacha() {
        Hacha hachaDeMadera1 = new Hacha(new Madera());

        Herramienta hachaDeMadera2 = constructor.craftear("mm-mm--m-");

        Assert.assertEquals(hachaDeMadera1.getClass(), hachaDeMadera2.getClass());
    }

    @Test
    public void testMandoRecetaDeHachaDeMaderaYElMaterialDeLoRecibidoEsMadera() {
        Madera madera = new Madera();

        Herramienta hachaDeMadera = constructor.craftear("mm-mm--m-");

        Assert.assertEquals(madera.getClass(), hachaDeMadera.getMaterial().getClass());
    }

    @Test
    public void testMandoRecetaDeHachaDePiedraYReciboUnHacha() {
        Hacha hachaDePiedra1 = new Hacha(new Piedra());

        Herramienta hachaDePiedra2 = constructor.craftear("pp-pm--m-");

        Assert.assertEquals(hachaDePiedra1.getClass(), hachaDePiedra2.getClass());
    }

    @Test
    public void testMandoRecetaDeHachaDePiedraYElMaterialDeLoRecibidoEsPiedra() {
        Piedra piedra = new Piedra();

        Herramienta hachaDePiedra = constructor.craftear("pp-pm--m-");

        Assert.assertEquals(piedra.getClass(), hachaDePiedra.getMaterial().getClass());
    }

    @Test
    public void testMandoRecetaDeHachaDeMetalYReciboUnHacha() {
        Hacha hachaDeMetal1 = new Hacha(new Metal());

        Herramienta hachaDeMetal2 = constructor.craftear("MM-Mm--m-");

        Assert.assertEquals(hachaDeMetal1.getClass(), hachaDeMetal2.getClass());
    }

    @Test
    public void testMandoRecetaDeHachaDeMetalYElMaterialDeLoRecibidoEsMetal() {
        Metal metal = new Metal();

        Herramienta hachaDeMetal = constructor.craftear("MM-Mm--m-");

        Assert.assertEquals(metal.getClass(), hachaDeMetal.getMaterial().getClass());
    }

    @Test
    public void testMandoRecetaDePicoDeMaderaYReciboUnPico() {
        Pico picoDeMadera1 = new Pico(new Madera());

        Herramienta picoDeMadera2 = constructor.craftear("mmm-m--m-");

        Assert.assertEquals(picoDeMadera1.getClass(), picoDeMadera2.getClass());
    }

    @Test
    public void testMandoRecetaDePicoDeMaderaYElMaterialDeLoRecibidoEsMadera() {
        Madera madera = new Madera();

        Herramienta picoDeMadera = constructor.craftear("mmm-m--m-");

        Assert.assertEquals(madera.getClass(), picoDeMadera.getMaterial().getClass());
    }

    @Test
    public void testMandoRecetaDePicoDePiedraYReciboUnPico() {
        Pico picoDePiedra1 = new Pico(new Piedra());

        Herramienta picoDePiedra2 = constructor.craftear("ppp-m--m-");

        Assert.assertEquals(picoDePiedra1.getClass(), picoDePiedra2.getClass());
    }

    @Test
    public void testMandoRecetaDePicoDePiedraYElMaterialDeLoRecibidoEsPiedra() {
        Piedra piedra = new Piedra();

        Herramienta picoDePiedra = constructor.craftear("ppp-m--m-");

        Assert.assertEquals(piedra.getClass(), picoDePiedra.getMaterial().getClass());
    }

    @Test
    public void testMandoRecetaDePicoDeMetalYReciboUnPico() {
        Pico picoDeMetal1 = new Pico(new Metal());

        Herramienta picoDeMetal2 = constructor.craftear("MMM-m--m-");

        Assert.assertEquals(picoDeMetal1.getClass(), picoDeMetal2.getClass());
    }

    @Test
    public void testMandoRecetaDePicoDeMetalYElMaterialDeLoRecibidoEsMetal() {
        Metal metal = new Metal();

        Herramienta picoDeMetal = constructor.craftear("MMM-m--m-");

        Assert.assertEquals(metal.getClass(), picoDeMetal.getMaterial().getClass());
    }

    @Test
    public void testMandoRecetaDePicoFinoYReciboUnPicoFino() {
        PicoFino picoFino1 = new PicoFino();

        Herramienta picoFino2 = constructor.craftear("MMMpm--m-");

        Assert.assertEquals(picoFino1.getClass(), picoFino2.getClass());
    }

    @Test
    public void testMandoRecetaInexistenteYDevuelveRecetaNoExisteException() {
        thrown.expect(RecetaNoExisteException.class);
        constructor.craftear("---pm--m-");
    }
}
