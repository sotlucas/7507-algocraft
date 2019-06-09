package fiuba.algo3.modelo;

import fiuba.algo3.modelo.BloqueMadera;
import fiuba.algo3.modelo.Casilla;
import fiuba.algo3.modelo.CasilleroEstaOcupadoException;
import fiuba.algo3.modelo.Personaje;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CasillaTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01AlCrearCasilleroEsDistintoDeNull(){

        Casilla casilla = new Casilla();
        Assert.assertNotNull(casilla);
    }

    @Test
    public void test02AlCrearseCasilleroSinEspecificarNadaSeCreaConEstadoVacio(){

        Casilla casilla = new Casilla();
        Assert.assertTrue(casilla.estaVacia());
    }

    @Test
    public void test03AlCrearseCasilleroConUnBloqueDeMaterialElEstadoEsOcupado(){

        BloqueMadera bloqueMadera = new BloqueMadera();
        Casilla casilla = new Casilla(bloqueMadera);
        Assert.assertFalse(casilla.estaVacia());
    }

    @Test
    public void test04AlCrearseCasilleroConElPersonajeElEstadoEsOcupado(){

        Personaje personaje = new Personaje();

        Casilla casilla = new Casilla(personaje);
        Assert.assertFalse(casilla.estaVacia());
    }

    @Test
    public void test05SeIntentaColocarUnBloqueDeMaterialEnUnaCasillaYaOcupadaLanzaExcepcionCasillaYaOcupada(){

        BloqueMadera bloqueMadera = new BloqueMadera();
        Casilla casilla = new Casilla(bloqueMadera);

        thrown.expect(CasilleroEstaOcupadoException.class);
        casilla.colocar(bloqueMadera);
    }

    @Test
    public void test06SeIntentaColocarElPersonajeEnUnaCasillaYaOcupadaLanzaExcepcionCasillaYaOcupada(){


        Casilla casilla = new Casilla(new BloqueMadera());
        Personaje personaje = new Personaje();

        thrown.expect(CasilleroEstaOcupadoException.class);
        casilla.colocar(personaje);
    }

    @Test
    public void test07SePuedeColocarBloqueEnUnaCasillaLibre(){

        BloqueMadera bloqueMadera = new BloqueMadera();

        Casilla casilla = new Casilla();
        casilla.colocar(bloqueMadera);
        Assert.assertFalse(casilla.estaVacia());
    }

    @Test
    public void test08SePuedeColocarElPersonajeEnUnaCasillaLibre(){

        Personaje personaje = new Personaje();

        Casilla casilla = new Casilla();
        casilla.colocar(personaje);
        Assert.assertFalse(casilla.estaVacia());
    }

}
