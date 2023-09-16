import java.util.Random;
public class Main {
   public static void main(String[] args) {
        int tamanoArreglo = 50000;
        int numHilos = 4; 
        int[] arreglo = new int[tamanoArreglo];
        Random random = new Random();

        // Carga el arreglo con numeros aleatoreos entre 1 y 10.
        for (int i = 0; i < tamanoArreglo; i++) {
            arreglo[i] = random.nextInt(10) + 1;
        }

        HiloSuma[] hilos = new HiloSuma[numHilos];
        int tamanoSegmento = tamanoArreglo / numHilos;

        for (int i = 0; i < numHilos; i++) {
            int inicio = i * tamanoSegmento;
            int fin;
            
            if (i == numHilos - 1) {
                fin = tamanoArreglo;
            } else {
                fin = (i + 1) * tamanoSegmento;
            }
            
            //Crea los hilos y los deja en estado "listo".
            hilos[i] = new HiloSuma(arreglo, inicio, fin);
            hilos[i].start();
        }

        // Espera a que todos los hilos terminen de ejecutar su suma parcial.
        try {
            for (int i = 0; i < numHilos; i++) {
                hilos[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Obtiene la suma total.
        int sumaTotal = HiloSuma.getSumaTotal();
        System.out.println("Suma total: " + sumaTotal);
    }
}