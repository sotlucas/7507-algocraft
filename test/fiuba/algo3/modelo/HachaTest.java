package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;

    public class HachaTest {

        @Test
        public void test01losConstructoresDelHachaDevuelvenAlgoDistintoDeNull(){

            Madera madera = new Madera();
            Piedra piedra = new Piedra();
            Metal metal = new Metal();

            Hacha hachaDeMadera = new Hacha(madera);
            Hacha hachaDePiedra = new Hacha(piedra);
            Hacha hachaDeMetal = new Hacha(metal);

            Assert.assertNotNull(hachaDeMadera);
            Assert.assertNotNull(hachaDePiedra);
            Assert.assertNotNull(hachaDeMetal);
        }

        @Test
        public void test02HachaDeMaderaRecienCreadaTieneDurabilidad100(){
            Madera madera = new Madera();
            Hacha hachaDeMadera = new Hacha(madera);

            Assert.assertEquals(100, hachaDeMadera.getDurabilidad());
        }

        @Test
        public void test03HachaDeMaderaRecienCreadaTieneFuerza2(){
            Madera madera = new Madera();
            Hacha hachaDeMadera = new Hacha(madera);

            Assert.assertEquals(100, hachaDeMadera.getDurabilidad());
        }

        @Test
        public void test02HachaDePiedrRecienCreadaTieneDurabilidad100(){
            Piedra piedra = new Piedra();
            Hacha hachaDePiedra = new Hacha(piedra);

            Assert.assertEquals(200, hachaDePiedra.getDurabilidad());
        }

        @Test
        public void test03HachaDePiedraRecienCreadaTieneFuerza2(){

            Piedra piedra = new Piedra();
            Hacha hachaDePiedra = new Hacha(piedra);

            Assert.assertEquals(5, hachaDePiedra.getFuerza());
        }
/*
        @Test
        public void SeCreaHachaDePiedraConSuDurabilidadYFuerzaCorrespondiente(){

            Piedra piedra = new Piedra();
            Hacha hachaDePiedra = new Hacha(piedra);

            Assert.assertEquals(200, hachaDePiedra.getDurabilidad());
            Assert.assertEquals(5, hachaDePiedra.getFuerza());
        }*/
/*
        @Test  //obligatoria
        public void SeCreaHachaDeMetalConSuDurabilidadYFuerzaCorrespondiente() {
        }


        @Test //obligatoria
        public void hachaDeMaderaSeUsaContraCadaUnoDeLosBloquesYSeReduceSuDurabilidadCorrespondienteAlMaterialDelHecha(){


        }


        @Test
        public void hachaDeMaderaSeUsaContraBloqueDePiedraYSeReduceSuDurabilidadCorrespondienteAlMaterialDelHacha(){


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



