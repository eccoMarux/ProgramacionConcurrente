class HiloSuma extends Thread {
    private int[] arreglo;
    private int inicio;
    private int fin;
    private int sumaParcial;
    private static int sumaTotal = 0;
    private static Object lock = new Object();

    public HiloSuma(int[] arreglo, int inicio, int fin) {
        this.arreglo = arreglo;
        this.inicio = inicio;
        this.fin = fin;
        this.sumaParcial = 0;
    }

    public int getSumaParcial() {
        return sumaParcial;
    }

    public static int getSumaTotal() {
        return sumaTotal;
    }

    @Override
    public void run() {
        for (int i = inicio; i < fin; i++) {
            sumaParcial += arreglo[i];
        }

        synchronized (lock) {
            sumaTotal += sumaParcial;
        }
    }
}