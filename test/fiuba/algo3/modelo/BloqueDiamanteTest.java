package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;

public class BloqueDiamanteTest {

    @Test //obligatoria
    public void test01BloqueDeDiamanteEsGolpeadoConHachaDeMaderaYSeVerificaQueNoSeReduceSuDurabilidad(){

        Madera madera = new Madera();
        Hacha hachaDeMadera = new Hacha(madera);

        BloqueDiamante bloque = new BloqueDiamante();

        bloque.recibirDanio(hachaDeMadera);

        Assert.assertEquals(100, bloque.getDurabilidad());
    }

    @Test //obligatoria
    public void test02BloqueDeDiamanteEsGolpeadoConPicoDeMaderaYSeVerificaQueNoSeReduceSuDurabilidad(){

        Madera madera = new Madera();
        Pico picoDeMadera = new Pico(madera);

        BloqueDiamante bloque = new BloqueDiamante();

        bloque.recibirDanio(picoDeMadera);

        Assert.assertEquals(100, bloque.getDurabilidad());

    }

    @Test //obligatoria
    public void test03BloqueDeDiamanteEsGolpeadoConPicoFinoYSeVerificaQueSeReduceSuDurabilidad(){

        PicoFino picoFino = new PicoFino();

        BloqueDiamante bloque = new BloqueDiamante();

        bloque.recibirDanio(picoFino);

        Assert.assertEquals(80, bloque.getDurabilidad());

    }

    @Test
    public void test04CuandoLaDurabilidadDelBloqueDeDiamanteLlegaACeroNoSeReduceMas(){

        PicoFino picoFino = new PicoFino();

        BloqueDiamante bloqueDiamante = new BloqueDiamante();

        bloqueDiamante.recibirDanio(picoFino);
        bloqueDiamante.recibirDanio(picoFino);
        bloqueDiamante.recibirDanio(picoFino);
        bloqueDiamante.recibirDanio(picoFino);
        bloqueDiamante.recibirDanio(picoFino);

        Assert.assertEquals(0, bloqueDiamante.getDurabilidad());

        bloqueDiamante.recibirDanio(picoFino);
        Assert.assertEquals(0, bloqueDiamante.getDurabilidad());

    }
}
