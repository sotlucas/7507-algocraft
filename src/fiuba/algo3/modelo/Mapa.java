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

        try{
            return casillas[fila][columna];
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new PosicionFueraDelMapaException();
        }

    }

    public void colocarBloque(Bloque bloque, int fila, int columna) {
        try {
            Casilla casillaIndicada = casillas[fila][columna];
            casillaIndicada.colocar(bloque);
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new PosicionFueraDelMapaException();
        }
    }

    public void colocarJugador(Jugador jugador, int fila, int columna) {
        try {
            Casilla casillaIndicada = casillas[fila][columna];
            casillaIndicada.colocar(jugador);
            jugador.setPosicion(fila, columna);
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new PosicionFueraDelMapaException();
        }
    }

    public boolean casillaEstaVacia(int fila, int columna){

        return casillas[fila][columna].estaVacia();
    }

    public void moverJugador(Jugador jugador, int columnaAnterior, int filaAnterior, int columnaSiguiente, int filaSiguiente) {

        this.colocarJugador(jugador, filaSiguiente, columnaSiguiente);
        // Tengo que borrar el elemento de la casilla anterior
        Casilla casillaAnterior = casillas[filaAnterior][columnaAnterior];
        casillaAnterior.vaciar();
    }
}
