package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IntegracionTests {

    @Test
    public void testSeVerificaLaCorrectaInicializacionDelJugadorEnElMapa() {

        Juego juego = new Juego();

        Assert.assertEquals(7, juego.getColumnaJugador());
        Assert.assertEquals(7, juego.getFilaJugador());
    }

    @Test
    public void testSeVerificaQueElJugadorPuedeMoversePorCasillasVacias() {

        Juego juego = new Juego();
        Direccion direccion = new HaciaIzquierda();
        juego.avanzarJugador(direccion);
        juego.avanzarJugador(direccion);
        juego.avanzarJugador(new HaciaArriba());
        juego.avanzarJugador(new HaciaDerecha());
        juego.avanzarJugador(new HaciaAbajo());
        juego.avanzarJugador(new HaciaIzquierda());
    }

    @Test
    public void testSeVerificaQueSeIniciaElJuegoConElTerrenoInicializado(){


    }








    // -------------------------- PRUEBAS INTEGRACION PRIMERA ENTREGA: -------------------------------------//
    /*
    @Test
    public void test01SeCreanDiversasHerramientasYSeUtilizanEnTodosLosTiposDeBloques(){

        Hacha hachaDeMadera1 = new Hacha(new Madera());// durabilidad: 100
        Hacha hachaDePiedra1 = new Hacha(new Piedra()); // durabilidad: 200
        Hacha hachaDeMetal1 = new Hacha(new Metal()); // durabilidad: 400

        Pico picoMadera1 = new Pico(new Madera()); // durabilidad: 100
        Pico picoPiedra1 = new Pico(new Piedra());// durabilidad: 200
        Pico picoMetal1 = new Pico(new Metal());// durabilidad: 400
        PicoFino picoFino1 = new PicoFino();// durabilidad: 1000

        BloqueMadera bloqueMadera1 = new BloqueMadera();// durabilidad: 10
        BloquePiedra bloquePiedra1 = new BloquePiedra();// durabilidad: 30
        BloqueMetal bloqueMetal1 = new BloqueMetal();// durabilidad: 50
        BloqueDiamante bloqueDiamante1 = new BloqueDiamante();// durabilidad: 100

        //----------- Verificacion del desgaste de las herramientas contra los bloques ------------------

        //verificacion picos de distintos materiales se desgastan segun su material al impactar un bloque sin importar el tipo de bloque
        double durabilidadInicialPicoMadera1 = picoMadera1.getDurabilidad();
        picoMadera1.usarEn(bloqueDiamante1);
        Assert.assertEquals(durabilidadInicialPicoMadera1 - 2, picoMadera1.getDurabilidad(), 0);
        double durabilidadInicialPicoPiedra1 = picoPiedra1.getDurabilidad();
        picoPiedra1.usarEn(bloqueDiamante1);
        Assert.assertEquals(durabilidadInicialPicoPiedra1 - 2.6, picoPiedra1.getDurabilidad(), 0.1);
        double durabilidadInicialPicoMetal1 = picoMetal1.getDurabilidad();
        picoMetal1.usarEn(bloqueDiamante1);
        Assert.assertEquals(durabilidadInicialPicoMetal1 - 40, picoMetal1.getDurabilidad(), 0);

        //verificacion hachas de distintos materiales se desgastan segun su material al impactar un bloque sin importar el tipo de bloque
        double durabilidadInicialHachaMadera1 = hachaDeMadera1.getDurabilidad();
        hachaDeMadera1.usarEn(bloqueDiamante1);
        Assert.assertEquals(durabilidadInicialHachaMadera1 - 2, hachaDeMadera1.getDurabilidad(), 0);
        double durabilidadInicialHachaPiedra1 = hachaDePiedra1.getDurabilidad();
        hachaDePiedra1.usarEn(bloqueDiamante1);
        Assert.assertEquals(durabilidadInicialHachaPiedra1 - 5, hachaDePiedra1.getDurabilidad(), 0.1);
        double durabilidadInicialHachaMetal1 = hachaDeMetal1.getDurabilidad();
        hachaDeMetal1.usarEn(bloqueDiamante1);
        Assert.assertEquals(durabilidadInicialHachaMetal1 - 5, hachaDeMetal1.getDurabilidad(), 0);

        //verificacion pico fino solo se desgasta al impactar contra bloque de diamante
        double durabilidadInicialPicoFino1 = picoFino1.getDurabilidad();
        picoFino1.usarEn(bloqueDiamante1);
        Assert.assertEquals(durabilidadInicialPicoFino1 - 100, picoFino1.getDurabilidad(), 0);
        picoFino1.usarEn(bloqueMadera1);
        Assert.assertEquals(durabilidadInicialPicoFino1 - 100, picoFino1.getDurabilidad(), 0);
        picoFino1.usarEn(bloquePiedra1);
        Assert.assertEquals(durabilidadInicialPicoFino1 - 100, picoFino1.getDurabilidad(), 0);
        picoFino1.usarEn(bloqueMetal1);
        Assert.assertEquals(durabilidadInicialPicoFino1 - 100, picoFino1.getDurabilidad(), 0);
        picoFino1.usarEn(bloqueDiamante1);
        Assert.assertEquals(durabilidadInicialPicoFino1 - 190, picoFino1.getDurabilidad(), 0);

        //bloque de madera se desgasta solo con las hachas
        double durabilidadInicialBloqueMadera1 = bloqueMadera1.getDurabilidad();
        picoMadera1.usarEn(bloqueMadera1);
        picoPiedra1.usarEn(bloqueMadera1);
        picoMetal1.usarEn(bloqueMadera1);
        picoFino1.usarEn(bloqueMadera1);
        Assert.assertEquals(durabilidadInicialBloqueMadera1, bloqueMadera1.getDurabilidad(),0);

        hachaDeMadera1.usarEn(bloqueMadera1);
        Assert.assertEquals(durabilidadInicialBloqueMadera1 - 2, bloqueMadera1.getDurabilidad(), 0);
        hachaDePiedra1.usarEn(bloqueMadera1);
        Assert.assertEquals(durabilidadInicialBloqueMadera1 - 7, bloqueMadera1.getDurabilidad(), 0);
        hachaDeMetal1.usarEn(bloqueMadera1);
        Assert.assertEquals(durabilidadInicialBloqueMadera1 - 10, bloqueMadera1.getDurabilidad(), 0);

        //bloque de piedra se desgasta solo con los picos salvo el pico fino
        double durabilidadInicialBloquePiedra1 = bloquePiedra1.getDurabilidad();
        hachaDeMadera1.usarEn(bloquePiedra1);
        hachaDePiedra1.usarEn(bloquePiedra1);
        hachaDeMetal1.usarEn(bloquePiedra1);
        picoFino1.usarEn(bloquePiedra1);
        Assert.assertEquals(durabilidadInicialBloquePiedra1, bloquePiedra1.getDurabilidad(),0);

        picoMadera1.usarEn(bloquePiedra1);
        Assert.assertEquals(durabilidadInicialBloquePiedra1 - 2, bloquePiedra1.getDurabilidad(), 0);
        picoPiedra1.usarEn(bloquePiedra1);
        Assert.assertEquals(durabilidadInicialBloquePiedra1 - 6, bloquePiedra1.getDurabilidad(), 0);
        picoMetal1.usarEn(bloquePiedra1);
        Assert.assertEquals(durabilidadInicialBloquePiedra1 - 18, bloquePiedra1.getDurabilidad(), 0);

        //bloque de metal se desgaste solo con pico de piedra
        double durabilidadInicialBloqueMetal1 = bloqueMetal1.getDurabilidad();
        hachaDeMadera1.usarEn(bloqueMetal1);
        hachaDePiedra1.usarEn(bloqueMetal1);
        hachaDeMetal1.usarEn(bloqueMetal1);
        picoFino1.usarEn(bloqueMetal1);
        picoMadera1.usarEn(bloqueMetal1);
        picoMetal1.usarEn(bloqueMetal1);
        Assert.assertEquals(durabilidadInicialBloqueMetal1, bloqueMetal1.getDurabilidad(),0);

        picoPiedra1.usarEn(bloqueMetal1);
        Assert.assertEquals(durabilidadInicialBloqueMetal1 - 4, bloqueMetal1.getDurabilidad(), 0);

    }*/

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test02BloqueDeMaderaEsImpactadoConHachasDeDistintosMaterialesYSeReduceSuDurabilidadDependiendoDeLaFuerzaDelHacha(){

        Hacha hachaDeMadera = new Hacha(new Madera());
        Hacha hachaDeMetal = new Hacha(new Metal());
        Hacha hachaDePiedra = new Hacha(new Piedra());

        BloqueMadera bloqueMadera = new BloqueMadera();
        int durabilidadInicialBloque = bloqueMadera.getDurabilidad();

        hachaDePiedra.usarEn(bloqueMadera);
        Assert.assertEquals(durabilidadInicialBloque - 5, bloqueMadera.getDurabilidad());

        hachaDeMadera.usarEn(bloqueMadera);
        Assert.assertEquals(durabilidadInicialBloque - 7, bloqueMadera.getDurabilidad());

        thrown.expect(BloqueSeRompioException.class);
        hachaDeMetal.usarEn(bloqueMadera);
    }

    @Test
    public void test03BloqueDeMaderaEsImpactadoConTodosLosTiposDePicosYNoSeReduceSuDurabilidad(){

        Pico picoMadera = new Pico(new Madera());
        Pico picoPiedra = new Pico(new Piedra());
        Pico picoMetal = new Pico(new Metal());
        PicoFino picoFino = new PicoFino();

        BloqueMadera bloqueMadera = new BloqueMadera();
        int durabilidadInicialBloque = bloqueMadera.getDurabilidad();

        picoMadera.usarEn(bloqueMadera);
        Assert.assertEquals(durabilidadInicialBloque, bloqueMadera.getDurabilidad());

        picoPiedra.usarEn(bloqueMadera);
        Assert.assertEquals(durabilidadInicialBloque, bloqueMadera.getDurabilidad());

        picoMetal.usarEn(bloqueMadera);
        Assert.assertEquals(durabilidadInicialBloque, bloqueMadera.getDurabilidad());

        picoFino.usarEn(bloqueMadera);
        Assert.assertEquals(durabilidadInicialBloque, bloqueMadera.getDurabilidad());
    }

    @Test
    public void test04BloqueDePiedraEsImpactadoConPicosDeDistintosMaterialesYSeReduceLaDurabilidadDependiendoDelMaterialDelPico(){

        Pico picoMadera = new Pico(new Madera());
        Pico picoPiedra = new Pico(new Piedra());
        Pico picoMetal = new Pico(new Metal());
        PicoFino picoFino = new PicoFino();

        BloquePiedra bloquePiedra = new BloquePiedra();
        int durabilidadInicialBloque = bloquePiedra.getDurabilidad();

        picoMadera.usarEn(bloquePiedra);
        Assert.assertEquals(durabilidadInicialBloque-2, bloquePiedra.getDurabilidad());

        picoPiedra.usarEn(bloquePiedra);
        Assert.assertEquals(durabilidadInicialBloque-6, bloquePiedra.getDurabilidad());

        picoMetal.usarEn(bloquePiedra);
        Assert.assertEquals(durabilidadInicialBloque-18, bloquePiedra.getDurabilidad());

        picoFino.usarEn(bloquePiedra);
        Assert.assertEquals(durabilidadInicialBloque-18, bloquePiedra.getDurabilidad());

    }

    @Test
    public void test05BloqueDePiedraEsImpactadoConTodosLosTiposDeHachasYNoSeReduceSuDurabilidad(){

        Hacha hachaDeMadera = new Hacha(new Madera());
        Hacha hachaDeMetal = new Hacha(new Metal());
        Hacha hachaDePiedra = new Hacha(new Piedra());

        BloquePiedra bloquePiedra = new BloquePiedra();
        int durabilidadInicialBloque = bloquePiedra.getDurabilidad();

        hachaDePiedra.usarEn(bloquePiedra);
        Assert.assertEquals(durabilidadInicialBloque, bloquePiedra.getDurabilidad());

        hachaDeMadera.usarEn(bloquePiedra);
        Assert.assertEquals(durabilidadInicialBloque, bloquePiedra.getDurabilidad());

        hachaDeMetal.usarEn(bloquePiedra);
        Assert.assertEquals(durabilidadInicialBloque, bloquePiedra.getDurabilidad());
    }

    @Test
    public void test06BloqueDeMetalEsImpactadoConHachasDeDistintosMaterialesYNoSeReduceSuDurabilidad(){

        Hacha hachaDeMadera = new Hacha(new Madera());
        Hacha hachaDeMetal = new Hacha(new Metal());
        Hacha hachaDePiedra = new Hacha(new Piedra());

        BloqueMetal bloqueMetal = new BloqueMetal();
        int durabilidadInicialBloque = bloqueMetal.getDurabilidad();

        hachaDePiedra.usarEn(bloqueMetal);
        Assert.assertEquals(durabilidadInicialBloque, bloqueMetal.getDurabilidad());

        hachaDeMadera.usarEn(bloqueMetal);
        Assert.assertEquals(durabilidadInicialBloque, bloqueMetal.getDurabilidad());

        hachaDeMetal.usarEn(bloqueMetal);
        Assert.assertEquals(durabilidadInicialBloque, bloqueMetal.getDurabilidad());
    }

    @Test //obligatoria
    public void test07BloqueDeMetalRecibeGolpesDeTodosLosTiposDePicosYSoloReduceSuDurabilidadAlSerImpactadoConPicoDePiedra() {

        Pico picoMadera = new Pico(new Madera());
        Pico picoPiedra = new Pico(new Piedra());
        Pico picoMetal = new Pico(new Metal());
        PicoFino picoFino = new PicoFino();

        BloqueMetal bloqueMetal = new BloqueMetal();

        picoMadera.usarEn(bloqueMetal);
        picoFino.usarEn(bloqueMetal);
        picoMetal.usarEn(bloqueMetal);

        Assert.assertEquals(50, bloqueMetal.getDurabilidad());

        picoPiedra.usarEn(bloqueMetal);
        Assert.assertEquals(46, bloqueMetal.getDurabilidad());
    }

    @Test
    public void test08BloqueDeDiamanteRecibeGolpesDeTodasLasHerramientasYReduceSuDurabilidadConElImpactoDelPicoFino(){

        Hacha hachaDeMadera = new Hacha(new Madera());
        Hacha hachaDeMetal = new Hacha(new Metal());
        Hacha hachaDePiedra = new Hacha(new Piedra());

        Pico picoMadera = new Pico(new Madera());
        Pico picoPiedra = new Pico(new Piedra());
        Pico picoMetal = new Pico(new Metal());

        PicoFino picoFino = new PicoFino();

        BloqueDiamante bloqueDiamante = new BloqueDiamante();

        int durabilidadInicialBloque = bloqueDiamante.getDurabilidad();

        hachaDeMadera.usarEn(bloqueDiamante);
        hachaDeMetal.usarEn(bloqueDiamante);
        hachaDePiedra.usarEn(bloqueDiamante);
        picoMadera.usarEn(bloqueDiamante);
        picoPiedra.usarEn(bloqueDiamante);
        picoMetal.usarEn(bloqueDiamante);

        Assert.assertEquals(durabilidadInicialBloque, bloqueDiamante.getDurabilidad());

        picoFino.usarEn(bloqueDiamante);
        Assert.assertEquals(durabilidadInicialBloque-20, bloqueDiamante.getDurabilidad());

    }
}
