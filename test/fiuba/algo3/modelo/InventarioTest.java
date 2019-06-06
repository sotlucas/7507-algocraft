package fiuba.algo3.modelo;

import org.junit.Test;
import org.junit.Assert;

public class InventarioTest {

    @Test
    public void test01AgregoHerramientaEnInventarioYComprueboQueSeGuarde() {
        Inventario inventario = new Inventario();
        Herramienta pico = new Pico(new Madera());

        inventario.agregarHerramienta(pico);

        Assert.assertTrue(inventario.contiene(pico));
    }
}
