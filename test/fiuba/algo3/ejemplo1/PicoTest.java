package fiuba.algo3.ejemplo1;

import org.junit.Assert;
import org.junit.Test;

public class PicoTest {


    @Test //obligatoria
    public void SeCreaPicoDeMaderaConSuDurabilidadYFuerzaCorrespondiente(){

    }

    @Test //obligatoria
    public void SeCreaPicoDeMetalConSuDurabilidadYFuerzaCorrespondiente(){

    }

    @Test
    public void picoDeMaderaSeUsaContraCadaUnoDeLosBloquesYSeReduceSuDurabilidadCorrespondienteAlMaterialDelPico(){

    }

/*
    @Test
    public void SeCreaHachaDeMetalConSuDurabilidadYFuerzaCorrespondiente(){

        Constructor constructor = new Constructor();
        Hacha hachaMetal = constructor.construirHachaDeMetal();

        Assert.assertEquals(10, hachaMetal.getFuerza());
        Assert.assertEquals(400, hachaMetal.getDurabilidad(), 0);
    }

    @Test
    public void hachaDeMaderaSeUsaContraBloqueDeMaderaYSeReduceSuDurabilidadCorrespondienteAlMaterialDelHacha(){

        Constructor constructor = new Constructor();
        Hacha hachaMadera = constructor.construirHachaDeMadera();
        double durabilidadInicialHachaMadera = hachaMadera.getDurabilidad();

        BloqueMadera bloqueMadera = new BloqueMadera();

        hachaMadera.usarEn(bloqueMadera);
        Assert.assertEquals(98, hachaMadera.getDurabilidad(), 0);

    }

    @Test
    public void hachaDeMaderaSeUsaContraBloqueDePiedraYSeReduceSuDurabilidadCorrespondienteAlMaterialDelHacha(){

        Constructor constructor = new Constructor();
        Hacha hachaMadera = constructor.construirHachaDeMadera();

        double durabilidadInicialHachaMadera = hachaMadera.getDurabilidad();

        BloquePiedra bloquePiedra = new BloquePiedra();

        hachaMadera.usarEn(bloquePiedra);
        Assert.assertEquals(98, hachaMadera.getDurabilidad(), 0);

    }
/*
    @Test
    public void hachaDePiedraSeUsaContraBloqueDeMaderaYSeReduceSuDurabilidadCorrespondienteAlMaterialDelHacha(){

        Constructor constructor = new Constructor();
        Hacha hachaPiedra = constructor.construirHachaDePiedra();
        double durabilidadInicialHachaPiedra = hachaPiedra.getDurabilidad();

        BloquePiedra bloquePiedra = new BloquePiedra();

        hachaPiedra.usarEn(bloquePiedra);
        Assert.assertEquals(195, hachaPiedra.getDurabilidad(), 0);

    }






    //hachaSeUsaContraCadaUnoDeLosMaterialesYSeReduceSuDurabilidadCorrespondienteAlMaterialDelHacha
*/
}
