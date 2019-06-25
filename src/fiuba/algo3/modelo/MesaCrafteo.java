package fiuba.algo3.modelo;

public class MesaCrafteo {

    /*    Recetas:
            Hacha de madera   "mm-mm--m-"
            Hacha de piedra   "pp-pm--m-"
            Hacha de metal    "MM-Mm--m-"
            Pico de madera    "mmm-m--m-"
            Pico de piedra    "ppp-m--m-"
            Pico de metal     "MMM-m--m-"
            Pico fino         "MMMpm--m-"
     */

    private Material[] tablero;
    protected Constructor constructor;

    public MesaCrafteo(){
        constructor = new Constructor();
        tablero = new Material[9];
        for(int i = 0; i < 9; i++){

            tablero[i] = null;
        }
    }

    public String getRecetaParaConstruir(){

        StringBuilder clave = new StringBuilder();

        for(Material material: tablero){
            if(material != null) {
                clave.append(material.getIdentificador());
            } else {

                clave.append('-');
            }
        }

        return clave.toString();
    }

    public void disponerMaterialesParaPicoDeMadera() {
        tablero[0] = new Madera();
        tablero[1] = new Madera();
        tablero[2] = new Madera();
        tablero[3] = null;
        tablero[4] = new Madera();
        tablero[5] = null;
        tablero[6] = null;
        tablero[7] = new Madera();
        tablero[8] = null;
    }

    public void colocar(Material material, int pos) {

        tablero[pos] = material;
    }

    public Herramienta construir(){
        String receta = this.getRecetaParaConstruir();

        return constructor.craftear(receta);
    }

    public void vaciar() {
        for(int i = 0; i < 9; i++){
            tablero[i] = null;
        }
    }
}
