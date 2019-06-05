package fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class PicoFinoTest {


    @Test //obligatoria
    public void seCreaPicoFinoConSuDurabilidad1000(){

        PicoFino picoFino = new PicoFino();

        assertEquals(1000, picoFino.getDurabilidad(), 0);

    }

    @Test //obligatoria
    public void seCreaPicoFinoConSuFuerza20(){

        PicoFino picoFino = new PicoFino();

        assertEquals(20, picoFino.getFuerza());

    }


    @Test //obligatoria
    public void picoFinoSeUsaContraBloqueDeDiamanteYSeReduceLaDurabilidadDelBloque(){

        PicoFino picoFino = new PicoFino();
        BloqueDiamante bloqueDiamante = new BloqueDiamante();

        picoFino.usarEn(bloqueDiamante);

        Assert.assertEquals(900, picoFino.getDurabilidad(), 0);

    }

    @Test //obligatoria
    public void picoFinoSeUsaContraLosBloquesDeOtrosMaterialesYNoSeReducenSusDurabilidades(){

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


}
