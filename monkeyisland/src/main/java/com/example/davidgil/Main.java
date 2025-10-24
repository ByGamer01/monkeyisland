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

        int[] ordenRespuestas = { 0, 1, 2, 3 }; // array de indices, para mezclar el orden de las respuestas

        int puntuacion = 3; // puntuacion = vidas

        // respuestasInsultos y respuestasPiratas tienen el mismo indice correcto. Los
        // insultosPiratas son random cada ronda,
        // Y el orden de las respuestas (1 correcta y 2 incorrectas) es tambien random.
        Random random = new Random(); // Para saber que insulto tocará
        Scanner sc = new Scanner(System.in);

        // Asignamos la respuesta correcta al insulto correspondiente
        // Siempre pondremos la respuesta correcta en la respuesta 1, y las incorrectas
        // en la 2 y 3; y luego las mezclaremos.

        System.out.println("----------------------- ╬ MONKEY ISLAND ╬ --------------------");
        System.out.println();
        System.out.println();
        System.out.println(
                " Ø ¡Bienvenido Aventurero! Ø\n\n  ¤ El juego consiste en sobrevivir a los insultos de los piratas. \n Responde correctamente para ganar puntos y avanzar de ronda. \n Pero cuidado, si fallas perderás puntos. ¤ \n\n £ Si te quedas sin puntos, solo te esperará la muerte, piratilla! £ \n\n ▓ ¡Buena suerte! ▓ ");
        System.out.println(" ® ¿Cuantas rondas quieres jugar? ® ");

        boolean[] insultosUsados = new boolean[insultosPiratas.length]; // Array para rastrear insultos usados
        int rondasJuegoJugadas = 0;
        int rondasJuegoUsuario = sc.nextInt(); // Numero de rondas que quiere jugar el usuario

        while (rondasJuegoJugadas < rondasJuegoUsuario && rondasJuegoJugadas < insultosPiratas.length) { // Mientras no
                                                                                                         // se hayan
                                                                                                         // jugado todas
                                                                                                         // las rondas
            rondasJuegoJugadas++; // Aumentamos las rondas jugadas
            System.out.println(
                    " ® Has avanzado a la ronda ® " + rondasJuegoJugadas + "\n\n ¤ Puntuación: ¤ " + puntuacion);

            for (int indiceSecundario = 0; indiceSecundario < insultosPiratas.length; indiceSecundario++) {
                // Elegir insulto aleatorio que no se haya usado
                int indiceInsulto = random.nextInt(insultosPiratas.length);
                while (insultosUsados[indiceInsulto]) {
                    indiceInsulto = random.nextInt(insultosPiratas.length);
                }
                insultosUsados[indiceInsulto] = true; // Marcamos el insulto como usado

                // Preguntas (insultosPiratas)

                int indicePrincipal = random.nextInt(insultosPiratas.length); // Elegimos un insulto aleatorio
                System.out.println("\n Ø El pirata te dice: Ø " + insultosPiratas[indicePrincipal]);

                // Le restamos el insulto que ha salido de los piratas, para no repetirla.
                insultosPiratas[insultosPiratas.length - 1] = insultosPiratas[indicePrincipal];

                // Preguntamos la respuesta al usuario
                System.out.println(
                        " ¤ Recuerda: Solo una respuesta es correcta. ¤ \n\n ╬ Elige tu respuesta entre estas tres: ╬ ");

                // Mezclamos el orden de las respuestas, mediante nuestro array ordenRespuestas
                for (int orden = 0; orden < ordenRespuestas.length; orden++) {
                    int indiceOrdenRespuestas = random.nextInt(ordenRespuestas.length); // random del tamaño del array

                    // guardamos el valor temporalmente, para barajarlo
                    int temp = ordenRespuestas[orden];
                    ordenRespuestas[orden] = ordenRespuestas[indiceOrdenRespuestas];
                    ordenRespuestas[indiceOrdenRespuestas] = temp;
                }

                // Mostramos las respuestas, y guardamos la respuesta del usuario (1 correcta y
                // 2 incorrectas).
                System.out.println("\n1. " + respuestasInsultos[indicePrincipal] + "\n2. "
                        + respuestasInsultosIncorrectas[indiceSecundario] + "\n3. "
                        + respuestasInsultosIncorrectas[(indiceSecundario + 1) % respuestasInsultosIncorrectas.length]
                        + "\n4. "
                        + respuestasInsultosIncorrectas[(indiceSecundario + 2) % respuestasInsultosIncorrectas.length]);

                // Guardamos la respuesta del usuario
                int respuestaUsuario = sc.nextInt();

                // Comprobamos si la respuesta es correcta (if) o boolean

            }
        }
    }
}