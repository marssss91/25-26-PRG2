package blackjack;

import java.util.Scanner;
import java.util.List;

public class Principal {
    private Juego juego;
    private Scanner scanner;
    private boolean ejecutando;
    private static final int OPCION_PEDIR = 1;
    private static final int OPCION_NUEVA_PARTIDA = 2;
    private static final int OPCION_SALIR = 3;

    public Principal() {
        this.juego = new Juego();
        this.scanner = new Scanner(System.in);
        this.ejecutando = true;
    }

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.ejecutar();
    }

    public void ejecutar() {
        System.out.println("=== Bienvenido al Blackjack ===\n");
        
        while (ejecutando) {
            juego.iniciarJuego();
            
            while (juego.estaJugando()) {
                mostrarMano();
                mostrarMenu();
                procesarOpcion(obtenerOpcion());
            }
            
            mostrarEstadoFinal();
            
            if (!pedirNuevaPartida()) {
                ejecutando = false;
            }
        }
        
        salir();
    }

    private void mostrarMenu() {
        System.out.println("--------------------");
        System.out.println("1. Pedir");
        System.out.println("2. Empezar de nuevo");
        System.out.println("3. Salir");
        System.out.println("--------------------");
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case OPCION_PEDIR -> pedirCarta();
            case OPCION_NUEVA_PARTIDA -> iniciarNuevaPartida();
            case OPCION_SALIR -> {
                ejecutando = false;
                juego.plantarse();
            }
            default -> System.out.println("Opción inválida");
        }
    }

    private void mostrarMano() {
        System.out.println("--------------------");
        System.out.print("Mano: ");
        List<Carta> mano = juego.obtenerMano();
        for (Carta carta : mano) {
            System.out.print(carta.obtenerRepresentacion());
        }
        System.out.println(" - Puntaje: " + juego.obtenerPuntuacion() + " ==> " + juego.obtenerEstado());
    }

    private void mostrarEstado() {
        System.out.println("Estado: " + juego.obtenerEstado());
    }

    private void mostrarEstadoFinal() {
        mostrarMano();
    }

    private void iniciarNuevaPartida() {
        juego.plantarse();
    }

    private void pedirCarta() {
        juego.pedirCarta();
    }

    private int obtenerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private boolean pedirNuevaPartida() {
        mostrarMenu();
        int opcion = obtenerOpcion();
        if (opcion == 2) {
            return true;
        } else if (opcion == 3) {
            return false;
        }
        return false;
    }

    private void salir() {
        System.out.println("¡Gracias por jugar!");
        scanner.close();
    }
}
