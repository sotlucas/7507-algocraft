package fiuba.algo3.modelo;

import org.junit.Test;
import org.junit.Assert;

public class InventarioTest {

    @Test
    public void testAgregoHerramientaEnInventarioYComprueboQueSeGuarde() {
        Inventario inventario = new Inventario();
        Herramienta pico = new Pico(new Madera());

        inventario.agregarHerramienta(pico);

        Assert.assertTrue(inventario.contieneHerramienta(pico));
    }

    @Test
    public void testAlDescartarseUnaHerramientaDelInventario(){

        Hacha hachaMadera = new Hacha(new Madera());
        Inventario inventario = new Inventario();
        inventario.agregarHerramienta(hachaMadera);

        Assert.assertTrue(inventario.contieneHerramienta(hachaMadera));

        inventario.desecharHerramientaRota();

        Assert.assertFalse(inventario.contieneHerramienta(hachaMadera));
    }
}
