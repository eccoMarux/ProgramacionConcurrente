package Ejercicio07;

public class ImpresoraCaracter {
    private char caracter;

    public ImpresoraCaracter(char caracterARepetir){
        this.caracter = caracterARepetir;
    }

    public synchronized String imprimir(int cantRepeticiones) {
        String cadena="";
        for (int i = 0; i < cantRepeticiones; i++) {
            cadena = cadena + this.caracter;
        }
        return cadena;
    }
}
