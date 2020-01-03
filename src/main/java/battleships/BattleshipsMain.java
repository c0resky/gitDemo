package battleships;

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
        Activities.placeShips(my1);
        Activities.placeShips(enemy1);
        Activities.displayGame(my1, my2, enemy1, enemy2);

        do {
            int accuracy = 0;
            do {
                input = scan.nextLine();
                int X = Activities.getRow(input);
                int Y = Activities.getColumn(input);
                if (X == 10 || Y == 10) {
                    System.out.println("Incorrect coordinate!");
                    break;
                }
                accuracy = Activities.playerFire(X, Y, my2, enemy1);
                Activities.displayGame(my1, my2, enemy1, enemy2);
            } while (accuracy != 0);

        } while (!(input.equals("0")));
    }
}
