package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personaje;
import org.junit.Assert;
import org.junit.Test;

public class PersonajeTest {

    @Test
    public void testAlCrearPersonajeEsDistintoDeNull(){

        Personaje personaje = new Personaje();
        Assert.assertNotNull(personaje);
    }

    @Test
    public void test(){


    }

}
