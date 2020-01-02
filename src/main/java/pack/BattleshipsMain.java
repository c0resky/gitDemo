package pack;

import java.util.Scanner;

public class BattleshipsMain {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[][] my1 = new String[12][12];
        String[][] my2 = new String[12][12];
        String[][] enemy1 = new String[12][12];
        String[][] enemy2 = new String[12][12];
        String input;

        // usuwamoe nullów  z tablicy
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
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
            for (int i = 1; i < 11; i++) {
                if (i < 10) {
                    System.out.print((i) + " |");
                } else {
                    System.out.print((i) + "|");
                }
                for (int j = 1; j < 11; j++) {
                    System.out.print(my1[i][j] + "  ");
                }
                System.out.print("     ");
                if (i < 10) {
                    System.out.print((i) + " |");
                } else {
                    System.out.print((i) + "|");
                }
                for (int j = 1; j < 11; j++) {
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
            my1[X + 1][Y + 1] = "X";

        } while (!(input.equals("0")));
    }
}
