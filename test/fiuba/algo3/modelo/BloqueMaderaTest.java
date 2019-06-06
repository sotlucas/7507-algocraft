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

    @Test
    public void CuandoLaDurabilidadDelBloqueDeMaderaLlegaACeroNoSeReduceMas(){

        Madera madera = new Madera();
        Hacha hachaDeMadera = new Hacha(madera);

        BloqueMadera bloqueMadera = new BloqueMadera();

        bloqueMadera.recibirDanio(hachaDeMadera);
        bloqueMadera.recibirDanio(hachaDeMadera);
        bloqueMadera.recibirDanio(hachaDeMadera);
        bloqueMadera.recibirDanio(hachaDeMadera);
        bloqueMadera.recibirDanio(hachaDeMadera);

        Assert.assertEquals(0, bloqueMadera.getDurabilidad());

        bloqueMadera.recibirDanio(hachaDeMadera);
        Assert.assertEquals(0, bloqueMadera.getDurabilidad());

    }

    //falta agregar la de que lo golpea un pico fino
}
