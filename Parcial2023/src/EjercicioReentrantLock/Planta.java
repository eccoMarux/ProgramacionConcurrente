package EjercicioReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Planta {
    // Variables acumuladoras
    private int almacen, vinos, aguas;
    // ReentrantLock
    private ReentrantLock zonaCritica, repartidor;
    // Variables de Condicion
    private Condition empaquetar, repartir;

    // Contructor
    public Planta() {
        this.almacen = 0;
        this.vinos = 0;
        this.aguas = 0;
        this.zonaCritica = new ReentrantLock();
        this.empaquetar = zonaCritica.newCondition();
        this.repartir = zonaCritica.newCondition();
    }

    public void empezarVino() {
        // Llamado por Embotellador.java
        // Simula que empieza a cargar vino en la botella.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void terminarVino() {
        zonaCritica.lock();
        try {
            if (vinos < 10) {
                vinos++;
                System.out.println("Un vino más");
            } else if (vinos == 10) {
                System.out.println("La caja de vinos se llenó");
                empaquetar.signal(); // Señalizar al empaquetador solo si la caja de vinos se llenó
            }
        } finally {
            zonaCritica.unlock();
        }
    }

    public void empezarAgua() {
        // Llamado por Embotellador.java
        // Simula que empieza a cargar agua en la botella.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void terminarAgua() {
        zonaCritica.lock();
        try {
            if (aguas < 10) {
                aguas++;
                System.out.println("Un agua más");
            } else if (aguas == 10) {
                System.out.println("La caja de agua se llenó");
                empaquetar.signal(); // Señalizar al empaquetador solo si la caja de agua se llenó
            }
        } finally {
            zonaCritica.unlock();
        }
    }

    public void empezarEmpaquetado() throws InterruptedException {
        // Llamado por zonaCritica.java
        zonaCritica.lock();
        if (vinos < 10 || aguas < 10) {
            System.out.println("Empaquetador: Vinos:" + vinos + " y Aguas: " + aguas);
            System.out.println("Aun no hay que empaquetar.");
            empaquetar.await();
            System.out.println("Alguna caja se lleno");
            // Vemos que caja se lleno
            if (vinos == 10) {
                System.out.println("La caja de vinos se lleno");
                vinos = 0;
                almacen++;
                if (almacen == 10) {
                    repartir.signal();
                }
            }
            if (almacen < 10) {
                if (aguas == 10) {
                    System.out.println("La caja de agua se lleno");
                    aguas = 0;
                    almacen++;
                    if (almacen == 10) {
                        repartir.signal();
                    }
                }
            }

        } else {
            System.out.println("Alguna caja se lleno");
            if (vinos == 10) {
                System.out.println("La caja de vinos se lleno");
                vinos = 0;
                almacen++;
            }
            if (aguas == 10) {
                System.out.println("La caja de agua se lleno");
                aguas = 0;
                almacen++;
            }
        }
        zonaCritica.unlock();
    }

    public void transportar() throws InterruptedException {
        zonaCritica.lock();
        if (almacen < 10) {
            System.out.println("Transportador: Almacen " + almacen);
            repartir.await();
            System.out.println("EL ALMACEN SE LLENO");
            System.out.println("El repartidor vacia el almacen");
            almacen = 0;
        } else {
            System.out.println("EL ALMACEN SE LLENO");
            System.out.println("El repartidor vacia el almacen");
            almacen = 0;
        }
        zonaCritica.unlock();
        // Simulo viaje
        Thread.sleep(2000);
    }
}
