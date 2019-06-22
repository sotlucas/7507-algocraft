package fiuba.algo3.modelo;

public class ConstruirPicoMetal implements ConstructorHerramienta{

    @Override
    public Pico construir() {
        return new Pico(new Metal());
    }
}
