package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    private Baraja baraja;
    private List<Carta> manoJugador;
    private int puntuacion;
    private boolean jugando;
    private String estado;

    public Juego() {
        this.baraja = new Baraja();
        this.manoJugador = new ArrayList<>();
        this.puntuacion = 0;
        this.jugando = false;
        this.estado = "";
    }

    public void iniciarJuego() {
        baraja.inicializarBaraja();
        manoJugador.clear();
        repartirDosCartas();
        puntuacion = calcularPuntuacion();
        actualizarEstado();
        jugando = true;
    }

    public void pedirCarta() {
        if (jugando) {
            Carta carta = baraja.sacarCarta();
            if (carta != null) {
                manoJugador.add(carta);
                puntuacion = calcularPuntuacion();
                actualizarEstado();
            }
        }
    }

    public void plantarse() {
        jugando = false;
        estado = "Plantado";
    }

    public int calcularPuntuacion() {
        int puntos = 0;
        int ases = 0;

        for (Carta carta : manoJugador) {
            if (carta.getValor().equals("A")) {
                ases++;
                puntos += 11;
            } else {
                puntos += carta.obtenerValor();
            }
        }

        while (puntos > 21 && ases > 0) {
            puntos -= 10;
            ases--;
        }

        return puntos;
    }

    public List<Carta> obtenerMano() {
        return new ArrayList<>(manoJugador);
    }

    public int obtenerPuntuacion() {
        return puntuacion;
    }

    public boolean estaJugando() {
        return jugando;
    }

    public String obtenerEstado() {
        return estado;
    }

    private void repartirDosCartas() {
        manoJugador.add(baraja.sacarCarta());
        manoJugador.add(baraja.sacarCarta());
    }

    private void actualizarEstado() {
        if (puntuacion > 21) {
            estado = "Perdió";
            jugando = false;
        } else if (puntuacion == 21 && manoJugador.size() == 2) {
            estado = "Ganó";
            jugando = false;
        } else {
            estado = "Sigue jugando";
        }
    }
