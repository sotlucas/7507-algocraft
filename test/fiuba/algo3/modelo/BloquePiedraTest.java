package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;


public class BloquePiedraTest {

    /*
    @Test //obligatoria
    public void bloqueDePiedraEsGolpeadoConPicoDeMaderaYSeReduceSegunLaFuerzaDelPico(){
        Madera madera = new Madera();
        Pico picoDeMadera = new Pico(madera);

        BloquePiedra bloque = new BloquePiedra();

        Assert.assertEquals(30, bloque.getDurabilidad());

        bloque.recibirDanio(picoDeMadera);

        Assert.assertEquals(28, bloque.getDurabilidad());
    }
     */

    @Test
    public void bloqueDePiedraSeInicializaConDurabilidad30(){
        BloquePiedra bloque = new BloquePiedra();
        Assert.assertEquals(30, bloque.getDurabilidad());
    }
}
