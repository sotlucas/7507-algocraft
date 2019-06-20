package fiuba.algo3.modelo;

public abstract class Direccion {
    
    public abstract void avanzar(Mapa mapa, Jugador jugador);
    public abstract void golpear(Mapa mapa, Herramienta herramienta, Jugador jugador);
}
