package fiuba.algo3.modelo;

public class ConstruirHachaMetal implements ConstructorHerramienta{

    @Override
    public Hacha construir() {
        return new Hacha(new Metal());
    }
}
