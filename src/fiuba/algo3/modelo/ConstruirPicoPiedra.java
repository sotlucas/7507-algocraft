package fiuba.algo3.modelo;

public class ConstruirPicoPiedra implements ConstructorHerramienta{

    @Override
    public Pico construir()
    {
        return new Pico(new Piedra());
    }
}
