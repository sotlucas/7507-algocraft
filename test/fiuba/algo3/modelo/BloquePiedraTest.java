package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class BloquePiedraTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01AlCrearseBloqueDePiedraDevuelveAlgoDistintoDeNull(){

        BloquePiedra bloquePiedra = new BloquePiedra();

        Assert.assertNotNull(bloquePiedra);
    }

    @Test
    public void test02BloqueDePiedraSeInicializaConDurabilidad30(){
        BloquePiedra bloque = new BloquePiedra();

        Assert.assertEquals(30, bloque.getDurabilidad());
    }



    @Test //obligatoria
    public void test03BloqueDePiedraEsGolpeadoConHachaDeMaderaYNoSeReduceSuDurabilidad(){

        Hacha hachaDeMadera = new Hacha(new Madera());

        BloquePiedra bloquePiedra = new BloquePiedra();

        bloquePiedra.recibirDanio(hachaDeMadera);

        Assert.assertEquals(30, bloquePiedra.getDurabilidad());
    }

    @Test //obligatoria
    public void test04BloqueDePiedraEsGolpeadoConHachaDePiedraYNoSeReduceSuDurabilidad(){

        Hacha hachaDePiedra = new Hacha(new Piedra());

        BloquePiedra bloquePiedra = new BloquePiedra();

        bloquePiedra.recibirDanio(hachaDePiedra);

        Assert.assertEquals(30, bloquePiedra.getDurabilidad());
    }

    @Test //obligatoria
    public void test05BloqueDePiedraEsGolpeadoConHachaDeMetalYNoSeReduceSuDurabilidad(){

        Hacha hachaDeMetal = new Hacha(new Metal());

        BloquePiedra bloquePiedra = new BloquePiedra();

        bloquePiedra.recibirDanio(hachaDeMetal);

        Assert.assertEquals(30, bloquePiedra.getDurabilidad());
    }

    @Test //obligatoria
    public void test06BloqueDePiedraEsGolpeadoConPicoDeMaderaYSeVerificaQueSeReduceSuDurabilidad(){
        Madera madera = new Madera();
        Pico picoDeMadera = new Pico(madera);

        BloquePiedra bloquePiedra = new BloquePiedra();

        bloquePiedra.recibirDanio(picoDeMadera);

        Assert.assertEquals(28, bloquePiedra.getDurabilidad());

    }

    @Test //obligatoria
    public void test07BloqueDePiedraEsGolpeadoConPicoDePiedraYSeVerificaQueSeReduceSuDurabilidad(){


        Pico picoDePiedra = new Pico(new Piedra());

        BloquePiedra bloquePiedra = new BloquePiedra();

        bloquePiedra.recibirDanio(picoDePiedra);

        Assert.assertEquals(26, bloquePiedra.getDurabilidad());

    }

    @Test //obligatoria
    public void test08BloqueDePiedraEsGolpeadoConPicoDeMetalYSeVerificaQueSeReduceSuDurabilidad(){


        Pico picoDeMetal = new Pico(new Metal());

        BloquePiedra bloquePiedra = new BloquePiedra();

        bloquePiedra.recibirDanio(picoDeMetal);

        Assert.assertEquals(18, bloquePiedra.getDurabilidad());

    }

    @Test //obligatoria
    public void test09BloqueDePiedraEsGolpeadoConPicoFinoYSeVerificaQueNoSeReduceSuDurabilidad(){

        PicoFino picoFino = new PicoFino();

        BloquePiedra bloquePiedra = new BloquePiedra();

        bloquePiedra.recibirDanio(picoFino);

        Assert.assertEquals(30, bloquePiedra.getDurabilidad());

    }

    @Test
    public void test10CuandoLaDurabilidadDelBloqueDePiedraLlegaACeroNoSeReduceMas(){

        Pico picoDePiedra = new Pico(new Madera());

        BloquePiedra bloquePiedra = new BloquePiedra();

        //golpea 14 veces hasta casi el limite de durabilidad del bloque
        for(int i = 0; i < 15; i++){

            bloquePiedra.recibirDanio(picoDePiedra);
        }

        thrown.expect(BloqueSeRompioException.class);
        bloquePiedra.recibirDanio(picoDePiedra);
    }
}
