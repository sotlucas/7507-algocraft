package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;

public class DesgasteEspecialTest {

    @Test
    public void test01AlInstanciarseDesgasteEspecialDevuelveAlgoDistintoDeNull(){

        DesgasteEspecial desgasteEspecial = new DesgasteEspecial();

        Assert.assertNotNull(desgasteEspecial);
    }

    @Test
    public void test02DesgasteEspecialReduceDurabilidadEnLaFormaCorrectaSegunElFactorYLaDurabilidadEstablecidasPorDefecto(){

        DesgasteEspecial desgasteEspecial = new DesgasteEspecial();

        Assert.assertEquals(900, desgasteEspecial.desgastar(), 0);
        Assert.assertEquals(810, desgasteEspecial.desgastar(), 0);
        Assert.assertEquals(729, desgasteEspecial.desgastar(), 0);
        Assert.assertEquals(656.1, desgasteEspecial.desgastar(), 0.1);

    }

    @Test
    public void test03DurabilidadAlLlegarACeroYaNoSeReduceMas(){

        DesgasteEspecial desgaste = new DesgasteEspecial();

        for(int i = 0; i < 65; i++) {
            desgaste.desgastar();
        }
        //debe colocarsele un delta ajustado pues nunca alcanza el cero realmente
        Assert.assertEquals(0, desgaste.desgastar(), 0);

    }

}
