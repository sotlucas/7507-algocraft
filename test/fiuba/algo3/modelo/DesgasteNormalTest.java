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

    @Test
    public void test04DurabilidadAlLlegarACeroYaNoSeReduceMas(){

        //durabilidad arbitraria solo para pruebas
        double durabilidadInicial = 10;
        int fuerzaHerramienta = 2;

        DesgasteNormal desgaste = new DesgasteNormal(durabilidadInicial, fuerzaHerramienta);

        desgaste.desgastar();
        desgaste.desgastar();
        desgaste.desgastar();
        desgaste.desgastar();

        Assert.assertEquals(0, desgaste.desgastar(), 0);

        //en la siguiente linea se verifica que no baja de cero
        Assert.assertEquals(0, desgaste.desgastar(), 0);

    }
}
