package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;

public class DesgasteNormalTest {

    @Test
    public void test01ElConstructorPorDefectoDeDesgasteDevuelveAlgoDistintoDeNull(){

        //DesgasteNormal tipoDeDesgaste = new DesgasteNormal();
        //Assert.assertNotNull(tipoDeDesgaste);
    }

    @Test
    public void test02AlCrearseDesgasteSinEspecificarFactorLaDurabilidadSeReduceSegunFuerza(){

        int durabilidadInicialHerramienta = 100;
        int fuerzaHerramienta = 2;
        DesgasteNormal tipoDeDesgaste = new DesgasteNormal(durabilidadInicialHerramienta, fuerzaHerramienta);

        Assert.assertEquals(98, tipoDeDesgaste.desgastar(), 0);
    }

    @Test
    public void test03AlCrearseDesgasteConCiertoFactorLaDurabilidadSeReduceSegunLaFuerzaYElFactor(){

        int durabilidadInicialHerramienta = 100;
        int fuerzaHerramienta = 2;
        int factor = 2;
        DesgasteNormal tipoDeDesgaste = new DesgasteNormal(durabilidadInicialHerramienta, fuerzaHerramienta, factor);

        Assert.assertEquals(99, tipoDeDesgaste.desgastar(), 0);
    }

}
