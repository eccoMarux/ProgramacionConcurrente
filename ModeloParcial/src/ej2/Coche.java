package ej2;
import java.util.Random;

public class Coche extends Thread {
    private GestorCruce cruce;
    private int j;

    public Coche(GestorCruce cruce) {
        this.cruce = cruce;
    }

    public void run() {
        try {
            j = new Random().nextInt(2); 
            switch (j) {
                case 0: // Norte
                    cruce.llegaNorte();
                    Thread.sleep(1000);
                    cruce.sale();
                    break;
                case 1: // Oeste
                    cruce.llegaOeste();
                    Thread.sleep(1000);
                    cruce.sale();
                    break;
            }
        } catch (Exception e) {
            //...
        }
    }
}
