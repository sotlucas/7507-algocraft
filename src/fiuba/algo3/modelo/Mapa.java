package fiuba.algo3.modelo;

public class Mapa {

    private int ancho;
    private int alto;
    private Casilla[][] casillas;

    public Mapa(){

    }

    public Mapa(int alto, int ancho){

        this.alto = alto;
        this.ancho = ancho;
        casillas = new Casilla[alto][ancho];

        for(int i = 0; i < alto; i++ ){
            for(int j = 0; j < ancho; j++){

                casillas[i][j] = new Casilla();
            }
        }
    }

    public int getAltura() {

        return alto;
    }

    public int getAncho() {
        return ancho;
    }

    public Casilla getCasilla(int alto, int ancho){

        return casillas[alto][ancho];
    }

    public void colocar(Elemento elemento, int alto, int ancho) {

        Casilla casillaIndicada = casillas[alto][ancho];
        casillaIndicada.colocar(elemento);

    }

    public boolean casillaEstaVacia(int alto, int ancho){

        return casillas[alto][ancho].estaVacia();
    }

}
