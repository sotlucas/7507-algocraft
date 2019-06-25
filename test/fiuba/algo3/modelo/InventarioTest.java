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
    public void testAlInvocarElMetodoDesecharLaHerramientaSeleccionadaSeRemueveDelInventario(){

        Hacha hachaMadera = new Hacha(new Madera());
        Inventario inventario = new Inventario();
        inventario.agregarHerramienta(hachaMadera);

        Assert.assertTrue(inventario.contieneHerramienta(hachaMadera));

        inventario.desecharHerramientaRota();

        Assert.assertFalse(inventario.contieneHerramienta(hachaMadera));
    }

    @Test
    public void testAlDescartarseUnaHerramientaSeRemueveSoloDichaHerramienta(){

        Hacha hachaMadera = new Hacha(new Madera());
        Pico picoPiedra = new Pico(new Piedra());
        Inventario inventario = new Inventario();
        inventario.agregarHerramienta(hachaMadera);
        inventario.agregarHerramienta(picoPiedra);

        Herramienta herramienta = inventario.seleccionarHerramienta(0);
        inventario.desecharHerramientaRota();

        Assert.assertTrue(inventario.contieneHerramienta(picoPiedra));
    }



}
