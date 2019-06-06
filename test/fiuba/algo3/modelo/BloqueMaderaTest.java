package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;


public class BloqueMaderaTest {

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
    public void bloqueDeMaderaEsGolpeadoConHachaDeMetalYSeVerificaQueSeReduceSuDurabilidad(){

        Hacha hachaDeMetal = new Hacha(new Metal());

        BloqueMadera bloque = new BloqueMadera();

        bloque.recibirDanio(hachaDeMetal);

        Assert.assertEquals(0, bloque.getDurabilidad());
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
        bloqueMadera.recibirDanio(hachaDeMadera);

        Assert.assertEquals(0, bloqueMadera.getDurabilidad());

        bloqueMadera.recibirDanio(hachaDeMadera);
        Assert.assertEquals(0, bloqueMadera.getDurabilidad());

    }

    //falta agregar la de que lo golpea un pico fino
}
