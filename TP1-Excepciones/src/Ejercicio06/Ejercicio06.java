package Ejercicio06;
public class Ejercicio06 {
    public static double acceso_por_indice(double[] v, int j) throws RuntimeException {
        try {
            /* 
            //Codigo Original
            if ((0 <= j) && (j <= v.length)) {
                return v[j];
            } else {
                throw new RuntimeException("El indice " + j + " no existe en el vector");
            }
            */

            //Codigo modificado
            if ((j < 0) || (j > v.length)) {
                throw new RuntimeException("El indice " + j + " no existe en el vector");
            }
            return v[j];
        } catch (RuntimeException exc) {
            throw exc;
        }
    }

    public static void main(String[] args) {
        double[] v = new double[15];
        acceso_por_indice(v, 16);
    }
}