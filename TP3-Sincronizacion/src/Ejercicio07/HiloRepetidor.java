package Ejercicio07;

public class HiloRepetidor implements Runnable{
    private char letra;
    private int cantRepeticiones;
    private ImpresoraCaracter impresora;

    public HiloRepetidor(char letra, int cantRepeticiones){
        this.letra = letra;
        this.cantRepeticiones = cantRepeticiones;
    }

    public void run(){
        impresora = new ImpresoraCaracter(this.letra);
        System.out.println(impresora.imprimir(cantRepeticiones));
    }
}
