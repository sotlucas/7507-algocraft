package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;


public class BloqueMaderaTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01AlCrearseBloqueDeMaderaDevuelveAlgoDistintoDeNull(){

        BloqueMadera bloqueMadera = new BloqueMadera();

        Assert.assertNotNull(bloqueMadera);
    }

    @Test //obligatoria
    public void bloqueDeMaderaEsGolpeadoConHachaDeMaderaYSeVerificaQueSeReduceSuDurabilidad(){
        Madera madera = new Madera();
        Hacha hachaDeMadera = new Hacha(madera);

        BloqueMadera bloque = new BloqueMadera();

        bloque.recibirDanio(hachaDeMadera);

        Assert.assertEquals(8, bloque.getDurabilidad());
    }

    @Test //obligatoria
    public void bloqueDeMaderaEsGolpeadoConHachaDePiedraYSeVerificaQueSeReduceSuDurabilidad(){

        Hacha hachaDePiedra = new Hacha(new Piedra());

        BloqueMadera bloque = new BloqueMadera();

        bloque.recibirDanio(hachaDePiedra);

        Assert.assertEquals(5, bloque.getDurabilidad());
    }

    @Test //obligatoria
    public void bloqueDeMaderaEsGolpeadoConHachaDeMetalYSeVerificaQueSeRompe(){

        Hacha hachaDeMetal = new Hacha(new Metal());

        BloqueMadera bloque = new BloqueMadera();

        thrown.expect(BloqueSeRompioException.class);
        bloque.recibirDanio(hachaDeMetal);
    }

    @Test //obligatoria
    public void bloqueDeMaderaEsGolpeadoConPicoDeMaderaYSeVerificaQueNoSeReduceSuDurabilidad(){
        Madera madera = new Madera();
        Pico picoDeMadera = new Pico(madera);

        BloqueMadera bloque = new BloqueMadera();

        bloque.recibirDanio(picoDeMadera);

        Assert.assertEquals(10, bloque.getDurabilidad());

    }

    @Test //obligatoria
    public void bloqueDeMaderaEsGolpeadoConPicoDePiedraYSeVerificaQueNoSeReduceSuDurabilidad(){


        Pico picoDePiedra = new Pico(new Piedra());

        BloqueMadera bloque = new BloqueMadera();

        bloque.recibirDanio(picoDePiedra);

        Assert.assertEquals(10, bloque.getDurabilidad());

    }

    @Test //obligatoria
    public void bloqueDeMaderaEsGolpeadoConPicoDeMetalYSeVerificaQueNoSeReduceSuDurabilidad(){


        Pico picoDeMetal = new Pico(new Metal());

        BloqueMadera bloque = new BloqueMadera();

        bloque.recibirDanio(picoDeMetal);

        Assert.assertEquals(10, bloque.getDurabilidad());

    }

    @Test //obligatoria
    public void bloqueDeMaderaEsGolpeadoConPicoFinoYSeVerificaQueNoSeReduceSuDurabilidad(){

        PicoFino picoFino = new PicoFino();

        BloqueMadera bloque = new BloqueMadera();

        bloque.recibirDanio(picoFino);

        Assert.assertEquals(10, bloque.getDurabilidad());

    }

    @Test
    public void CuandoLaDurabilidadDelBloqueDeMaderaLlegaACeroNoSeReduceMas(){

        Madera madera = new Madera();
        Hacha hachaDeMadera = new Hacha(madera);

        BloqueMadera bloqueMadera = new BloqueMadera();

        bloqueMadera.recibirDanio(hachaDeMadera);
        bloqueMadera.recibirDanio(hachaDeMadera);
        bloqueMadera.recibirDanio(hachaDeMadera);
        bloqueMadera.recibirDanio(hachaDeMadera);

        thrown.expect(BloqueSeRompioException.class);
        bloqueMadera.recibirDanio(hachaDeMadera);

    }

    //falta agregar la de que lo golpea un pico fino
}
