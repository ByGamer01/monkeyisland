package com.example.examen;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        // int numeroAleatorio = (int) (Math.random() * 50) + 1; Esta forma de hacer el numero aleatorio entre 1 y 50, ambos inclusive es bastante menos usada que un Random.

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int numeroAleatorio = random.nextInt(50) + 1; // El 50 no se incluye, por eso sumamos 1. Ya que hace del 0 al 49.

        System.out.println("Introduce un numero entre 1 y 50: ");

        // Indica si el numero es mas grande o mas pequeño que el numeroIntroducido
        for (int intentos = 6; intentos != 0; intentos--) { // Despues de cada intento, se resta 1 intento.
            int numeroIntroducido = sc.nextInt();

            if (numeroAleatorio > numeroIntroducido) {
                System.out.println("El numero es mayor que " + numeroIntroducido);
                System.out.println("Te quedan " + (intentos - 1) + " intentos.");
            } else if (numeroAleatorio < numeroIntroducido) {
                System.out.println("El numero es menor que " + numeroIntroducido);
                System.out.println("Te quedan " + (intentos - 1) + " intentos.");
            } else if ( numeroAleatorio == numeroIntroducido){
                System.out.println("¡Felicidades! Has adivinado el numero.");
                return; // Si acierta, se sale del bucle y por tanto del programa.
            }            
        }
        sc.close();
    }
}