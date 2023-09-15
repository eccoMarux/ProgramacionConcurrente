package Ejercicio05;

class Auto extends Vehiculo implements Runnable {
    private int capacidadTanque;
    private int nivelReserva;
    private int kmDeViaje;
    private Surtidor surtidor;

    public Auto(String patente, String modelo, String marca, int capacidadTanque, int nivelReserva, int kmTotalesViaje,
            Surtidor surtidor) {
        super(patente, modelo, marca);
        this.capacidadTanque = capacidadTanque;
        this.nivelReserva = nivelReserva;
        this.surtidor = surtidor;
        this.kmDeViaje = kmTotalesViaje;
    }

    @Override
    public void run() {
        int distanciaRecorrida = 0;
        int litrosGastados = 0;
        while (distanciaRecorrida < this.kmDeViaje) {
            
            distanciaRecorrida += 10;
            setKilometraje(distanciaRecorrida); // Aumenta la distancia al kilometraje del auto.

            // Calcula el consumo de combustible. Consume 10 litros cada 100 km.
            if (distanciaRecorrida % 100 == 0) {
                litrosGastados += 10;
            }
            
            // En base al calculo anterior, si los litros superan a la reserva, entonces
            // carga combustible.
            if (litrosGastados >= nivelReserva) {
                surtidor.abastecer(this);
                // Simula tiempo de carga de combustible.
                try {
                    Thread.sleep(1000); // Espera 1 segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("El auto "+this.patente+" llegó a su destino.");
    }

    public int getCapacidadTanque() {
        return this.capacidadTanque;
    }

    public int getNivelReserva() {
        return this.nivelReserva;
    }
}
