package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;

public class IntegracionTests {

    @Test
    public void test02BloqueDeMaderaEsImpactadoConHachasDeDistintosMaterialesYSeReduceSuDurabilidadDependiendoDeLaFuerzaDelHacha(){

        Hacha hachaDeMadera = new Hacha(new Madera());
        Hacha hachaDeMetal = new Hacha(new Metal());
        Hacha hachaDePiedra = new Hacha(new Piedra());

        BloqueMadera bloqueMadera = new BloqueMadera();
        int durabilidadInicialBloque = bloqueMadera.getDurabilidad();

        hachaDePiedra.usarEn(bloqueMadera);
        Assert.assertEquals(durabilidadInicialBloque - 5, bloqueMadera.getDurabilidad());

        hachaDeMadera.usarEn(bloqueMadera);
        Assert.assertEquals(durabilidadInicialBloque - 7, bloqueMadera.getDurabilidad());

        hachaDeMetal.usarEn(bloqueMadera);
        //no puede reducirse mas que 10 unidades porque alcanza el cero
        Assert.assertEquals(durabilidadInicialBloque - 10, bloqueMadera.getDurabilidad());
    }

    @Test
    public void test03BloqueDeMaderaEsImpactadoConTodosLosTiposDePicosYNoSeReduceSuDurabilidad(){

        Pico picoMadera = new Pico(new Madera());
        Pico picoPiedra = new Pico(new Piedra());
        Pico picoMetal = new Pico(new Metal());
        PicoFino picoFino = new PicoFino();

        BloqueMadera bloqueMadera = new BloqueMadera();
        int durabilidadInicialBloque = bloqueMadera.getDurabilidad();

        picoMadera.usarEn(bloqueMadera);
        Assert.assertEquals(durabilidadInicialBloque, bloqueMadera.getDurabilidad());

        picoPiedra.usarEn(bloqueMadera);
        Assert.assertEquals(durabilidadInicialBloque, bloqueMadera.getDurabilidad());

        picoMetal.usarEn(bloqueMadera);
        Assert.assertEquals(durabilidadInicialBloque, bloqueMadera.getDurabilidad());

        picoFino.usarEn(bloqueMadera);
        Assert.assertEquals(durabilidadInicialBloque, bloqueMadera.getDurabilidad());
    }

    @Test
    public void test04BloqueDePiedraEsImpactadoConPicosDeDistintosMaterialesYSeReduceLaDurabilidadDependiendoDelMaterialDelPico(){

        Pico picoMadera = new Pico(new Madera());
        Pico picoPiedra = new Pico(new Piedra());
        Pico picoMetal = new Pico(new Metal());
        PicoFino picoFino = new PicoFino();

        BloquePiedra bloquePiedra = new BloquePiedra();
        int durabilidadInicialBloque = bloquePiedra.getDurabilidad();

        picoMadera.usarEn(bloquePiedra);
        Assert.assertEquals(durabilidadInicialBloque-2, bloquePiedra.getDurabilidad());

        picoPiedra.usarEn(bloquePiedra);
        Assert.assertEquals(durabilidadInicialBloque-6, bloquePiedra.getDurabilidad());

        picoMetal.usarEn(bloquePiedra);
        Assert.assertEquals(durabilidadInicialBloque-18, bloquePiedra.getDurabilidad());

        picoFino.usarEn(bloquePiedra);
        Assert.assertEquals(durabilidadInicialBloque-18, bloquePiedra.getDurabilidad());

    }

    @Test
    public void test03BloqueDePiedraEsImpactadoConTodosLosTiposDeHachasYNoSeReduceSuDurabilidad(){

        Hacha hachaDeMadera = new Hacha(new Madera());
        Hacha hachaDeMetal = new Hacha(new Metal());
        Hacha hachaDePiedra = new Hacha(new Piedra());

        BloquePiedra bloquePiedra = new BloquePiedra();
        int durabilidadInicialBloque = bloquePiedra.getDurabilidad();

        hachaDePiedra.usarEn(bloquePiedra);
        Assert.assertEquals(durabilidadInicialBloque, bloquePiedra.getDurabilidad());

        hachaDeMadera.usarEn(bloquePiedra);
        Assert.assertEquals(durabilidadInicialBloque, bloquePiedra.getDurabilidad());

        hachaDeMetal.usarEn(bloquePiedra);
        Assert.assertEquals(durabilidadInicialBloque, bloquePiedra.getDurabilidad());
    }

    @Test
    public void test04BloqueDeMetalEsImpactadoConHachasDeDistintosMaterialesYNoSeReduceSuDurabilidad(){

        Hacha hachaDeMadera = new Hacha(new Madera());
        Hacha hachaDeMetal = new Hacha(new Metal());
        Hacha hachaDePiedra = new Hacha(new Piedra());

        BloqueMetal bloqueMetal = new BloqueMetal();
        int durabilidadInicialBloque = bloqueMetal.getDurabilidad();

        hachaDePiedra.usarEn(bloqueMetal);
        Assert.assertEquals(durabilidadInicialBloque, bloqueMetal.getDurabilidad());

        hachaDeMadera.usarEn(bloqueMetal);
        Assert.assertEquals(durabilidadInicialBloque, bloqueMetal.getDurabilidad());

        hachaDeMetal.usarEn(bloqueMetal);
        Assert.assertEquals(durabilidadInicialBloque, bloqueMetal.getDurabilidad());
    }

    @Test //obligatoria
    public void test02BloqueDeMetalRecibeGolpesDeTodosLosTiposDePicosYSoloReduceSuDurabilidadAlSerImpactadoConPicoDePiedra() {

        Pico picoMadera = new Pico(new Madera());
        Pico picoPiedra = new Pico(new Piedra());
        Pico picoMetal = new Pico(new Metal());
        PicoFino picoFino = new PicoFino();

        BloqueMetal bloqueMetal = new BloqueMetal();

        picoMadera.usarEn(bloqueMetal);
        picoFino.usarEn(bloqueMetal);
        picoMetal.usarEn(bloqueMetal);

        Assert.assertEquals(50, bloqueMetal.getDurabilidad());

        picoPiedra.usarEn(bloqueMetal);
        Assert.assertEquals(46, bloqueMetal.getDurabilidad());
    }

    @Test
    public void test00BloqueDeDiamanteRecibeGolpesDeTodasLasHerramientasYReduceSuDurabilidadConElImpactoDelPicoFino(){

        Hacha hachaDeMadera = new Hacha(new Madera());
        Hacha hachaDeMetal = new Hacha(new Metal());
        Hacha hachaDePiedra = new Hacha(new Piedra());

        Pico picoMadera = new Pico(new Madera());
        Pico picoPiedra = new Pico(new Piedra());
        Pico picoMetal = new Pico(new Metal());

        PicoFino picoFino = new PicoFino();

        BloqueDiamante bloqueDiamante = new BloqueDiamante();

        int durabilidadInicialBloque = bloqueDiamante.getDurabilidad();

        hachaDeMadera.usarEn(bloqueDiamante);
        hachaDeMetal.usarEn(bloqueDiamante);
        hachaDePiedra.usarEn(bloqueDiamante);
        picoMadera.usarEn(bloqueDiamante);
        picoPiedra.usarEn(bloqueDiamante);
        picoMetal.usarEn(bloqueDiamante);

        Assert.assertEquals(durabilidadInicialBloque, bloqueDiamante.getDurabilidad());

        picoFino.usarEn(bloqueDiamante);
        Assert.assertEquals(durabilidadInicialBloque-20, bloqueDiamante.getDurabilidad());

    }
}
