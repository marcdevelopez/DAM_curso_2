package com.marcdevelopez.lanzarmetododesdeproceso;

public class Sumador {

    /**
     * Este método suma todos los números que hay en un intervalo.
     *
     * @param numero1 Inicio del intervalo
     * @param numero2 Fin del intervalo
     * @return
     */
    public static int sumar(int numero1, int numero2) {
        int suma = 0;
        for (int i = numero1; i <= numero2; i++) {
            suma += i;
        }
        return suma;
    }

    public static void main(String[] args) {
        // obtenemos los argumentos pasados al crear el proceso
        int numero1 = Integer.valueOf(args[0]);
        int numero2 = Integer.valueOf(args[1]);

        // Utilizaremos la salida estándar para imprimir el resultado:
        System.out.println("La suma iterativa desde el número " + numero1
                + " hasta el número " + numero2 + " es: " 
                + sumar(numero1, numero2));
    }

}
