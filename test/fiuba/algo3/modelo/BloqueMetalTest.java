package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;

public class BloqueMetalTest {

    @Test
    public void bloqueDeMetalEsGolpeadoConPicoDeMaderaYSeVerificaQueNoSeReduceSuDurabilidad(){

        Madera madera = new Madera();
        Pico picoDeMadera = new Pico(madera);

        BloqueMetal bloque = new BloqueMetal();

        bloque.recibirDanio(picoDeMadera);

        Assert.assertEquals(50, bloque.getDurabilidad());
    }

}