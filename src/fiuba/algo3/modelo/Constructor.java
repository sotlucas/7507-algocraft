package fiuba.algo3.modelo;

import java.util.HashMap;

public class Constructor {
    
    //private HashMap<String, Item> recetas = new HashMap<String, Item>();

    /*
    public Constructor() {
        this.agregarReceta("mm-mm--m-", new Hacha(new Madera()));
        this.agregarReceta("pp-pm--m-", new Hacha(new Piedra()));
        this.agregarReceta("MM-Mm--m-", new Hacha(new Metal()));
        this.agregarReceta("mmm-m--m-", new Pico(new Madera()));
        this.agregarReceta("ppp-m--m-", new Pico(new Piedra()));
        this.agregarReceta("MMM-m--m-", new Pico(new Metal()));
        this.agregarReceta("MMMpm--m-", new PicoFino());
    }

    public boolean puedoCraftear(String receta) {
        return this.recetas.containsKey(receta);
    }

    public void agregarReceta(String receta, Item resultado) {
        this.recetas.put(receta, resultado);
    }
    */

    public Herramienta craftear(String receta) {
        Herramienta herramienta;

        switch (receta) {
            case "mm-mm--m-":
                herramienta = new Hacha(new Madera());
                break;
            case "pp-pm--m-":
                herramienta = new Hacha(new Piedra());
                break;
            case "MM-Mm--m-":
                herramienta = new Hacha(new Metal());
                break;
            case "mmm-m--m-":
                herramienta = new Pico(new Madera());
                break;
            case "ppp-m--m-":
                herramienta = new Pico(new Piedra());
                break;
            case "MMM-m--m-":
                herramienta = new Pico(new Metal());
                break;
            case "MMMpm--m-":
                herramienta = new PicoFino();
                break;
            default:
                herramienta = null;
                break;
        }

        return herramienta;
        //return this.construir(this.recetas.get(receta));
    }

    /*
    private Item construir(Hacha hacha) {
        return new Hacha(hacha.getMaterial().getClass());
    }

    private Item construir(Pico pico) {
        return new Pico(pico.getMaterial());
    }

    private Item construir(PicoFino picoFino) {
        return new PicoFino();
    }
    */
}
 
