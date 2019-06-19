package fiuba.algo3.modelo;

public class Mapa {

    private int cantidadColumnas;
    private int cantidadFilas;
    private Casilla[][] casillas;

    public Mapa(){

    }

    public Mapa(int cantidadFilas, int cantidadColumnas){

        this.cantidadFilas = cantidadFilas;
        this.cantidadColumnas = cantidadColumnas;
        casillas = new Casilla[cantidadFilas][cantidadColumnas];

        for(int i = 0; i < cantidadFilas; i++ ){
            for(int j = 0; j < cantidadColumnas; j++){

                casillas[i][j] = new Casilla();
            }
        }
    }

    public int getCantidadFilas() {

        return cantidadFilas;
    }

    public int getCantidadColumnas() {
        return cantidadColumnas;
    }

    public Casilla getCasilla(int fila, int columna){

        return casillas[fila][columna];
    }

    public void colocar(Posicionable elemento, int fila, int columna) {
        try {
            Casilla casillaIndicada = casillas[fila][columna];
            casillaIndicada.colocar(elemento);
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new PosicionFueraDelMapaException();
        }
    }

    public boolean casillaEstaVacia(int fila, int columna){

        return casillas[fila][columna].estaVacia();
    }

    public void mover(Posicionable elemento, int columnaAnterior, int filaAnterior, int columnaSiguiente, int filaSiguiente) {

        this.colocar(elemento, filaSiguiente, columnaSiguiente);
        // Tengo que borrar el elemento de la casilla anterior
        Casilla casillaAnterior = casillas[filaAnterior][columnaAnterior];
        casillaAnterior.vaciar();
    }
}
