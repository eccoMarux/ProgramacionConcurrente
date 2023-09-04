package Ejercicio07;

public class Dos {
    private static int metodo() {
        int valor = 0;
        try {
            valor = valor + 1;
            valor = valor + Integer.parseInt("W");
            valor = valor + 1;
            System.out.println("Valor al final del try: " + valor);
        } catch (NumberFormatException e) {
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
     * Al existir un error en la linea donde valor = valor + Integer.parseInt("W");,
     * el codigo deja
     * de ejecutar el try y lee el catch donde al valor que ya fue seteado en el try
     * (valor = 1),
     * le suma 42 (valor = 43). Luego en finally suma 1 (valor = 44) y antes del
     * return suma 1
     * (valor = 45).
     * El main escribe 45.
     */
}
