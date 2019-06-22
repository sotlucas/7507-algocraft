package fiuba.algo3.modelo;

public class ConstruirHachaMadera implements ConstructorHerramienta{

    @Override
    public Hacha construir() {
        return new Hacha(new Madera());
    }
}
