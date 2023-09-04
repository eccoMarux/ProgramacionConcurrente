package Ejercicio04;

public class test {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            ThreadRunnable mj = new ThreadRunnable("Maria Jose");
            ThreadRunnable jm = new ThreadRunnable("Jose Maria");
            Thread t1 = new Thread(mj);
            Thread t2 = new Thread(jm);
            t1.run();
            t2.run();
            System.out.println("Termina thread main");
        }

    }

    /*
     * 4) La interfaz Runnable proporciona un método alternativo a la utilización de
     * la clase Thread, implemente el ejercicio anterior utilizando la interfaz Runnable.
     * ¿Qué sucede? ¿Es necesario el constructor?
     * 
     * Deberia suceder lo mismo que en el ejercicio anterior. De todas maneras,
     * lo ejecutamos varias veces y la prioridad de hilos parecio haber cambiado
     * porque no empezaba uno sin haber terminado el otro. 
     * Es necesario hacer el constructor porque no hereda ningun constructor ya que no es 
     * sublcase de Thread, sino que implementa la interfaz Runnable.
     */

}
