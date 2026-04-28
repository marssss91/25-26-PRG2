import java.util.Random;

public class Carrera {
    private static final int LONGITUD_PISTA = 40;
    private static final int CANTIDAD_CABALLOS = 2;
    private Caballo[] caballos;
    private int turno;
    private Random random;

    public Carrera() {
        this(CANTIDAD_CABALLOS);
    }

    public Carrera(int cantidadCaballos) {
        this.caballos = new Caballo[cantidadCaballos];
        this.turno = 0;
        this.random = new Random();
        inicializarCaballos();
    }

    private void inicializarCaballos() {
        for (int i = 0; i < caballos.length; i++) {
            caballos[i] = new Caballo("Caballo " + (i + 1));
        }
    }

    public void jugar() {
        mostrarInicio();
        while (!hayGanador()) {
            avanzarTurno();
            mostrarEstado();
        }
        mostrarGanador();
    }

    private void avanzarTurno() {
        turno++;
        int caballoActual = random.nextInt(caballos.length);
        int avance = random.nextInt(3);
        caballos[caballoActual].avanzar(avance);
    }

    private boolean hayGanador() {
        for (Caballo caballo : caballos) {
            if (caballo.llegadaAlFinal(LONGITUD_PISTA)) {
                return true;
            }
        }
        return false;
    }

    private void mostrarInicio() {
        System.out.println("=== COMIENZA LA CARRERA DE CABALLOS ===\n");
    }

    private void mostrarEstado() {
        System.out.println("--- Turno " + turno + " ---");
        for (Caballo caballo : caballos) {
            dibujarPista(caballo);
        }
        System.out.println();
    }

    private void dibujarPista(Caballo caballo) {
        System.out.print(caballo.getNombre() + ": ");
        dibujarPosicion(caballo.getPosicion());
        System.out.println(";-;'");
    }

    private void dibujarPosicion(int posicion) {
        for (int i = 0; i < posicion; i++) {
            System.out.print(" ");
        }
    }

    private void mostrarGanador() {
        System.out.println("=== FIN DE LA CARRERA ===");
        for (int i = 0; i < caballos.length; i++) {
            if (caballos[i].llegadaAlFinal(LONGITUD_PISTA)) {
                System.out.println("¡Ganó el caballo " + (i + 1) + "!");
            }
        }
    }

    public Caballo[] getCaballos() {
        return caballos;
    }

    public int getTurno() {
        return turno;
    }
}
