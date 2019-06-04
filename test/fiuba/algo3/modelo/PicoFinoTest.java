package fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PicoFinoTest {


    @Test //obligatoria
    public void seCreaPicoFinoDePiedraConSuDurabilidad1000(){
        Piedra piedra = new Piedra();
        PicoFino picoFinoDePiedra = new PicoFino(piedra);

        assertEquals(1000, picoFinoDePiedra.getDurabilidad());

    }

    @Test //obligatoria
    public void seCreaPicoFinoDePiedraConSuFuerza20(){
        Piedra piedra = new Piedra();
        PicoFino picoFinoDePiedra = new PicoFino(piedra);

        assertEquals(20, picoFinoDePiedra.getFuerza());

    }

    @Test //obligatoria
    public void seCreaPicoFinoDeMetalConSuDurabilidad1000(){
        Metal metal = new Metal();
        PicoFino picoFinoDeMetal = new PicoFino(metal);

        assertEquals(1000, picoFinoDeMetal.getDurabilidad());

    }

    @Test //obligatoria
    public void seCreaPicoFinoDeMetalConSuFuerza20(){
        Metal metal = new Metal();
        PicoFino picoFinoDeMetal = new PicoFino(metal);

        assertEquals(20, picoFinoDeMetal.getFuerza());

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
