package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;

public class JuegoTest {

    @Test
    public void testAlCrearseUnaInstanciaDeJuegoElMapaPoseeLaCantidadDeFilasCorrectas() {

        Juego juego = new Juego();

        Assert.assertEquals(9, juego.getCantidadFilasMapa());
    }

    @Test
    public void testAlCrearseUnaInstanciaDeJuegoElMapaPoseeLaCantidadDeColumnasCorrectas() {

        Juego juego = new Juego();

        Assert.assertEquals(13, juego.getCantidadColumnasMapa());
    }

    @Test
    public void testAlCrearseUnaInstanciaDeJuegoElJugadorSeIniciaEnLaPosicionCorrecta() {

        Juego juego = new Juego();

        Assert.assertEquals(7, juego.getColumnaJugador());
        Assert.assertEquals(7, juego.getFilaJugador());
    }
/*
    @Test
    public void testAlCrearseUnaInstanciaDeJuegoLosBloquesSeInicializanEnLaPosicionCorrecta(){

        Juego juego = new Juego();


        mapa.colocar(new BloqueMetal(),1,1);
        mapa.colocar(new BloqueMetal(),1,2);
        mapa.colocar(new BloqueMetal(),2,1);
        mapa.colocar(new BloqueMetal(),2,2);

        mapa.colocar(new BloqueMadera(),4,1);
        mapa.colocar(new BloqueMadera(),4,2);
        mapa.colocar(new BloqueMadera(),4,3);
        mapa.colocar(new BloqueMadera(),4,4);
        mapa.colocar(new BloqueMadera(),5,1);
        mapa.colocar(new BloqueMadera(),5,2);
        mapa.colocar(new BloqueMadera(),5,3);
        mapa.colocar(new BloqueMadera(),5,4);
        mapa.colocar(new BloqueMadera(),6,1);
        mapa.colocar(new BloqueMadera(),6,2);
        mapa.colocar(new BloqueMadera(),6,3);
        mapa.colocar(new BloqueMadera(),6,4);
        mapa.colocar(new BloqueMadera(),7,1);
        mapa.colocar(new BloqueMadera(),7,2);
        mapa.colocar(new BloqueMadera(),7,3);
        mapa.colocar(new BloqueMadera(),7,4);

        mapa.colocar(new BloquePiedra(),4,9);
        mapa.colocar(new BloquePiedra(),4,10);
        mapa.colocar(new BloquePiedra(),5,9);
        mapa.colocar(new BloquePiedra(),5,10);

    }
*/



}
