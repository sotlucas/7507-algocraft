package fiuba.algo3.ejemplo1;

import org.junit.Assert;
import org.junit.Test;


public class BloquePiedraTest {

    /*
    @Test //obligatoria
    public void bloqueDePiedraEsGolpeadoConHachasDeDistintosMaterialesYSeVerificaQueNoSeReduceSuDurabilidad(){

    }
     */

    @Test
    public void bloqueDePiedraSeInicializaConDurabilidad30(){
        Piedra bloque = new Piedra();
        Assert.assertEquals(30, bloque.getDurabilidad());
    }
}
