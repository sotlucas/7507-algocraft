package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HachaTest {

        @Rule
        public ExpectedException thrown = ExpectedException.none();

        @Test
        public void test01losConstructoresDelHachaDevuelvenAlgoDistintoDeNull() {

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
        public void test02HachaDeMaderaRecienCreadaTieneDurabilidad100() {
            Madera madera = new Madera();
            Hacha hachaDeMadera = new Hacha(madera);

            Assert.assertEquals(100.0, hachaDeMadera.getDurabilidad(), 0);
        }

        @Test
        public void test03HachaDeMaderaRecienCreadaTieneFuerza2() {
            Madera madera = new Madera();
            Hacha hachaDeMadera = new Hacha(madera);

            Assert.assertEquals(2, hachaDeMadera.getFuerza(), 0);
        }

        @Test
        public void test04HachaDePiedraRecienCreadaTieneDurabilidad100() {
            Piedra piedra = new Piedra();
            Hacha hachaDePiedra = new Hacha(piedra);

            Assert.assertEquals(200.0, hachaDePiedra.getDurabilidad(), 0);
        }

        @Test
        public void test05HachaDePiedraRecienCreadaTieneFuerza2() {

            Piedra piedra = new Piedra();
            Hacha hachaDePiedra = new Hacha(piedra);

            Assert.assertEquals(5, hachaDePiedra.getFuerza());
        }

        @Test
        public void test06HachaDeMetalRecienCreadaTieneDurabilidad400() {

            Metal metal = new Metal();
            Hacha hachaDeMetal = new Hacha(metal);

            Assert.assertEquals(400.0, hachaDeMetal.getDurabilidad(), 0);
        }

        @Test
        public void test07HachaDeMetalRecienCreadaTieneFuerza10() {

            Metal metal = new Metal();
            Hacha hachaDeMetal = new Hacha(metal);

            Assert.assertEquals(10, hachaDeMetal.getFuerza());
        }

        @Test
        public void test08HachaDeMaderaSeUsaContraCadaUnoDeLosBloquesYSeReduceSuDurabilidadEn2() {

            Madera madera = new Madera();
            Hacha hachaDeMadera = new Hacha(madera);

            BloqueMadera bloqueMadera = new BloqueMadera();
            BloquePiedra bloquePiedra = new BloquePiedra();
            BloqueMetal bloqueMetal = new BloqueMetal();

            hachaDeMadera.usarEn(bloqueMadera);
            Assert.assertEquals(98.0, hachaDeMadera.getDurabilidad(), 0);

            hachaDeMadera.usarEn(bloquePiedra);
            Assert.assertEquals(96.0, hachaDeMadera.getDurabilidad(), 0);

            hachaDeMadera.usarEn(bloqueMetal);
            Assert.assertEquals(94.0, hachaDeMadera.getDurabilidad(), 0);
        }

        @Test
        public void test09HachaDePiedraSeUsaContraCadaUnoDeLosBloquesYSeReduceSuDurabilidadEn2() {

            Piedra piedra = new Piedra();
            Hacha hachaDePiedra = new Hacha(piedra);

            BloqueMadera bloqueMadera = new BloqueMadera();
            BloquePiedra bloquePiedra = new BloquePiedra();
            BloqueMetal bloqueMetal = new BloqueMetal();

            hachaDePiedra.usarEn(bloqueMadera);
            Assert.assertEquals(195.0, hachaDePiedra.getDurabilidad(), 0);

            hachaDePiedra.usarEn(bloquePiedra);
            Assert.assertEquals(190.0, hachaDePiedra.getDurabilidad(), 0);

            hachaDePiedra.usarEn(bloqueMetal);
            Assert.assertEquals(185.0, hachaDePiedra.getDurabilidad(), 0);
        }

        @Test
        public void test10HachaDeMetalSeUsaContraCadaUnoDeLosBloquesYSeReduceSuDurabilidad() {

            Metal metal = new Metal();
            Hacha hachaDeMetal = new Hacha(metal);

            BloqueMadera bloqueMadera = new BloqueMadera();
            BloquePiedra bloquePiedra = new BloquePiedra();
            BloqueMetal bloqueMetal = new BloqueMetal();

            hachaDeMetal.usarEn(bloqueMadera);
            Assert.assertEquals(395.0, hachaDeMetal.getDurabilidad(), 0);

            hachaDeMetal.usarEn(bloquePiedra);
            Assert.assertEquals(390.0, hachaDeMetal.getDurabilidad(), 0);

            hachaDeMetal.usarEn(bloqueMetal);
            Assert.assertEquals(385.0, hachaDeMetal.getDurabilidad(), 0);
        }

        @Test
        public void test11CuandoLaDurabilidadDelHachaLlegaACeroNoSeReduceMas(){

            Hacha hachaDeMadera = new Hacha(new Madera());

            //el hacha nunca dania al bloque de piedra, permite abstraerse de la durabilidad del bloque
            BloquePiedra bloquePiedra = new BloquePiedra();

            //golpea 50 veces
            for(int i = 0; i < 50; i++){

                hachaDeMadera.usarEn(bloquePiedra);
            }

            Assert.assertEquals(0, hachaDeMadera.getDurabilidad(), 0);

            thrown.expect(HerramientaSeRompioException.class);
            hachaDeMadera.usarEn(bloquePiedra);

        }

        @Test
        public void testSeVerificaQueLaRecetaDeElHachaDeMaderaEsCorrecta(){

            Hacha hachaDeMadera = new Hacha(new Madera());
            String recetaHachaMadera = "mm-mm--m-";

            Assert.assertEquals(hachaDeMadera.getReceta(), recetaHachaMadera);
        }

        @Test
        public void testSeVerificaQueLaRecetaDeElHachaDePiedraEsCorrecta(){

            Hacha hachaDePiedra = new Hacha(new Piedra());
            String recetaHachaPiedra = "pp-pm--m-";

            Assert.assertEquals(hachaDePiedra.getReceta(), recetaHachaPiedra);
        }

        @Test
        public void testSeVerificaQueLaRecetaDeElHachaDeMetalEsCorrecta(){

            Hacha hachaDeMetal = new Hacha(new Metal());
            String recetaHachaMetal = "MM-Mm--m-";

            Assert.assertEquals(hachaDeMetal.getReceta(), recetaHachaMetal);
        }

    }



