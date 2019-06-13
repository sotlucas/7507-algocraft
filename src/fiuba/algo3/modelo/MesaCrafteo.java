package fiuba.algo3.modelo;

public class MesaCrafteo {

    /*
        Recetas:
            Hacha de madera   "mm-mm--m-"
            Hacha de piedra   "pp-pm--m-"
            Hacha de metal    "MM-Mm--m-"
            Pico de madera    "mmm-m--m-"
            Pico de piedra    "ppp-m--m-"
            Pico de metal     "MMM-m--m-"
            Pico fino         "MMMpm--m-"
     */
    
    private char[] tablero;

    public MesaCrafteo(){

        tablero = new char[9];
        for(int i = 0; i < 9; i++){

            tablero[i] = '-';
        }
    }

    public String getRecetaParaConstruir(){

        StringBuilder clave = new StringBuilder();

        for(char letra: tablero){

            clave.append(letra);
        }

        return clave.toString();
    }

}
