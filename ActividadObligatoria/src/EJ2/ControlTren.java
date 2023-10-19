package EJ2;
import java.util.concurrent.Semaphore;

public class ControlTren extends Thread {
    Semaphore partida;
    Semaphore llegada;
    Semaphore prohibidoBajar;
    private Semaphore[] asientos;

    //Contructor
    public ControlTren(int cantAsientos) {
        this.partida = new Semaphore(1);
        this.llegada = new Semaphore(0);
        this.prohibidoBajar = new Semaphore(1);
        this.asientos = new Semaphore[cantAsientos];
        for (int i = 0; i < cantAsientos; i++) {
            asientos[i] = new Semaphore(1);
        }
    }

    public int estadoViaje(){
        return this.prohibidoBajar.availablePermits();
    }

    public void trenLlego() {
        /* Cambia la disponibilidad de los semaforos. */
        try {
            this.partida.release();
            this.llegada.acquire();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void trenSale() {
        /* Cambia la disponibilidad de los semaforos. */
        try {
            this.partida.acquire();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void viajando() throws Exception {
        /*Comienza el viaje, duerme por 4 segundos simulando el viaje. */
        this.trenSale();
        System.out.println("El tren esta viajando!!! :D");
        Thread.sleep(2000);
    }

    public void llegando() throws Exception {
        /* */
        this.trenLlego();
        System.out.println("El tren llegó!!! ");
        Thread.sleep(2000);
    }

        public int verificarAsiento() {
        /*
         * Verifica si hay asientos disponibles. Si hay uno, devuelve el nro de asiento
         * sino devuelve -1
         */
        boolean asientoDisponible = false;
        int i = 0, nroAsiento = -1;
        while (i < this.asientos.length && !asientoDisponible) {
            if (this.asientos[i].availablePermits() == 1) {
                asientoDisponible = true;
                nroAsiento = i;
            } else {
                i++;
            }
        }
        return nroAsiento;
    }

    public void ocuparAsiento(int nro) {
        /* Se ocupa el asiento que ingresa por parametro. */
        try {
            this.asientos[nro].acquire();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void liberarAsiento(int nro){
        /* Se libera el asiento que ingresa por parametro. */
        try {
            this.asientos[nro].release();;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void run() {
        while (true) {
            if (this.verificarAsiento() == -1) {
                try {
                    this.viajando();
                    if(this.llegada.availablePermits() == 1 && this.partida.availablePermits() == 0){
                        this.llegando();
                    }
                    
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                
            }

        }
    }
}