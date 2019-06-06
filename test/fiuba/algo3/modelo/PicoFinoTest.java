package fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class PicoFinoTest {

    @Test
    public void test01ElConstructorDePicoFinoDevuelveAlgoDistintoDeNull() {

        PicoFino picoFino = new PicoFino();

        Assert.assertNotNull(picoFino);
    }

    @Test //obligatoria
    public void test01SeCreaPicoFinoConSuDurabilidad1000(){

        PicoFino picoFino = new PicoFino();

        assertEquals(1000, picoFino.getDurabilidad(), 0);

    }

    @Test //obligatoria
    public void test02SeCreaPicoFinoConSuFuerza20(){

        PicoFino picoFino = new PicoFino();

        assertEquals(20, picoFino.getFuerza());

    }

    @Test //obligatoria
    public void test03PicoFinoSeUsaContraBloqueDeDiamanteYSeReduceLaDurabilidadDelPico(){

        PicoFino picoFino = new PicoFino();
        BloqueDiamante bloqueDiamante = new BloqueDiamante();

        picoFino.usarEn(bloqueDiamante);

        Assert.assertEquals(900, picoFino.getDurabilidad(), 0);

    }


    @Test //obligatoria
    public void test04PicoFinoSeUsaContraBloquesDeMetalMaderaYPiedraYNoSeReduceLaDurabilidadDelPico(){

        PicoFino picoFino = new PicoFino();

        BloqueMadera bloqueMadera = new BloqueMadera();
        BloquePiedra bloquePiedra = new BloquePiedra();
        BloqueMetal bloqueMetal = new BloqueMetal();

        picoFino.usarEn(bloqueMadera);
        Assert.assertEquals(1000, picoFino.getDurabilidad(), 0);

        picoFino.usarEn(bloquePiedra);
        Assert.assertEquals(1000, picoFino.getDurabilidad(), 0);

        picoFino.usarEn(bloqueMetal);
        Assert.assertEquals(1000, picoFino.getDurabilidad(), 0);


    }

    @Test
    public void test05CuandoLaDurabilidadDelPicoFinoLlegaACeroNoSeReduceMas(){

        PicoFino picoFino = new PicoFino();

        BloqueDiamante bloqueDiamante = new BloqueDiamante();

        for(int i = 0; i < 66; i++) {
            picoFino.usarEn(bloqueDiamante);
        }

        Assert.assertEquals(0, picoFino.getDurabilidad(), 0);

        picoFino.usarEn(bloqueDiamante);
        Assert.assertEquals(0, picoFino.getDurabilidad(), 0);

    }

}
