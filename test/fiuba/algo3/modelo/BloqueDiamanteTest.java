package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class BloqueDiamanteTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01AlCrearseBloqueDeDiamanteDevuelveAlgoDistintoDeNull(){

        BloqueDiamante bloqueDiamante = new BloqueDiamante();

        Assert.assertNotNull(bloqueDiamante);
    }

    @Test //obligatoria
    public void test02BloqueDeDiamanteEsGolpeadoConHachaDeMaderaYSeVerificaQueNoSeReduceSuDurabilidad(){

        Madera madera = new Madera();
        Hacha hachaDeMadera = new Hacha(madera);

        BloqueDiamante bloque = new BloqueDiamante();

        bloque.recibirDanio(hachaDeMadera);

        Assert.assertEquals(100, bloque.getDurabilidad());
    }

    @Test //obligatoria
    public void test03BloqueDeDiamanteEsGolpeadoConHachaDePiedraYSeVerificaQueNoSeReduceSuDurabilidad(){


        Hacha hachaDePiedra = new Hacha(new Piedra());

        BloqueDiamante bloque = new BloqueDiamante();

        bloque.recibirDanio(hachaDePiedra);

        Assert.assertEquals(100, bloque.getDurabilidad());
    }

    @Test //obligatoria
    public void test04BloqueDeDiamanteEsGolpeadoConHachaDeMetalYSeVerificaQueNoSeReduceSuDurabilidad(){


        Hacha hachaDeMetal = new Hacha(new Metal());

        BloqueDiamante bloque = new BloqueDiamante();

        bloque.recibirDanio(hachaDeMetal);

        Assert.assertEquals(100, bloque.getDurabilidad());
    }



    @Test //obligatoria
    public void test05BloqueDeDiamanteEsGolpeadoConPicoDeMaderaYSeVerificaQueNoSeReduceSuDurabilidad(){

        Madera madera = new Madera();
        Pico picoDeMadera = new Pico(madera);

        BloqueDiamante bloque = new BloqueDiamante();

        bloque.recibirDanio(picoDeMadera);

        Assert.assertEquals(100, bloque.getDurabilidad());

    }
    @Test //obligatoria
    public void test06BloqueDeDiamanteEsGolpeadoConPicoDePiedraYSeVerificaQueNoSeReduceSuDurabilidad(){

        Pico picoDePiedra = new Pico(new Piedra());

        BloqueDiamante bloque = new BloqueDiamante();

        bloque.recibirDanio(picoDePiedra);

        Assert.assertEquals(100, bloque.getDurabilidad());

    }

    @Test //obligatoria
    public void test07BloqueDeDiamanteEsGolpeadoConPicoDeMetalYSeVerificaQueNoSeReduceSuDurabilidad(){


        Pico picoDeMadera = new Pico(new Metal());

        BloqueDiamante bloque = new BloqueDiamante();

        bloque.recibirDanio(picoDeMadera);

        Assert.assertEquals(100, bloque.getDurabilidad());

    }

    @Test //obligatoria
    public void test08BloqueDeDiamanteEsGolpeadoConPicoFinoYSeVerificaQueSeReduceSuDurabilidad(){

        PicoFino picoFino = new PicoFino();

        BloqueDiamante bloque = new BloqueDiamante();

        bloque.recibirDanio(picoFino);

        Assert.assertEquals(80, bloque.getDurabilidad());

    }

    @Test
    public void test09CuandoLaDurabilidadDelBloqueDeDiamanteLlegaACeroNoSeReduceMas(){

        PicoFino picoFino = new PicoFino();

        BloqueDiamante bloqueDiamante = new BloqueDiamante();

        bloqueDiamante.recibirDanio(picoFino);
        bloqueDiamante.recibirDanio(picoFino);
        bloqueDiamante.recibirDanio(picoFino);
        bloqueDiamante.recibirDanio(picoFino);

        thrown.expect(BloqueSeRompioException.class);
        bloqueDiamante.recibirDanio(picoFino);

    }
}
