package fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class MaterialTest {

    @Test
    public void testMaterialMaderaSeCreaYEsDistintoDeNull() {

        Madera madera = new Madera();
        Assert.assertNotNull(madera);

    }

    @Test
    public void testMaterialMaderaSeInicializaConElIdentificadorCorrecto() {

        Madera madera = new Madera();
        String identificador = madera.getIdentificador();
        Assert.assertEquals("m", identificador);
    }

    @Test
    public void testMaterialPiedraSeCreaYEsDistintoDeNull() {

        Piedra piedra = new Piedra();
        Assert.assertNotNull(piedra);

    }

    @Test
    public void testMaterialPiedraSeInicializaConElIdentificadorCorrecto() {
        Piedra piedra = new Piedra();
        String identificador = piedra.getIdentificador();

        Assert.assertEquals("p", identificador);
    }

    @Test
    public void testMaterialMetalSeCreaYEsDistintoDeNull() {

        Metal metal = new Metal();
        Assert.assertNotNull(metal);

    }

    @Test
    public void testMaterialMetalSeInicializaConElIdentificadorCorrecto() {

        Metal metal = new Metal();
        String identificador = metal.getIdentificador();

        Assert.assertEquals("M", identificador);
    }
}
