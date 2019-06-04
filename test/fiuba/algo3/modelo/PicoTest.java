package fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PicoTest {

    @Test
    public void test01PicoDeMaderaRecienCreadoTieneDurabilidad100() {
        Madera madera = new Madera();
        Pico picoDeMadera = new Pico(madera);

        assertEquals(100, picoDeMadera.getDurabilidad());
    }

    @Test
    public void test02PicoDeMaderaRecienCreadoTieneFuerza2 () {
        Madera madera = new Madera();
        Pico picoDeMadera = new Pico(madera);

        assertEquals(2, picoDeMadera.getFuerza());
    }

    @Test
    public void test03PicoDePiedraRecienCreadoTieneDurabilidad200 () {
        Piedra piedra = new Piedra();
        Pico picoDePiedra = new Pico(piedra);

        assertEquals(200, picoDePiedra.getDurabilidad());
    }

    @Test
    public void test04PicoDePiedraRecienCreadoTieneFuerza4 () {
        Piedra piedra = new Piedra();
        Pico picoDePiedra = new Pico(piedra);

        assertEquals(4, picoDePiedra.getFuerza());
    }

    @Test
    public void test05PicoDeMetalRecienCreadoTieneDurabilidad400 () {
        Metal metal = new Metal();
        Pico picoDeMetal = new Pico(metal);

        assertEquals(400, picoDeMetal.getDurabilidad());
    }

    @Test
    public void test06PicoDeMetalRecienCreadoTieneFuerza12 () {
        Metal metal = new Metal();
        Pico picoDeMetal = new Pico(metal);

        assertEquals(12, picoDeMetal.getFuerza());
    }

/*
    @Test
    public void picoDeMaderaSeUsaContraCadaUnoDeLosBloquesYSeReduceSuDurabilidadCorrespondienteAlMaterialDelPico(){

    }


    @Test
    public void SeCreaHachaDeMetalConSuDurabilidadYFuerzaCorrespondiente(){

        Constructor constructor = new Constructor();
        Hacha hachaMetal = constructor.construirHachaDeMetal();

        Assert.assertEquals(10, hachaMetal.getFuerza());
        Assert.assertEquals(400, hachaMetal.getDurabilidad(), 0);
    }

    @Test
    public void hachaDeMaderaSeUsaContraBloqueDeMaderaYSeReduceSuDurabilidadCorrespondienteAlMaterialDelHacha(){

        Constructor constructor = new Constructor();
        Hacha hachaMadera = constructor.construirHachaDeMadera();
        double durabilidadInicialHachaMadera = hachaMadera.getDurabilidad();

        BloqueMadera bloqueMadera = new BloqueMadera();

        hachaMadera.usarEn(bloqueMadera);
        Assert.assertEquals(98, hachaMadera.getDurabilidad(), 0);

    }

    @Test
    public void hachaDeMaderaSeUsaContraBloqueDePiedraYSeReduceSuDurabilidadCorrespondienteAlMaterialDelHacha(){

        Constructor constructor = new Constructor();
        Hacha hachaMadera = constructor.construirHachaDeMadera();

        double durabilidadInicialHachaMadera = hachaMadera.getDurabilidad();

        BloquePiedra bloquePiedra = new BloquePiedra();

        hachaMadera.usarEn(bloquePiedra);
        Assert.assertEquals(98, hachaMadera.getDurabilidad(), 0);

    }

    @Test
    public void hachaDePiedraSeUsaContraBloqueDeMaderaYSeReduceSuDurabilidadCorrespondienteAlMaterialDelHacha(){

        Constructor constructor = new Constructor();
        Hacha hachaPiedra = constructor.construirHachaDePiedra();
        double durabilidadInicialHachaPiedra = hachaPiedra.getDurabilidad();

        BloquePiedra bloquePiedra = new BloquePiedra();

        hachaPiedra.usarEn(bloquePiedra);
        Assert.assertEquals(195, hachaPiedra.getDurabilidad(), 0);

    }






    //hachaSeUsaContraCadaUnoDeLosMaterialesYSeReduceSuDurabilidadCorrespondienteAlMaterialDelHacha
*/
}
