package pack;

import java.util.Scanner;

public class BattleshipsMain {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[][] my1 = new String[10][10];
        String[][] my2 = new String[10][10];
        String[][] enemy1 = new String[10][10];
        String[][] enemy2 = new String[10][10];
        String input;

        // usuwamoe nullów  z tablicy
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                my1[i][j] = " ";
                my2[i][j] = " ";
                enemy1[i][j] = " ";
                enemy2[i][j] = " ";
            }
        }

        Enemy.placeShips(enemy1);

        do {
            // wyświetalnie zawartości tablicy my1 i my2
            System.out.println("  |A |B |C |D |E |F |G |H |I |J         |A |B |C |D |E |F |G |H |I |J");
            for (int i = 0; i < 10; i++) {
                if (i < 9) {
                    System.out.print((i + 1) + " |");
                } else {
                    System.out.print((i + 1) + "|");
                }
                for (int j = 0; j < 10; j++) {
                    System.out.print(my1[i][j] + "  ");
                }
                System.out.print("     ");
                if (i < 9) {
                    System.out.print((i + 1) + " |");
                } else {
                    System.out.print((i + 1) + "|");
                }
                for (int j = 0; j < 10; j++) {
                    System.out.print(enemy1[i][j] + "  ");
                }

                System.out.println(" ");
            }

            input = scan.nextLine();
            int X = Input.getRow(input);
            int Y = Input.getColumn(input);

            if (X == 10 || Y == 10) {
                System.out.println("Incorrect coordinate!");
                break;
            }
            my1[X][Y] = "X";

        } while (!(input.equals("0")));
    }
}
