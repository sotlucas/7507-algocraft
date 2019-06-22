package fiuba.algo3.modelo;

public class ConstruirPicoMadera implements ConstructorHerramienta{

    @Override
    public Pico construir() {
        return new Pico(new Madera());
    }
}
