package EjercicioSemaforos;
import java.util.concurrent.Semaphore;

public class Fabrica {
    // Semaforos generales
    private Semaphore cajaVino, cajaAguaSabor, almacen;
    // Semaforos binarios
    private Semaphore embotelladorAgua, embotelladorVino, empaquetador, transportador;
    // Variables de utilidad
    private char tipoCaja;

    public Fabrica() {
        cajaVino = new Semaphore(10);
        cajaAguaSabor = new Semaphore(10);
        almacen = new Semaphore(10);
        embotelladorAgua = new Semaphore(1);
        embotelladorVino = new Semaphore(1);
        empaquetador = new Semaphore(0);
        transportador = new Semaphore(0);
        tipoCaja = '-';
    }

    public void embotellar() {
        try {
            if (Thread.currentThread().getName().charAt(0) == 'V') {
                embotelladorVino.acquire();
                tipoCaja = 'V';
                System.out.println("Embotellador de Vino: Cargando botella.");
                Thread.sleep(4000); // simulando carga.
                if (cajaVino.tryAcquire()) { // Puedo empaquetar
                    System.out.println("Embotellador de Vino: Botella empaquetada.");
                    empaquetador.release();
                } else {
                    embotelladorVino.release();
                }
            } else {
                embotelladorAgua.acquire();
                tipoCaja = 'A';
                System.out.println("Embotellador de Agua: Cargando botella.");
                Thread.sleep(4000); // simulando carga.
                if (cajaAguaSabor.tryAcquire()) { // Puedo empaquetar
                    System.out.println("Embotellador de Agua: Botella empaquetada.");
                    empaquetador.release();
                } else {
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
            if (almacen.tryAcquire()) {
                if (tipoCaja == 'V') {
                    System.out.println("Empaquetador: Empaquetando caja de Vino.");
                    cajaVino.release(10);
                } else {
                    System.out.println("Empaquetador: Empaquetando caja de Agua.");
                    cajaAguaSabor.release(10);
                }
                transportador.release();
            } else {
                empaquetador.release();
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
