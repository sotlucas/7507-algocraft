package fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class PicoFinoTest {


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


    //CORREGIR ESTA PRUEBA
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
