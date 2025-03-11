package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ruletaRusa {

    private List<String> jugadores;
    private int posicionActual;
    private Random random;
    private int posicionBala;
    private int jugadorActual;

    public ruletaRusa() {
        this.jugadores = new ArrayList<>();
        this.posicionActual = posicionActual;
        this.random = new Random();
        this.posicionBala = posicionBala;
        this.jugadorActual = 0;
        nuevoAleatorio();
    }

    public List<String> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<String> jugadores) {
        this.jugadores = jugadores;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    public int getPosicionBala() {
        return posicionBala;
    }

    public void setPosicionBala(int posicionBala) {
        this.posicionBala = posicionBala;
    }

    public boolean disparar(){
        return posicionActual == posicionBala;
    }
    public void girarTambor(){
        this.posicionActual = random.nextInt(6);
    }
    public void siguienteJugador(){
        this.jugadorActual = (jugadorActual + 1) % jugadores.size();
    }

    public void nuevoAleatorio(){
        this.posicionBala = random.nextInt(6);
        this.posicionActual = random.nextInt(6);
        this.jugadorActual = 0;
    }
    public void agregarJugadores (int cantidad){
        if (jugadores == null){
            jugadores = new ArrayList<>();
        } else {
            jugadores.clear();
        }

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < cantidad; i++){
            System.out.println("Ingrese el nombre del jugador " + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            jugadores.add(nombre);
        }
    }
    public String getjugadorActual(){
        return jugadores.get(jugadorActual);
    }
}
