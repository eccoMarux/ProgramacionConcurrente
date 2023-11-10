package resumen;

public class Main {
    public static void main(String[] args) {
        RecursoCompartido recurso = new RecursoCompartido();
        int i = 0;
        
        while (i++ < 10) {
            Runable runnable = new Runable(recurso);
            Thread hilo = new Thread(runnable);
            hilo.start();
        }
    }
}
