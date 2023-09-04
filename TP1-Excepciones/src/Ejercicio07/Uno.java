package Ejercicio07;

public class Uno {
    private static int metodo() {
        int valor = 0;
        try {
            valor = valor + 1;
            valor = valor + Integer.parseInt("42");
            // Para que entre a carch, descomentar:
            // valor = valor + Integer.parseInt("a");
            valor = valor + 1;
            System.out.println("Valor al final del try: " + valor);
        } catch (NumberFormatException e) {
            valor = valor + Integer.parseInt("42");
            // Para que entre a carch del main, descomentar el de try y este:
            // valor = valor + Integer.parseInt("b");
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
     * Esto se debe a que en la linea 5 el valor de la variable valor es cero.
     * Entra a la estructura 'try-catch-finally'. Intenta resolver lo propuesto en
     * try. Luego a valor
     * le suma 1, quedando valor = 1. Luego, le suma a valor 42, resultando queda
     * 43. Finalmente le
     * suma nuevamente 1, quedando valor=44.
     * Como no encontró errores durante la ejecucion, salta a finally donde el valor
     * es sumado en 1
     * quedando valor=45.
     * Al salir de la estructura 'try-catch-finally', suma nuevamente 1 y lo retorna
     * (quedando
     * valor=46).
     * El main imprime 46.
     */
}
