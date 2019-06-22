package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class ConstructorHerramientaTest {

    @Test
    public void testAlLlamarAlConstructorDeHachaMaderaSeCreaCorrectamente(){

        ConstruirHachaMadera constructorHachaMadera = new ConstruirHachaMadera();
        Hacha hachaMadera = constructorHachaMadera.construir();

        Assert.assertEquals(new Hacha(new Madera()).getClass(), hachaMadera.getClass());
    }

    @Test
    public void testAlLlamarAlConstructorDeHachaPiedraSeCreaCorrectamente(){

        ConstruirHachaPiedra construirHachaPiedra = new ConstruirHachaPiedra();
        Hacha hachaPiedra = construirHachaPiedra.construir();

        Assert.assertEquals(new Hacha(new Piedra()).getClass(), hachaPiedra.getClass());
    }

    @Test
    public void testAlLlamarAlConstructorDeHachaMetalSeCreaCorrectamente(){

        ConstruirHachaMetal construirHachaMetal = new ConstruirHachaMetal();
        Hacha hachaMetal = construirHachaMetal.construir();

        Assert.assertEquals(new Hacha(new Metal()).getClass(), hachaMetal.getClass());
    }

    @Test
    public void testAlLlamarAlConstructorDePicoMaderaSeCreaCorrectamente(){

        ConstruirPicoMadera construirPicoMadera = new ConstruirPicoMadera();
        Pico picoMadera = construirPicoMadera.construir();

        Assert.assertEquals(new Pico(new Madera()).getClass(), picoMadera.getClass());
    }

    @Test
    public void testAlLlamarAlConstructorDePicoPiedraSeCreaCorrectamente(){

        ConstruirPicoPiedra construirPicoPiedra = new ConstruirPicoPiedra();
        Pico picoPiedra = construirPicoPiedra.construir();

        Assert.assertEquals(new Pico(new Piedra()).getClass(), picoPiedra.getClass());
    }

    @Test
    public void testAlLlamarAlConstructorDePicoMetalSeCreaCorrectamente(){

        ConstruirPicoMetal construirPicoMetal = new ConstruirPicoMetal();
        Pico picoMetal = construirPicoMetal.construir();

        Assert.assertEquals(new Pico(new Metal()).getClass(), picoMetal.getClass());
    }

    @Test
    public void testAlLlamarAlConstructorDePicoFinoSeCreaCorrectamente(){

        ConstruirPicoFino construirPicoFino = new ConstruirPicoFino();
        PicoFino picoFino = construirPicoFino.construir();

        Assert.assertEquals(new PicoFino().getClass(), picoFino.getClass());
    }
}
