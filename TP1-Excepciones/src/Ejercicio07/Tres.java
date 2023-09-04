package Ejercicio07;

public class Tres {
    private static int metodo() {
        int valor = 0;
        try {
            valor = valor + 1;
            valor = valor + Integer.parseInt("W");
            valor = valor + 1;
            System.out.println("Valor al final del try: " + valor);
        } catch (NumberFormatException e) {
            valor = valor + Integer.parseInt("W");
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
     * Como hay un error tanto en try como catch, entonces se ejecuta el try hasta
     * antes del error,
     * se ejecuta el catch hasta antes del error y finalmente se ejecuta el finally
     * hasta antes del
     * error. El valor final de valor es 2. Como el modulo tiene errores no
     * contemplados, entonces
     * el main entra en su estructura catch e imprime su mensaje seguido por la
     * descripcion de la
     * Excepcion.
     */
}