package Ejercicio08;

import java.io.IOException;

public class PruebaExcep {
    public static void edadException(int edad) {
        // Método que ingrese la edad de una persona y dispare una excepción si la
        // persona es menor de edad.
        try {
            if (edad < 18) {
                throw new IOException("Es menor de edad.");
            }
            System.out.println("Inicio de sesion.");
        } catch (IOException error) {
            System.out.println("Edad invalida, no se inició sesion. " + error);
        }
    }

    public static void numeroRuleta(int nroRuleta, int nroApuesta) {
        // Método que ingrese un numero de la ruleta y dispare una excepción cuando al jugar no le salga dicho número.

        try {
            if (nroRuleta != nroApuesta) {
                throw new IOException("Los números son diferentes.");
            }
            System.out.println("Ganaste!");
        } catch (IOException error) {
            System.out.println("Perdiste! " + error);
        }
    }

    public static void errorMuestraArray(){
        //Creada una coleccion con 5 valores numeros, al tratar de mostrarlos intenta mostrar 7 valores generando una excepción.
        int[] numeros = {1, 2, 3, 4, 5};
        int i;
        String cadena = "";
        try {
            for (i = 0; i < 7; i++) {
                cadena = cadena + numeros[i]+" ";
            }
            System.out.println(cadena);
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("Fuera de rango. Error: " +error);
        }
    }
}
