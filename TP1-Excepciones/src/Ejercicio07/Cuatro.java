package Ejercicio07;

import java.io.IOError;
import java.io.IOException;

public class Cuatro {
    private static int metodo() {
        int valor = 0;
        try {
            valor = valor + 1;
            valor = valor + Integer.parseInt("W");
            valor = valor + 1;
            System.out.println("Valor al final del try: " + valor);
            throw new IOException();
        } catch (IOException e) {
            valor = valor + Integer.parseInt("42");
            System.out.println("Valor al final del catch: " + valor);
        } finally {
            valor = valor + 1;
            System.out.println("Valor al final del finally: " + valor);
        }
        valor = valor + 1;
        System.out.println("Valor antes del return: " + valor);
        return valor;
    }

    public static void main(String[] args) {
        try {
            System.out.println(metodo());
        } catch (Exception e) {
            System.err.println("Excepcion en metodo()");
            e.printStackTrace();
        }
    }
    /*
     * Explicacion:
     * Cuando hay un error en el try (valor = valor + Integer.parseInt("W");) nunca
     * pasa del try al
     * catch porque el catch esta esperando errores del tipo IOException en lugar de
     * errores del
     * tipo NumberFormatException que es el tipo de error que se produce. Si accede a la
     * ejecucion del
     * finally por eso nos imprime valor = 2 pero al tener un error inesperado, el
     * main imprime su
     * mensaje ('Excepcion en metodo()') cuando encuentra un error del tipo
     * Exception.
     */
}