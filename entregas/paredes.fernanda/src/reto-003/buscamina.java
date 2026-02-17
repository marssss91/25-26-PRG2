import java.util.Scanner;

public class Buscaminas {
    public static void main(String[] args) {
        int minas = 0;
        int celdasVacias = 0;
        int filaA = 0;
        int columnaB = 0;
        int filaX = 0;
        int columnaY = 0;
        boolean salida = false;

        String[][] tableroOculto = new String[6][8];

        tableroOculto[0][0] = "**"; tableroOculto[0][1] = " 1"; tableroOculto[0][2] = " 2"; tableroOculto[0][3] = " 3"; tableroOculto[0][4] = " 4"; tableroOculto[0][5] = " 5"; tableroOculto[0][6] = " 6"; tableroOculto[0][7] = " 7";
        tableroOculto[1][0] = " 1"; tableroOculto[1][1] = "  "; tableroOculto[1][2] = "  "; tableroOculto[1][3] = "  "; tableroOculto[1][4] = "  "; tableroOculto[1][5] = "  "; tableroOculto[1][6] = "  "; tableroOculto[1][7] = "  ";
        tableroOculto[2][0] = " 2"; tableroOculto[2][1] = "  "; tableroOculto[2][2] = "  "; tableroOculto[2][3] = "  "; tableroOculto[2][4] = "  "; tableroOculto[2][5] = "  "; tableroOculto[2][6] = "  "; tableroOculto[2][7] = "  ";
        tableroOculto[3][0] = " 3"; tableroOculto[3][1] = "  "; tableroOculto[3][2] = "  "; tableroOculto[3][3] = "  "; tableroOculto[3][4] = "  "; tableroOculto[3][5] = "  "; tableroOculto[3][6] = "  "; tableroOculto[3][7] = "  ";
        tableroOculto[4][0] = " 4"; tableroOculto[4][1] = "  "; tableroOculto[4][2] = "  "; tableroOculto[4][3] = "  "; tableroOculto[4][4] = "  "; tableroOculto[4][5] = "  "; tableroOculto[4][6] = "  "; tableroOculto[4][7] = "  ";
        tableroOculto[5][0] = " 5"; tableroOculto[5][1] = "  "; tableroOculto[5][2] = "  "; tableroOculto[5][3] = "  "; tableroOculto[5][4] = "  "; tableroOculto[5][5] = "  "; tableroOculto[5][6] = "  "; tableroOculto[5][7] = "  ";

        String[][] tableroVisible = new String[6][8];

        tableroVisible[0][0] = "**"; tableroVisible[0][1] = " 1"; tableroVisible[0][2] = " 2"; tableroVisible[0][3] = " 3"; tableroVisible[0][4] = " 4"; tableroVisible[0][5] = " 5"; tableroVisible[0][6] = " 6"; tableroVisible[0][7] = " 7";
        tableroVisible[1][0] = " 1"; tableroVisible[1][1] = "  "; tableroVisible[1][2] = "  "; tableroVisible[1][3] = "  "; tableroVisible[1][4] = "  "; tableroVisible[1][5] = "  "; tableroVisible[1][6] = "  "; tableroVisible[1][7] = "  ";
        tableroVisible[2][0] = " 2"; tableroVisible[2][1] = "  "; tableroVisible[2][2] = "  "; tableroVisible[2][3] = "  "; tableroVisible[2][4] = "  "; tableroVisible[2][5] = "  "; tableroVisible[2][6] = "  "; tableroVisible[2][7] = "  ";
        tableroVisible[3][0] = " 3"; tableroVisible[3][1] = "  "; tableroVisible[3][2] = "  "; tableroVisible[3][3] = "  "; tableroVisible[3][4] = "  "; tableroVisible[3][5] = "  "; tableroVisible[3][6] = "  "; tableroVisible[3][7] = "  ";
        tableroVisible[4][0] = " 4"; tableroVisible[4][1] = "  "; tableroVisible[4][2] = "  "; tableroVisible[4][3] = "  "; tableroVisible[4][4] = "  "; tableroVisible[4][5] = "  "; tableroVisible[4][6] = "  "; tableroVisible[4][7] = "  ";
        tableroVisible[5][0] = " 5"; tableroVisible[5][1] = "  "; tableroVisible[5][2] = "  "; tableroVisible[5][3] = "  "; tableroVisible[5][4] = "  "; tableroVisible[5][5] = "  "; tableroVisible[5][6] = "  "; tableroVisible[5][7] = "  ";

        filaA = (int)((Math.random() * 5) + 1);
        columnaB = (int)((Math.random() * 7) + 1);
        for (int x = 1; x < tableroOculto.length; x++) {
            for (int y = 1; y < 8; y++) {
                tableroOculto[filaA][columnaB] = "MM";
            }
        }

        filaA = (int)((Math.random() * 5) + 1);
        columnaB = (int)((Math.random() * 7) + 1);
        for (int x = 1; x < tableroOculto.length; x++) {
            for (int y = 1; y < 8; y++) {
                tableroOculto[filaA][columnaB] = "MM";
            }
        }

        filaA = (int)((Math.random() * 5) + 1);
        columnaB = (int)((Math.random() * 7) + 1);
        for (int x = 1; x < tableroOculto.length; x++) {
            for (int y = 1; y < 8; y++) {
                tableroOculto[filaA][columnaB] = "MM";
            }
        }

        filaA = (int)((Math.random() * 5) + 1);
        columnaB = (int)((Math.random() * 7) + 1);
        for (int x = 1; x < tableroOculto.length; x++) {
            for (int y = 1; y < 8; y++) {
                tableroOculto[filaA][columnaB] = "MM";
            }
        }

        filaA = (int)((Math.random() * 5) + 1);
        columnaB = (int)((Math.random() * 7) + 1);
        for (int x = 1; x < tableroOculto.length; x++) {
            for (int y = 1; y < 8; y++) {
                tableroOculto[filaA][columnaB] = "MM";
            }
        }

        while (!salida) {
            for (int x = 0; x < tableroVisible.length; x++) {
                System.out.print("|");
                for (int y = 0; y < 8; y++) {
                    System.out.print(tableroVisible[x][y]);
                }
                System.out.println("|");
            }

            System.out.println("introduzca posicion X");
            Scanner sc = new Scanner(System.in);
            filaX = sc.nextInt();

            System.out.println("Introduzca posicion Y");
            Scanner sc2 = new Scanner(System.in);
            columnaY = sc.nextInt();

            if ((tableroOculto[filaX][columnaY]) == "  ") {
                tableroVisible[filaX][columnaY] = "--";
                celdasVacias++;
            } else {
                tableroVisible[filaX][columnaY] = "**";
                minas++;
            }

            for (int x = 0; x < tableroVisible.length; x++) {
                System.out.print("|");
                for (int y = 0; y < 8; y++) {
                    System.out.print(tableroVisible[x][y]);
                }
                System.out.println("|");
            }

            if (minas == 3) {
                System.out.println("Lo siento, ha perdido");
                salida = true;
            }

            if (celdasVacias == 30) {
                System.out.println("Enhorabuena, ha ganado");
                salida = true;
            }
        }
    }
}