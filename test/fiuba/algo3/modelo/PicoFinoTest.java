package fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PicoFinoTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

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

/*    @Test
    public void test05CuandoLaDurabilidadDelPicoFinoLlegaACeroNoSeReduceMas(){

        PicoFino picoFino = new PicoFino();
        BloqueDiamante bloqueDiamante1 = new BloqueDiamante();
        BloqueDiamante bloqueDiamante2 = new BloqueDiamante();
        BloqueDiamante bloqueDiamante3 = new BloqueDiamante();
        BloqueDiamante bloqueDiamante4 = new BloqueDiamante();
        BloqueDiamante bloqueDiamante5 = new BloqueDiamante();
        BloqueDiamante bloqueDiamante6 = new BloqueDiamante();
        BloqueDiamante bloqueDiamante7 = new BloqueDiamante();
        BloqueDiamante bloqueDiamante8 = new BloqueDiamante();
        BloqueDiamante bloqueDiamante9 = new BloqueDiamante();
        BloqueDiamante bloqueDiamante10 = new BloqueDiamante();
        BloqueDiamante bloqueDiamante11 = new BloqueDiamante();
        BloqueDiamante bloqueDiamante12 = new BloqueDiamante();
        BloqueDiamante bloqueDiamante13 = new BloqueDiamante();
        BloqueDiamante bloqueDiamante14 = new BloqueDiamante();
        BloqueDiamante bloqueDiamante15 = new BloqueDiamante();
        BloqueDiamante bloqueDiamante16 = new BloqueDiamante();
        BloqueDiamante bloqueDiamante17 = new BloqueDiamante();

        for (int i = 0; i < 3; i++) {
            picoFino.usarEn(bloqueDiamante1);
        }

        for (int i = 0; i < 3; i++) {
            picoFino.usarEn(bloqueDiamante2);
        }

        for (int i = 0; i < 3; i++) {
            picoFino.usarEn(bloqueDiamante3);
        }

        for (int i = 0; i < 3; i++) {
            picoFino.usarEn(bloqueDiamante4);
        }

        for (int i = 0; i < 3; i++) {
            picoFino.usarEn(bloqueDiamante5);
        }

        for (int i = 0; i < 3; i++) {
            picoFino.usarEn(bloqueDiamante6);
        }

        for (int i = 0; i < 3; i++) {
            picoFino.usarEn(bloqueDiamante7);
        }

        for (int i = 0; i < 3; i++) {
            picoFino.usarEn(bloqueDiamante8);
        }

        for (int i = 0; i < 3; i++) {
            picoFino.usarEn(bloqueDiamante9);
        }

        for (int i = 0; i < 3; i++) {
            picoFino.usarEn(bloqueDiamante10);
        }

        for (int i = 0; i < 3; i++) {
            picoFino.usarEn(bloqueDiamante11);
        }

        for (int i = 0; i < 3; i++) {
            picoFino.usarEn(bloqueDiamante12);
        }

        for (int i = 0; i < 3; i++) {
            picoFino.usarEn(bloqueDiamante13);
        }

        for (int i = 0; i < 3; i++) {
            picoFino.usarEn(bloqueDiamante14);
        }

        for (int i = 0; i < 3; i++) {
            picoFino.usarEn(bloqueDiamante15);
        }

        for (int i = 0; i < 3; i++) {
            picoFino.usarEn(bloqueDiamante16);
        }

        Assert.assertEquals(1, picoFino.getDurabilidad(), 0.1);
        picoFino.usarEn(bloqueDiamante17);
        thrown.expect(HerramientaSeRompioException.class);
        picoFino.usarEn(bloqueDiamante17);

    }

 */

}
