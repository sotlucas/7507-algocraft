package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;

    public class HachaTest {


        @Test  //obligatoria
        public void SeCreaHachaDeMaderaConSuDurabilidadYFuerzaCorrespondiente(){
            Madera madera = new Madera();
            Hacha hachaDeMadera = new Hacha(madera);

            Assert.assertEquals(100, hachaDeMadera.getDurabilidad());
        }

        /*
        @Test
        public void SeCreaHachaDePiedraConSuDurabilidadYFuerzaCorrespondiente(){

        }

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



