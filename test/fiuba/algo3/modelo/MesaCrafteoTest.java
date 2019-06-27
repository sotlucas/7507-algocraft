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

    @Test
    public void testSeDesplieganMaterialesEnElTableroYLaMesaDevuelveLaClaveCorrectaCorrespondiente(){

        MesaCrafteo mesaCrafteo = new MesaCrafteo();

        mesaCrafteo.colocar(new Madera(), 0);
        mesaCrafteo.colocar(new Madera(), 1);
        mesaCrafteo.colocar(new Madera(), 2);
        mesaCrafteo.colocar(null, 3);
        mesaCrafteo.colocar(new Madera(), 4);
        mesaCrafteo.colocar(null, 5);
        mesaCrafteo.colocar(null, 6);
        mesaCrafteo.colocar(new Madera(), 7);
        mesaCrafteo.colocar(null, 8);

        String receta = mesaCrafteo.getRecetaParaConstruir();

        Assert.assertEquals("mmm-m--m-", receta);

    }

    @Test
    public void testSeColocaMaderaEnLaPrimeraPosicionYLaRecetaEsCorrecta(){
        MesaCrafteo mesaCrafteo = new MesaCrafteo();
        Material madera = new Madera();

        mesaCrafteo.colocar(madera,0);
        String receta = mesaCrafteo.getRecetaParaConstruir();

        Assert.assertEquals("m--------", receta);
    }


    @Test
    public void testColocoMaderasEnSuPosicionYLaMesaDeCrafteoDevuelveUnHachaDeMadera(){
        MesaCrafteo mesaCrafteo = new MesaCrafteo();
        Material madera = new Madera();

        mesaCrafteo.colocar(madera,0);
        mesaCrafteo.colocar(madera,1);
        mesaCrafteo.colocar(madera,3);
        mesaCrafteo.colocar(madera,4);
        mesaCrafteo.colocar(madera,7);

        Herramienta herramienta = mesaCrafteo.construir();
        Assert.assertEquals(herramienta.getClass(), new Hacha(new Madera()).getClass());
        Assert.assertEquals(herramienta.getMaterial().getClass(), new Madera().getClass());
    }


    @Test
    public void testColocoMaderaYPiedraEnSuPosicionYLaMesaDeCrafteoDevuelveUnHachaDePiedra(){
        MesaCrafteo mesaCrafteo = new MesaCrafteo();
        Material madera = new Madera();
        Material piedra = new Piedra();

        mesaCrafteo.colocar(piedra,0);
        mesaCrafteo.colocar(piedra,1);
        mesaCrafteo.colocar(piedra,3);
        mesaCrafteo.colocar(madera,4);
        mesaCrafteo.colocar(madera,7);

        Herramienta herramienta = mesaCrafteo.construir();
        Assert.assertEquals(herramienta.getClass(), new Hacha(new Piedra()).getClass());
        Assert.assertEquals(herramienta.getMaterial().getClass(), new Piedra().getClass());
    }

    @Test
    public void testColocoMaderaYMetalEnSuPosicionYLaMesaDeCrafteoDevuelveUnHachaDeMetal(){
        MesaCrafteo mesaCrafteo = new MesaCrafteo();
        Material madera = new Madera();
        Material metal = new Metal();

        mesaCrafteo.colocar(metal,0);
        mesaCrafteo.colocar(metal,1);
        mesaCrafteo.colocar(metal,3);
        mesaCrafteo.colocar(madera,4);
        mesaCrafteo.colocar(madera,7);

        Herramienta herramienta = mesaCrafteo.construir();
        Assert.assertEquals(herramienta.getClass(), new Hacha(new Piedra()).getClass());
        Assert.assertEquals(herramienta.getMaterial().getClass(), new Metal().getClass());
    }

    @Test
    public void testColocoMaderasEnSuPosicionYLaMesaDeCrafteoDevuelveUnPicoDeMadera(){
        MesaCrafteo mesaCrafteo = new MesaCrafteo();
        Material madera = new Madera();

        mesaCrafteo.colocar(madera,0);
        mesaCrafteo.colocar(madera,1);
        mesaCrafteo.colocar(madera,2);
        mesaCrafteo.colocar(madera,4);
        mesaCrafteo.colocar(madera,7);

        Herramienta herramienta = mesaCrafteo.construir();
        Assert.assertEquals(herramienta.getClass(), new Pico(new Madera()).getClass());
        Assert.assertEquals(herramienta.getMaterial().getClass(), new Madera().getClass());
    }

    @Test
    public void testColocoMaderaYPiedraEnSuPosicionYLaMesaDeCrafteoDevuelveUnPicoDePiedra(){
        MesaCrafteo mesaCrafteo = new MesaCrafteo();
        Material madera = new Madera();
        Material piedra = new Piedra();

        mesaCrafteo.colocar(piedra,0);
        mesaCrafteo.colocar(piedra,1);
        mesaCrafteo.colocar(piedra,2);
        mesaCrafteo.colocar(madera,4);
        mesaCrafteo.colocar(madera,7);

        Herramienta herramienta = mesaCrafteo.construir();
        Assert.assertEquals(herramienta.getClass(), new Pico(new Piedra()).getClass());
        Assert.assertEquals(herramienta.getMaterial().getClass(), new Piedra().getClass());
    }

    @Test
    public void testColocoMaderaYMetalEnSuPosicionYLaMesaDeCrafteoDevuelveUnPicoDeMetal(){
        MesaCrafteo mesaCrafteo = new MesaCrafteo();
        Material madera = new Madera();
        Material metal = new Metal();

        mesaCrafteo.colocar(metal,0);
        mesaCrafteo.colocar(metal,1);
        mesaCrafteo.colocar(metal,2);
        mesaCrafteo.colocar(madera,4);
        mesaCrafteo.colocar(madera,7);

        Herramienta herramienta = mesaCrafteo.construir();
        Assert.assertEquals(herramienta.getClass(), new Pico(new Piedra()).getClass());
        Assert.assertEquals(herramienta.getMaterial().getClass(), new Metal().getClass());
    }


    @Test
    public void testColocoMaderaMetalYPiedraEnSuPosicionYLaMesaDeCrafteoDevuelveUnPicoFino(){
        MesaCrafteo mesaCrafteo = new MesaCrafteo();
        Material madera = new Madera();
        Material metal = new Metal();
        Material piedra = new Piedra();

        mesaCrafteo.colocar(metal,0);
        mesaCrafteo.colocar(metal,1);
        mesaCrafteo.colocar(metal,2);
        mesaCrafteo.colocar(piedra,3);
        mesaCrafteo.colocar(madera,4);
        mesaCrafteo.colocar(madera,7);

        Herramienta herramienta = mesaCrafteo.construir();
        Assert.assertEquals(herramienta.getClass(), new PicoFino().getClass());
    }

    @Test
    public void testIntentoCraftearUnPicoFinoConPiedraMalUbicadaYLanzaRecetaNoExisteExcepction(){
        MesaCrafteo mesaCrafteo = new MesaCrafteo();
        Material madera = new Madera();
        Material metal = new Metal();
        Material piedra = new Piedra();

        mesaCrafteo.colocar(metal,0);
        mesaCrafteo.colocar(metal,1);
        mesaCrafteo.colocar(metal,2);
        mesaCrafteo.colocar(metal,8);
        mesaCrafteo.colocar(madera,4);
        mesaCrafteo.colocar(madera,7);

        thrown.expect(RecetaNoExisteException.class);
        mesaCrafteo.construir();
    }
}
