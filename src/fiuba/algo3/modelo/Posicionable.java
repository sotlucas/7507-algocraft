package fiuba.algo3.modelo;

public interface Posicionable {
   public char getIdentificador();

   public void recibirDanio(Hacha hacha);
   public void recibirDanio(Pico pico);
   public void recibirDanio(PicoFino picoFino);
   public Material cederMaterial();
   public int getDurabilidad();
   public boolean estaRoto();

}
