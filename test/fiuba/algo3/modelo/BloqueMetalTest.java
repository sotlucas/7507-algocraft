package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BloqueMetalTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01AlCrearseBloqueDeMetalDevuelveAlgoDistintoDeNull(){

        BloqueMetal bloqueMetal = new BloqueMetal();

        Assert.assertNotNull(bloqueMetal);
    }

    @Test
    public void test02BloqueDeMetalEsGolpeadoConHachaDeMaderaYNoSeReduceSuDurabilidad(){

        Hacha hachaMadera = new Hacha(new Madera());

        BloqueMetal bloqueMetal = new BloqueMetal();
        double durabilidadInicialBloque = bloqueMetal.getDurabilidad();

        bloqueMetal.recibirDanio(hachaMadera);

        Assert.assertEquals(durabilidadInicialBloque, bloqueMetal.getDurabilidad(), 0);
    }

    @Test
    public void test03BloqueDeMetalEsGolpeadoConHachaDePiedraYNoSeReduceSuDurabilidad(){

        Hacha hachaPiedra = new Hacha(new Piedra());

        BloqueMetal bloqueMetal = new BloqueMetal();
        double durabilidadInicialBloque = bloqueMetal.getDurabilidad();

        bloqueMetal.recibirDanio(hachaPiedra);

        Assert.assertEquals(durabilidadInicialBloque, bloqueMetal.getDurabilidad(), 0);
    }

    @Test
    public void test04BloqueDeMetalEsGolpeadoConHachaDeMetalYNoSeReduceSuDurabilidad(){

        Hacha hachaMetal = new Hacha(new Metal());

        BloqueMetal bloqueMetal = new BloqueMetal();
        double durabilidadInicialBloque = bloqueMetal.getDurabilidad();

        bloqueMetal.recibirDanio(hachaMetal);

        Assert.assertEquals(durabilidadInicialBloque, bloqueMetal.getDurabilidad(), 0);
    }

    @Test
    public void test05BloqueDeMetalEsGolpeadoConPicoDeMaderaYNoSeReduceSuDurabilidad(){

        Pico picoMadera = new Pico(new Madera());

        BloqueMetal bloqueMetal = new BloqueMetal();
        double durabilidadInicialBloque = bloqueMetal.getDurabilidad();

        bloqueMetal.recibirDanio(picoMadera);

        Assert.assertEquals(durabilidadInicialBloque, bloqueMetal.getDurabilidad(), 0);
    }

    @Test
    public void test06BloqueDeMetalEsGolpeadoConPicoDePiedraYSeReduceSuDurabilidadCorrectamente(){

        Piedra piedra = new Piedra();
        Pico picoDePiedra = new Pico(piedra);

        BloqueMetal bloqueMetal = new BloqueMetal();
        int durabilidadInicialBloque = bloqueMetal.getDurabilidad();

        bloqueMetal.recibirDanio(picoDePiedra);

        Assert.assertEquals(durabilidadInicialBloque - 4, bloqueMetal.getDurabilidad());
    }

    @Test
    public void test07BloqueDeMetalEsGolpeadoConPicoDeMetalYSeVerificaQueNoSeReduceSuDurabilidad(){

        Pico picoDeMetal = new Pico(new Metal());

        BloqueMetal bloque = new BloqueMetal();
        int durabilidadInicialBloque = bloque.getDurabilidad();

        bloque.recibirDanio(picoDeMetal);

        Assert.assertEquals(durabilidadInicialBloque, bloque.getDurabilidad());
    }

    @Test
    public void test08BloqueDeMetalEsGolpeadoConPicoFinoYSeVerificaQueNoSeReduceSuDurabilidad(){

        PicoFino picoFino = new PicoFino();

        BloqueMetal bloque = new BloqueMetal();
        int durabilidadInicialBloque = bloque.getDurabilidad();

        bloque.recibirDanio(picoFino);

        Assert.assertEquals(durabilidadInicialBloque, bloque.getDurabilidad());
    }



    @Test
    public void test09CuandoLaDurabilidadDelBloqueDeMetalLlegaACeroNoSeReduceMas(){

        Piedra piedra = new Piedra();
        Pico picoDePiedra = new Pico(piedra);

        BloqueMetal bloqueMetal = new BloqueMetal();

        //golpea 12 veces hasta casi el limite de durabilidad del bloque
        for(int i = 0; i < 12; i++){

            bloqueMetal.recibirDanio(picoDePiedra);
        }

        Assert.assertEquals(2, bloqueMetal.getDurabilidad());

        thrown.expect(BloqueSeRompioException.class);
        bloqueMetal.recibirDanio(picoDePiedra);

    }

}