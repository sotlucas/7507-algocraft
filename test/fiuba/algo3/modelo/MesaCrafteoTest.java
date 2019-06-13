package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class MesaCrafteoTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testCrearMesaCrafteoDevuelveAlgoDistintoDeNull(){

        MesaCrafteo mesaCrafteo = new MesaCrafteo();
        Assert.assertNotNull(mesaCrafteo);
    }

    @Test
    public void testAlCrearMesaCrafteoSeCreaUnArrayDeNuevePosiciones() {

        MesaCrafteo mesaCrafteo = new MesaCrafteo();


    }

    @Test
    public void testLaRecetaDeUnTableroCreadoPorDefectoEsUnaSucesionDeNueveDashes(){

        MesaCrafteo mesaCrafteo = new MesaCrafteo();
        String receta = mesaCrafteo.getRecetaParaConstruir();

        Assert.assertEquals("---------", receta);
    }


}
