package pack;

import java.util.Scanner;

public class BattleshipsMain {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[][] my1 = new String[10][10];
        String[][] my2 = new String[10][10];
        String[][] enemy1 = new String[10][10];
        String[][] enemy2 = new String[10][10];

        // usuwamoe nullów  z tablicy
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                my1[i][j] = "O";
            }
        }

        String input = "start";

        do {
            // wyświetalnie zawartości tablicy my1
            System.out.println("  |A |B |C |D |E |F |G |H |I |J");
            for (int i = 0; i < 10; i++) {
                if (i < 9) {
                    System.out.print((i + 1) + " |");
                } else {
                    System.out.print((i + 1) + "|");
                }
                for (int j = 0; j < 10; j++) {
                    System.out.print(my1[i][j] + "  ");
                }
                System.out.println(" ");
            }

            input = scan.nextLine();
            int X = Input.getColumn(input);

            // czyszczenie ekranu
            clearScreen();

        } while (!(input.equals("0")));

    }

    public static void clearScreen() {

        // ten void czysci wyłącznie okienko w konsoli. Okienko w Intellij nie zostanie wyczyszczone

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
