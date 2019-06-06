package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;

public class IntegracionTests {

    @Test
    public void test02BloqueDeMaderaEsImpactadoConHachasDeDistintosMaterialesYSeReduceSuDurabilidadDependiendoDeLaFuerzaDelHacha(){

        Hacha hachaDeMadera = new Hacha(new Madera());
        Hacha hachaDeMetal = new Hacha(new Metal());
        Hacha hachaDePiedra = new Hacha(new Piedra());

        BloqueMadera bloqueMadera = new BloqueMadera();
        int durabilidadInicialBloque = bloqueMadera.getDurabilidad();

        hachaDePiedra.usarEn(bloqueMadera);
        Assert.assertEquals(durabilidadInicialBloque - 5, bloqueMadera.getDurabilidad());

        hachaDeMadera.usarEn(bloqueMadera);
        Assert.assertEquals(durabilidadInicialBloque - 7, bloqueMadera.getDurabilidad());

        hachaDeMetal.usarEn(bloqueMadera);
        //no puede reducirse mas que 10 unidades porque alcanza el cero
        Assert.assertEquals(durabilidadInicialBloque - 10, bloqueMadera.getDurabilidad());
    }

    @Test
    public void test03BloqueDePiedraEsImpactadoConHachasDeDistintosMaterialesYNoSeReduceSuDurabilidad(){

        Hacha hachaDeMadera = new Hacha(new Madera());
        Hacha hachaDeMetal = new Hacha(new Metal());
        Hacha hachaDePiedra = new Hacha(new Piedra());

        BloquePiedra bloquePiedra = new BloquePiedra();
        int durabilidadInicialBloque = bloquePiedra.getDurabilidad();

        hachaDePiedra.usarEn(bloquePiedra);
        Assert.assertEquals(durabilidadInicialBloque, bloquePiedra.getDurabilidad());

        hachaDeMadera.usarEn(bloquePiedra);
        Assert.assertEquals(durabilidadInicialBloque, bloquePiedra.getDurabilidad());

        hachaDeMetal.usarEn(bloquePiedra);
        Assert.assertEquals(durabilidadInicialBloque, bloquePiedra.getDurabilidad());
    }

    @Test
    public void test04BloqueDeMetalEsImpactadoConHachasDeDistintosMaterialesYNoSeReduceSuDurabilidad(){

        Hacha hachaDeMadera = new Hacha(new Madera());
        Hacha hachaDeMetal = new Hacha(new Metal());
        Hacha hachaDePiedra = new Hacha(new Piedra());

        BloqueMetal bloqueMetal = new BloqueMetal();
        int durabilidadInicialBloque = bloqueMetal.getDurabilidad();

        hachaDePiedra.usarEn(bloqueMetal);
        Assert.assertEquals(durabilidadInicialBloque, bloqueMetal.getDurabilidad());

        hachaDeMadera.usarEn(bloqueMetal);
        Assert.assertEquals(durabilidadInicialBloque, bloqueMetal.getDurabilidad());

        hachaDeMetal.usarEn(bloqueMetal);
        Assert.assertEquals(durabilidadInicialBloque, bloqueMetal.getDurabilidad());
    }
}
