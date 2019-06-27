package fiuba.algo3.modelo;

import java.util.HashMap;

public class Constructor {
    
    private HashMap<String, ConstructorHerramienta> recetas = new HashMap<String, ConstructorHerramienta>();

    public Constructor()
    {
        this.agregarReceta("mm-mm--m-", new ConstruirHachaMadera());
        this.agregarReceta("pp-pm--m-", new ConstruirHachaPiedra());
        this.agregarReceta("MM-Mm--m-", new ConstruirHachaMetal());
        this.agregarReceta("mmm-m--m-", new ConstruirPicoMadera());
        this.agregarReceta("ppp-m--m-", new ConstruirPicoPiedra());
        this.agregarReceta("MMM-m--m-", new ConstruirPicoMetal());
        this.agregarReceta("MMMpm--m-", new ConstruirPicoFino());
    }

    public boolean puedoCraftear(String receta)
    {
        return this.recetas.containsKey(receta);
    }

    public void agregarReceta(String receta, ConstructorHerramienta constructor)
    {
        this.recetas.put(receta, constructor);
    }


    public Herramienta craftear(String receta)
    {
        if (this.puedoCraftear(receta)) {
            return this.recetas.get(receta).construir();
        }
        throw new RecetaNoExisteException();
    }
}
