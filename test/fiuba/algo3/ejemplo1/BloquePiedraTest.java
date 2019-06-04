package fiuba.algo3.ejemplo1;

import org.junit.Assert;
import org.junit.Test;


public class BloquePiedraTest {

    @Test
    public void bloqueDePiedraEsGolpeadoConPicoDeMaderaYSeReduceSegunLaFuerzaDelPico(){
        Madera madera = new Madera();
        Pico picoDeMadera = new Pico(madera);

        BloquePiedra bloque = new BloquePiedra();

        Assert.assertEquals(30, bloque.getDurabilidad());

        bloque.recibirDanio(picoDeMadera);

        Assert.assertEquals(28, bloque.getDurabilidad());
    }

    @Test //obligatoria
    public void piedraSeGolpeaConUnHachaYNoSeReduceSuDurabilidad() {
        Madera madera = new Madera();
        Hacha hachaDeMadera = new Hacha(madera);

        BloquePiedra bloque = new BloquePiedra();

        Assert.assertEquals(30, bloque.getDurabilidad());

        bloque.recibirDanio(hachaDeMadera);

        Assert.assertEquals(30, bloque.getDurabilidad());
    }

    @Test
    public void bloqueDePiedraSeInicializaConDurabilidad30(){
        BloquePiedra bloque = new BloquePiedra();
        Assert.assertEquals(30, bloque.getDurabilidad());
    }
}
