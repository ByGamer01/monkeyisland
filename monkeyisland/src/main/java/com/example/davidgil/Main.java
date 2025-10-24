// David Gil Rosa;
// 48782911A
// Monkey Island - Juego de insultos piratas



package com.example.davidgil;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String[] insultosPiratas = { "¿Has dejado ya de usar pañales?",
                "¿Conoces alguna isla desierta donde esconderte?", "Eres tan inutil, grumete!",
                "¿Por qué no te subes a un barril y te lanzas al mar?",
                "¿Acaso crees que puedes con un verdadero pirata?", "¿Te gustaría ser mi aprendiz de pirata?",
                "¿Por qué no te vas a buscar un tesoro en vez de molestarme?",
                "¿Acaso piensas que eres más listo que yo?",
                "¿Por qué no te largas de mi barco, inútil?"
        };

        String[] respuestasInsultos = { "¿Por qué? ¿Acaso querías pedir uno prestado?",
                "No, pero seguro que tú conoces alguna.",
                "Espero que ya hayas aprendido a tocarte la nariz.", "Buena idea, así me libraría de ti.",
                "Claro que no, pero al menos lo intento.",
                "No gracias, ya tengo suficiente con un aprendiz inútil como tú.",
                "Porque no eres más que un lastre para mi tripulación.",
                "No, pero tú pareces creerlo.", "Porque eres un estorbo en mi barco."
        };
        String[] respuestasInsultosIncorrectas = { "No, pero seguro que tú conoces alguna.",
                "Espero que ya hayas aprendido a tocarte la nariz.", "Buena idea, así me libraría de ti.",
                "Claro que no, pero al menos lo intento.",
                "No gracias, ya tengo suficiente con un aprendiz inútil como tú.",
                "Porque no eres más que un lastre para mi tripulación.",
                "No, pero tú pareces creerlo.", "Porque eres un estorbo en mi barco.",
                "¿Por qué? ¿Acaso querías pedir uno prestado?"
        };

        int puntuacion = 0;
        int vidas = 3;
        int rondasMaximas = insultosPiratas.length;
        boolean jugando = true;


        // respuestasInsultos y respuestasPiratas tienen el mismo indice correcto. Los
        // insultosPiratas son random cada ronda,
        // Y el orden de las respuestas (1 correcta y 2 incorrectas) es tambien random.
        Random random = new Random(); // Para saber que insulto tocará
        Scanner sc = new Scanner(System.in);

        System.out.println("----------------------- ╬ MONKEY ISLAND ╬ --------------------");
        System.out.println();
        System.out.println("\n\n Ø ¡Bienvenido Aventurero! Ø\n\n ¤ El juego consiste en sobrevivir a los insultos de los piratas. \n Responde correctamente para ganar puntos y avanzar de ronda. \n Unicamente podrás elegir entre cuatro opciones (una única correcta y tres incorrectas). \n Pero cuidado, si fallas perderás vidas y puntos. ¤ \n\n æ Para salir, escribe un 5 al momento de poner una respuesta al insulto del pirata. æ \n\n £ Si te quedas sin vidas, solo te esperará la muerte, piratilla! £ \n\n ▓ ¡Buena suerte! ▓ ");

        // Para evitar repetir insultos en la misma ronda (apartado do - while)
        boolean[] insultosUsados = new boolean[insultosPiratas.length];
        int rondasJuegoJugadas = 0;

        System.out.println(" ® ¿Cuantas rondas quieres jugar? ® ");
        int rondasJuegoUsuario = sc.nextInt();

        if (rondasJuegoUsuario > rondasMaximas) {
            rondasJuegoUsuario = rondasMaximas;
            System.out.println(" Ø Has seleccionado más rondas de las disponibles. El juego se ajustará a " + rondasMaximas + " rondas. Ø ");
        }

        while (jugando && (rondasJuegoJugadas < rondasJuegoUsuario || rondasMaximas < rondasJuegoUsuario)) { // Mientras no se hayan jugado todas las rondas
            rondasJuegoJugadas++; // Aumentamos las rondas jugadas
            System.out.println(" ® Has avanzado a la ronda ® " + rondasJuegoJugadas + "\n\n ¤ Vidas: ¤ " + vidas + "\n ¤ Puntuación: ¤ " + puntuacion);

            int insultoAleatorioNoUsado;
            do { // Bucle para asegurarnos de que el insulto no se ha usado ya (no se repite en
                 // la misma ronda)
                insultoAleatorioNoUsado = random.nextInt(insultosPiratas.length);
            } while (insultosUsados[insultoAleatorioNoUsado]);
            insultosUsados[insultoAleatorioNoUsado] = true;

            System.out.println("\n Ø El pirata te dice: " + insultosPiratas[insultoAleatorioNoUsado] + " Ø \n");

            // Utilizamos un FOR para mezclar las repuestas, y sus posiciones. (Sé que es mejor un Switch...)
            String[] opciones = new String[4]; // de 0 a 3. (posiciones)
            opciones[0] = respuestasInsultos[insultoAleatorioNoUsado];

            for (int i = 1; i < 4; i++) {
                int insulto;
                boolean repetido;
                do {
                    insulto = random.nextInt(respuestasInsultosIncorrectas.length);
                    repetido = false;
                    for (int j = 0; j < i; j++) {
                        if (opciones[j].equals(respuestasInsultosIncorrectas[insulto])) {
                            repetido = true;
                            break;
                        }
                    }
                } while (repetido);
                opciones[i] = respuestasInsultosIncorrectas[insulto];
            }

            // Mezclamos las opciones (yo lo llamo reloj, ya que se van intercambiando
            // valores)
            for (int i = 0; i < opciones.length; i++) {
                int j = random.nextInt(opciones.length);
                String temp = opciones[i];
                opciones[i] = opciones[j];
                opciones[j] = temp;
            }

            // Preguntamos la respuesta al usuario
            System.out.println(" ¤ Recuerda: Solo una respuesta es correcta. ¤ \n\n ╬ Elige tu respuesta entre estas cuatro: ╬ ");

            // Mostramos las respuestas (1 correcta y 2 incorrectas).
            for (int i = 0; i < opciones.length; i++) {
                // 0 + 1, 1 + 1, 2+ 1, ... asi sucesivamente hasta completar las posiciones que
                // hay en el array de opciones
                System.out.println((i + 1) + ". " + opciones[i]); // imprime ↕
            }

            System.out.println("\n ® Escribe el número de la respuesta correcta: ® ");

            // Guardamos la respuesta del usuario
            int respuestaUsuario = sc.nextInt();
            
            // Evaluamos la respuesta del usuario + Si  pone un 5, sale del juego
            switch (respuestaUsuario) {
                case 1:
                case 2:
                case 3:
                case 4:
                    if (opciones[respuestaUsuario - 1].equals(respuestasInsultos[insultoAleatorioNoUsado])) {
                        System.out.println("\n\n ® Acertaste! ¡Bien hecho, piratilla! ® \n");
                        if (vidas == 3) {
                            vidas = vidas + 0;
                        }
                        puntuacion = puntuacion + 3;
                    } else {
                        System.out.println("\n\n Ø Has fallado! La respuesta correcta era: Ø " + respuestasInsultos[insultoAleatorioNoUsado] + "\n");
                        vidas = vidas - 1;
                        puntuacion = puntuacion - 2;
                        System.out.println("Te quedan: " + vidas + " vidas." );
                        if (vidas == 0) {
                            System.out.println(" ☠ Has perdido todas tus vidas, piratilla! ☠ \n\n ¤ Tu puntuación final es: ¤ " + puntuacion + "\n\n ▓ ¡GAME OVER! ▓ ");
                            jugando = false;
                        }
                    }
                    System.out.println(" ----------------------------------------------------- ");
                    break;
                case 5: // Salir
                    System.out.println("\n\n ¤ Has decidido salir del juego. ¤ \n\n ▓ ¡Hasta la próxima, piratilla! ▓ ");
                    System.out.println(" ¤ Tu puntuación final es: ¤ " + puntuacion + "\n"  + " vidas restantes: ¤ " + vidas);
                    jugando = false;
                    break;                  
            }
        }
        if (puntuacion == 27) {
            System.out.print("\n\n ¤ ¡Felicidades, eres el dios de los piratas! ¤ \n\n");
        } else if (puntuacion >= 20 && puntuacion < 27) {
            System.out.print("\n\n ¤ ¡Eres un rey pirata! Casi perfecto. ¤ \n\n");
        } else if (puntuacion >= 15 && puntuacion < 20) {
            System.out.print("\n\n ¤ ¡Buen trabajo, piratilla! Pero aún te queda mucho por aprender. ¤ \n\n");
        } else {
            System.out.print("\n\n ¤ ¡Los loros se rien de ti! ¡Sigue practicando! ¤ \n\n");

        }
        sc.close();
    }
}