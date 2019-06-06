package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;

public class PicoTest {

    @Test
    public void test01losConstructoresDelPicoDevuelvenAlgoDistintoDeNull() {

        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        Metal metal = new Metal();

        Pico picoDeMadera = new Pico(madera);
        Pico picoDePiedra = new Pico(piedra);
        Pico picoDeMetal = new Pico(metal);

        Assert.assertNotNull(picoDeMadera);
        Assert.assertNotNull(picoDePiedra);
        Assert.assertNotNull(picoDeMetal);
    }

    @Test
    public void test02PicoDeMaderaRecienCreadoTieneDurabilidad100() {
        Madera madera = new Madera();
        Pico picoDeMadera = new Pico(madera);

        Assert.assertEquals(100, picoDeMadera.getDurabilidad(), 0);
    }

    @Test
    public void test03PicoDeMaderaRecienCreadoTieneFuerza2() {
        Madera madera = new Madera();
        Pico picoDeMadera = new Pico(madera);

        Assert.assertEquals(2, picoDeMadera.getFuerza());
    }

    @Test
    public void test04PicoDePiedraRecienCreadoTieneDurabilidad200() {
        Piedra piedra = new Piedra();
        Pico picoDePiedra = new Pico(piedra);

        Assert.assertEquals(200, picoDePiedra.getDurabilidad(), 0);
    }

    @Test
    public void test05PicoDePiedraRecienCreadoTieneFuerza4() {
        Piedra piedra = new Piedra();
        Pico picoDePiedra = new Pico(piedra);

        Assert.assertEquals(4, picoDePiedra.getFuerza());
    }

    @Test
    public void test06PicoDeMetalRecienCreadoTieneDurabilidad400() {
        Metal metal = new Metal();
        Pico picoDeMetal = new Pico(metal);

        Assert.assertEquals(400, picoDeMetal.getDurabilidad(), 0);
    }

    @Test
    public void test07PicoDeMetalRecienCreadoTieneFuerza12() {
        Metal metal = new Metal();
        Pico picoDeMetal = new Pico(metal);

        Assert.assertEquals(12, picoDeMetal.getFuerza());
    }


    @Test
    public void test08PicoDeMaderaSeUsaContraCadaUnoDeLosBloquesYSeReduceSuDurabilidadCorrespondienteAlMaterialDelPico() {
        Madera madera = new Madera();
        Pico picoDeMadera = new Pico(madera);

        BloqueMadera bloqueMadera = new BloqueMadera();
        BloquePiedra bloquePiedra = new BloquePiedra();
        BloqueMetal bloqueMetal = new BloqueMetal();
        BloqueDiamante bloqueDiamante = new BloqueDiamante();

        picoDeMadera.usarEn(bloqueMadera);
        Assert.assertEquals(98.0, picoDeMadera.getDurabilidad(), 0);

        picoDeMadera.usarEn(bloquePiedra);
        Assert.assertEquals(96.0, picoDeMadera.getDurabilidad(), 0);

        picoDeMadera.usarEn(bloqueMetal);
        Assert.assertEquals(94.0, picoDeMadera.getDurabilidad(), 0);

        picoDeMadera.usarEn(bloqueDiamante);
        Assert.assertEquals(92.0, picoDeMadera.getDurabilidad(), 0);
    }

    @Test
    public void test09PicoDePiedraSeUsaContraCadaUnoDeLosBloquesYSeReduceSuDurabilidadCorrespondienteAlMaterialDelPico() {
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
    public void test10PicoDeMetalSeUsaContraCadaUnoDeLosBloquesYSeReduceSuDurabilidadCorrespondienteAlMaterialDelPico() {
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

    @Test
    public void test11CuandoLaDurabilidadDelPicoLlegaACeroNoSeReduceMas(){

        Pico picoMetal = new Pico(new Metal());

        //el hacha nunca dania al bloque de piedra, permite abstraerse de la durabilidad del bloque
        BloqueMetal bloqueMetal = new BloqueMetal();

        //golpea 50 veces
        for(int i = 0; i < 12; i++){

            picoMetal.usarEn(bloqueMetal);
        }

        Assert.assertEquals(0, picoMetal.getDurabilidad(), 0);

        picoMetal.usarEn(bloqueMetal);
        Assert.assertEquals(0, picoMetal.getDurabilidad(), 0);

    }


}

