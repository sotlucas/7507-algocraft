package fiuba.algo3.modelo;

public class ConstruirHachaPiedra implements ConstructorHerramienta{

    @Override
    public Hacha construir()
    {
        return new Hacha(new Piedra());
    }
}
