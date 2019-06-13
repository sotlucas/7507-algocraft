package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;
import fiuba.algo3.modelo.Constructor;

public class ConstructorTest {
    
    @Test
    public void testMandoRecetaDeHachaDeMaderaYReciboUnHacha() {
        Constructor constructor = new Constructor();
        Hacha hachaDeMadera1 = new Hacha(new Madera());

        Herramienta hachaDeMadera2 = constructor.craftear("mm-mm--m-");

        Assert.assertEquals(hachaDeMadera1.getClass(), hachaDeMadera2.getClass());
    }

    @Test
    public void testMandoRecetaDeHachaDeMaderaYElMaterialDeLoRecibidoEsMadera() {
        Constructor constructor = new Constructor();
        Madera madera = new Madera();

        Herramienta hachaDeMadera = constructor.craftear("mm-mm--m-");

        Assert.assertEquals(madera.getClass(), hachaDeMadera.getMaterial().getClass());
    }

    @Test
    public void testMandoRecetaDeHachaDePiedraYReciboUnHacha() {
        Constructor constructor = new Constructor();
        Hacha hachaDePiedra1 = new Hacha(new Piedra());

        Herramienta hachaDePiedra2 = constructor.craftear("pp-pm--m-");

        Assert.assertEquals(hachaDePiedra1.getClass(), hachaDePiedra2.getClass());
    }

    @Test
    public void testMandoRecetaDeHachaDePiedraYElMaterialDeLoRecibidoEsPiedra() {
        Constructor constructor = new Constructor();
        Piedra piedra = new Piedra();

        Herramienta hachaDePiedra = constructor.craftear("pp-pm--m-");

        Assert.assertEquals(piedra.getClass(), hachaDePiedra.getMaterial().getClass());
    }

    @Test
    public void testMandoRecetaDeHachaDeMetalYReciboUnHacha() {
        Constructor constructor = new Constructor();
        Hacha hachaDeMetal1 = new Hacha(new Metal());

        Herramienta hachaDeMetal2 = constructor.craftear("MM-Mm--m-");

        Assert.assertEquals(hachaDeMetal1.getClass(), hachaDeMetal2.getClass());
    }

    @Test
    public void testMandoRecetaDeHachaDeMetalYElMaterialDeLoRecibidoEsMetal() {
        Constructor constructor = new Constructor();
        Metal metal = new Metal();

        Herramienta hachaDeMetal = constructor.craftear("MM-Mm--m-");

        Assert.assertEquals(metal.getClass(), hachaDeMetal.getMaterial().getClass());
    }

    @Test
    public void testMandoRecetaDePicoDeMaderaYReciboUnPico() {
        Constructor constructor = new Constructor();
        Pico picoDeMadera1 = new Pico(new Madera());

        Herramienta picoDeMadera2 = constructor.craftear("mmm-m--m-");

        Assert.assertEquals(picoDeMadera1.getClass(), picoDeMadera2.getClass());
    }

    @Test
    public void testMandoRecetaDePicoDeMaderaYElMaterialDeLoRecibidoEsMadera() {
        Constructor constructor = new Constructor();
        Madera madera = new Madera();

        Herramienta picoDeMadera = constructor.craftear("mmm-m--m-");

        Assert.assertEquals(madera.getClass(), picoDeMadera.getMaterial().getClass());
    }

    @Test
    public void testMandoRecetaDePicoDePiedraYReciboUnPico() {
        Constructor constructor = new Constructor();
        Pico picoDePiedra1 = new Pico(new Piedra());

        Herramienta picoDePiedra2 = constructor.craftear("ppp-m--m-");

        Assert.assertEquals(picoDePiedra1.getClass(), picoDePiedra2.getClass());
    }

    @Test
    public void testMandoRecetaDePicoDePiedraYElMaterialDeLoRecibidoEsPiedra() {
        Constructor constructor = new Constructor();
        Piedra piedra = new Piedra();

        Herramienta picoDePiedra = constructor.craftear("ppp-m--m-");

        Assert.assertEquals(piedra.getClass(), picoDePiedra.getMaterial().getClass());
    }

    @Test
    public void testMandoRecetaDePicoDeMetalYReciboUnPico() {
        Constructor constructor = new Constructor();
        Pico picoDeMetal1 = new Pico(new Metal());

        Herramienta picoDeMetal2 = constructor.craftear("MMM-m--m-");

        Assert.assertEquals(picoDeMetal1.getClass(), picoDeMetal2.getClass());
    }

    @Test
    public void testMandoRecetaDePicoDeMetalYElMaterialDeLoRecibidoEsMetal() {
        Constructor constructor = new Constructor();
        Metal metal = new Metal();

        Herramienta picoDeMetal = constructor.craftear("MMM-m--m-");

        Assert.assertEquals(metal.getClass(), picoDeMetal.getMaterial().getClass());
    }

    @Test
    public void testMandoRecetaDePicoFinoYReciboUnPicoFino() {
        Constructor constructor = new Constructor();
        PicoFino picoFino1 = new PicoFino();

        Herramienta picoFino2 = constructor.craftear("MMMpm--m-");

        Assert.assertEquals(picoFino1.getClass(), picoFino2.getClass());
    }
}
