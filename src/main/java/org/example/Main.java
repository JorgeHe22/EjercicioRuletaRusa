package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ruletaRusa ruleta = new ruletaRusa();
        boolean jugardeNuevo = true;

        while (jugardeNuevo){
            System.out.println("RULETA RUSA");
            System.out.println("Ingrese la cantidad de jugadores (2-6): ");

            int numerodeJugadores = 0;


            while (numerodeJugadores < 2 || numerodeJugadores > 6){
                try {
                    numerodeJugadores = Integer.parseInt(scanner.nextLine());       //intenta convertir una cadena de texto a entero
                    if(numerodeJugadores < 2 || numerodeJugadores > 6){
                        System.out.println("Numero invalido, debe estar entre 2 y 6 el numero de jugadores");
                    }
                }  catch (NumberFormatException e){                                 //es una excepción que ocurre cuando Integer.parseInt() no puede convertir el texto a un número
                    System.out.println("Por favor ingrese un numero valido");
                }
            }
            ruleta.agregarJugadores(numerodeJugadores);

            System.out.println("El juego ha empezado! El revolver solo tiene una bala");
            boolean juegoTerminado = false;

            while (!juegoTerminado){
                String jugadorActual = ruleta.getjugadorActual();
                System.out.println("\n Es el turno de " + jugadorActual);
                ruleta.girarTambor();
                System.out.println("Presione ENTER para disparar...");
                scanner.nextLine();

                boolean disparo = ruleta.disparar();
                int posicionBala = ruleta.getPosicionBala();
                int posicionActual = ruleta.getPosicionActual();

                if (disparo){
                    System.out.println("BANG!💥" + jugadorActual + " Recibio el disparo");
                    System.out.println("Las posiciones han coincidido Posicion: " + posicionActual + ". Posicion de la bala: " + posicionBala);
                    System.out.println("Juego terminado.");
                    juegoTerminado = true;
                } else {
                    System.out.println("El revolver no disparó. " + jugadorActual + " ha sobrevivido");
                    System.out.println("Las posiciones no coincidieron Posicion: " + posicionActual + ". Posicion de la bala: " + posicionBala);
                    ruleta.siguienteJugador();
                }
            }
            System.out.println("¿Desea jugar nuevamente? si/no");
            String respuesta = scanner.nextLine();
            jugardeNuevo = respuesta.equalsIgnoreCase("Si");

            if(jugardeNuevo){
                ruleta.nuevoAleatorio();
            }

        }

        System.out.println("Juego terminado");
        scanner.close();


    }


}