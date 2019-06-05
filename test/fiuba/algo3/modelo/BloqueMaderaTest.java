package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;


public class BloqueMaderaTest {

    @Test //obligatoria
    public void bloqueDeMaderaEsGolpeadoConHachaDeMaderaYSeVerificaQueSeReduceSuDurabilidad(){
        Madera madera = new Madera();
        Hacha hachaDeMadera = new Hacha(madera);

        BloqueMadera bloque = new BloqueMadera();

        bloque.recibirDanio(hachaDeMadera);

        Assert.assertEquals(8, bloque.getDurabilidad());
    }

    @Test //obligatoria
    public void bloqueDeMaderaEsGolpeadoConPicoDeMaderaYSeVerificaQueNoSeReduceSuDurabilidad(){
        Madera madera = new Madera();
        Pico picoDeMadera = new Pico(madera);

        BloqueMadera bloque = new BloqueMadera();

        bloque.recibirDanio(picoDeMadera);

        Assert.assertEquals(10, bloque.getDurabilidad());

    }

    //falta agregar la de que lo golpea un pico fino
}
