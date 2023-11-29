package EjercicioSemaforos;

import java.util.concurrent.Semaphore;

public class Fabrica {
    // Semaforos generales
    private Semaphore cajaVino, cajaAguaSabor, almacen;
    // Semaforos binarios
    private Semaphore embotelladorAgua, embotelladorVino, empaquetador, transportador;
    // Variables de utilidad
     
    private int contadorBotellasVino, contadorBotellasAgua;

    public Fabrica() {
        cajaVino = new Semaphore(10);
        cajaAguaSabor = new Semaphore(10);
        almacen = new Semaphore(10);
        embotelladorAgua = new Semaphore(1);
        embotelladorVino = new Semaphore(1);
        empaquetador = new Semaphore(0);
        transportador = new Semaphore(0);
         
        contadorBotellasVino = 0;
        contadorBotellasAgua = 0;
    }

    public void embotellar() {
        try {
            if (Thread.currentThread().getName().charAt(0) == 'V') {
                embotelladorVino.acquire();
                 
                System.out.println("Embotellador de Vino: Cargando botella.");
                Thread.sleep(4000); // simulando carga.
                contadorBotellasVino++;
                if (contadorBotellasVino == 10) { // Completé 10 botellas
                    System.out.println("Embotellador de Vino: despertar empaquetador.");
                    //Posible problema.
                    empaquetador.release();
                    
                    cajaVino.acquire();
                    System.out.println("Embotellador de Vino: Botella empaquetada."+contadorBotellasVino);
                    embotelladorVino.release();
                } else {
                    cajaVino.acquire();
                    System.out.println("Embotellador de Vino: Botella empaquetada."+contadorBotellasVino);
                    embotelladorVino.release();
                }
            } else {
                embotelladorAgua.acquire();
                 
                System.out.println("Embotellador de Agua: Cargando botella.");
                Thread.sleep(4000); // simulando carga.
                contadorBotellasAgua++;
                if (contadorBotellasAgua == 10) { // Completé 10 botellas
                    System.out.println("Embotellador de Agua: Despertar empaquetador.");
                    //Posible problema.
                    empaquetador.release();
                    
                    cajaAguaSabor.acquire();
                    System.out.println("Embotellador de Agua: Botella empaquetada."+contadorBotellasAgua);
                    embotelladorAgua.release();
                } else {
                    cajaAguaSabor.acquire();
                    System.out.println("Embotellador de Agua: Botella empaquetada."+contadorBotellasAgua);
                    embotelladorAgua.release();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void empaquetar() {
        try {
            empaquetador.acquire();
            if (almacen.tryAcquire()) { //Poner contador con almacen != 10 cajas
                if (contadorBotellasVino == 10) {
                    System.out.println("Empaquetador: Empaquetando caja de Vino.");
                    cajaVino.release(10);
                    contadorBotellasVino =0;
                } else if (contadorBotellasAgua == 10) {
                    System.out.println("Empaquetador: Empaquetando caja de Agua.");
                    cajaAguaSabor.release(10);
                    contadorBotellasAgua =0;
                }
            } else {
                System.out.println("Empaquetador: No queda espacio en el almacen.");
                System.out.println("Empaquetador: Despetar transportdor.");
                transportador.release();
                //empaquetador.release(); otro metodo con otro semaforo.
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void transportar() {
        try {
            transportador.acquire();
            System.out.println("Transportador: Transportando cajas. Liberando almacen.");
            almacen.release(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
