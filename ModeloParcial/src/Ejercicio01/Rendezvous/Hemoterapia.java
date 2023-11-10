package Rendezvous;

import java.util.concurrent.Semaphore;

public class Hemoterapia {
    private Semaphore llamada, salaEspera, recepcionista, dormirDonante1, entrevista, dormirDonante2, especialista, dormirDonante3;

    public Hemoterapia(int cant){
        llamada = new Semaphore(1, true);
        salaEspera = new Semaphore(cant, true);
        recepcionista = new Semaphore(0, true);
        dormirDonante1 = new Semaphore(0, true);
        entrevista = new Semaphore(0, true);
        dormirDonante2 = new Semaphore(0, true);
        especialista = new Semaphore(0, true);
        dormirDonante3 = new Semaphore(0, true);
    }

    public void llamar() throws InterruptedException{
        llamada.acquire();
        System.out.println(Thread.currentThread().getName()+" está llamando.");
        recepcionista.release();
        dormirDonante1.acquire();
        llamada.release();
    }

    public void atenderLlamado() throws InterruptedException{
        recepcionista.acquire();
        System.out.println(Thread.currentThread().getName()+" atendió llamada.");
    }

    public void terminarLlamado() throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" cortó llamada.");
        dormirDonante1.release();
    }

    public void salaEspera() throws InterruptedException{
        salaEspera.acquire();
        System.out.println(Thread.currentThread().getName()+" está esparando.");
        pedirEntrevista();
        pedirExtraccion();
    }

    public void pedirEntrevista() throws InterruptedException{
        entrevista.release();
        System.out.println(Thread.currentThread().getName()+" pidió entrevista.");
        dormirDonante2.acquire();
    }

    public void empezarEntrevista() throws InterruptedException{
        entrevista.acquire();
        System.out.println(Thread.currentThread().getName()+" empezó entrevista.");
    }

    public void terminarEntrevista() throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" terminó entrevista.");
        dormirDonante2.release();
    }

    public void pedirExtraccion() throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" pidió extracción.");
        especialista.release();
        dormirDonante3.acquire();
        System.out.println(Thread.currentThread().getName()+" recibio certificado");
    }

    public void empezarExtraccion() throws InterruptedException{
        especialista.acquire();
        System.out.println(Thread.currentThread().getName()+" empezó extracción.");
    }

    public void terminarExtraccion() throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" terminó extracción.");
        dormirDonante3.release();
    }

    public void desayuno(){
        System.out.println(Thread.currentThread().getName() + " desayuna");
    }
}
