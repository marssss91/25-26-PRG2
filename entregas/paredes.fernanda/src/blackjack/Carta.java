package blackjack;

public class Carta {
    private String valor;
    private String palo;

    public Carta(String valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public String getValor() {
        return valor;
    }

    public String getPalo() {
        return palo;
    }

    public int obtenerValor() {
        if (valor.equals("A")) {
            return 11;
        } else if (valor.equals("J") || valor.equals("Q") || valor.equals("K")) {
            return 10;
        } else {
            return Integer.parseInt(valor);
        }
    }

    public String obtenerSimbolo() {
        return switch (palo) {
            case "CORAZONES" -> "♥";
            case "DIAMANTES" -> "♦";
            case "TREBOLES" -> "♣";
            case "PICAS" -> "♠";
            default -> "";
        };
    }

    public String obtenerRepresentacion() {
        return "[" + valor + " " + obtenerSimbolo() + "]";
    }
}
