package fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PicoFinoTest {


    @Test //obligatoria
    public void seCreaPicoFinoDePiedraConSuDurabilidad1000(){

        PicoFino picoFino = new PicoFino();

        assertEquals(1000, picoFino.getDurabilidad(), 0);

    }

    @Test //obligatoria
    public void seCreaPicoFinoDePiedraConSuFuerza20(){

        PicoFino picoFino = new PicoFino();

        assertEquals(20, picoFino.getFuerza());

    }

    /*
    @Test //obligatoria
    public void picoFinoSeUsaContraBloqueDeDiamanteYSeReduceLaDurabilidadDelBloque(){

    }

    @Test //obligatoria
    public void picoFinoSeUsaContraLosBloquesDeOtrosMaterialesYNoSeReducenSusDurabilidades(){

    }
    */

}
