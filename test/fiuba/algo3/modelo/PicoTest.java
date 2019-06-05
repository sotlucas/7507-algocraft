package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;

public class PicoTest {

    @Test
    public void test01PicoDeMaderaRecienCreadoTieneDurabilidad100() {
        Madera madera = new Madera();
        Pico picoDeMadera = new Pico(madera);

        Assert.assertEquals(100, picoDeMadera.getDurabilidad(), 0);
    }

    @Test
    public void test02PicoDeMaderaRecienCreadoTieneFuerza2() {
        Madera madera = new Madera();
        Pico picoDeMadera = new Pico(madera);

        Assert.assertEquals(2, picoDeMadera.getFuerza());
    }

    @Test
    public void test03PicoDePiedraRecienCreadoTieneDurabilidad200() {
        Piedra piedra = new Piedra();
        Pico picoDePiedra = new Pico(piedra);

        Assert.assertEquals(200, picoDePiedra.getDurabilidad(), 0);
    }

    @Test
    public void test04PicoDePiedraRecienCreadoTieneFuerza4() {
        Piedra piedra = new Piedra();
        Pico picoDePiedra = new Pico(piedra);

        Assert.assertEquals(4, picoDePiedra.getFuerza());
    }

    @Test
    public void test05PicoDeMetalRecienCreadoTieneDurabilidad400() {
        Metal metal = new Metal();
        Pico picoDeMetal = new Pico(metal);

        Assert.assertEquals(400, picoDeMetal.getDurabilidad(), 0);
    }

    @Test
    public void test06PicoDeMetalRecienCreadoTieneFuerza12() {
        Metal metal = new Metal();
        Pico picoDeMetal = new Pico(metal);

        Assert.assertEquals(12, picoDeMetal.getFuerza());
    }


    @Test
    public void picoDeMaderaSeUsaContraCadaUnoDeLosBloquesYSeReduceSuDurabilidadCorrespondienteAlMaterialDelPico() {
        Madera madera = new Madera();
        Pico picoDeMadera = new Pico(madera);

        BloqueMadera bloqueMadera = new BloqueMadera();
        BloquePiedra bloquePiedra = new BloquePiedra();
        BloqueMetal bloqueMetal = new BloqueMetal();

        picoDeMadera.usarEn(bloqueMadera);
        Assert.assertEquals(98.0, picoDeMadera.getDurabilidad(), 0);

        picoDeMadera.usarEn(bloquePiedra);
        Assert.assertEquals(96.0, picoDeMadera.getDurabilidad(), 0);

        picoDeMadera.usarEn(bloqueMetal);
        Assert.assertEquals(94.0, picoDeMadera.getDurabilidad(), 0);
    }

    @Test
    public void picoDePiedraSeUsaContraCadaUnoDeLosBloquesYSeReduceSuDurabilidadCorrespondienteAlMaterialDelPico() {
        Piedra piedra = new Piedra();
        Pico picoDePiedra = new Pico(piedra);

        BloqueMadera bloqueMadera = new BloqueMadera();
        BloquePiedra bloquePiedra = new BloquePiedra();
        BloqueMetal bloqueMetal = new BloqueMetal();

        picoDePiedra.usarEn(bloqueMadera);
        Assert.assertEquals(197.33, picoDePiedra.getDurabilidad(), 0.01);

        picoDePiedra.usarEn(bloquePiedra);
        Assert.assertEquals(194.66, picoDePiedra.getDurabilidad(), 0.01);

        picoDePiedra.usarEn(bloqueMetal);
        Assert.assertEquals(192.0, picoDePiedra.getDurabilidad(), 0.01);
    }

    @Test
    public void picoDeMetalSeUsaContraCadaUnoDeLosBloquesYSeReduceSuDurabilidadCorrespondienteAlMaterialDelPico() {
        Metal metal = new Metal();
        Pico picoDeMetal = new Pico(metal);

        BloqueMadera bloqueMadera = new BloqueMadera();
        BloquePiedra bloquePiedra = new BloquePiedra();
        BloqueMetal bloqueMetal = new BloqueMetal();

        picoDeMetal.usarEn(bloqueMadera);
        Assert.assertEquals(360.0, picoDeMetal.getDurabilidad(), 0);

        picoDeMetal.usarEn(bloquePiedra);
        Assert.assertEquals(320.0, picoDeMetal.getDurabilidad(), 0);

        picoDeMetal.usarEn(bloqueMetal);
        Assert.assertEquals(280.0, picoDeMetal.getDurabilidad(), 0);
    }


}

