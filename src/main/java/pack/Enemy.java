package pack;

import java.util.Random;

public class Enemy {

    private static int getRandom(int range) {
        Random r = new Random();
        return r.nextInt(range);
    }

    static void placeShips(String[][] table) {

        int gunboats = 0;
        int destroyers = 5;
        int cruisers = 2;
        int battleships = 5;

        int a = placeGunboats(gunboats, table);
        int b = placeDestroyers(destroyers, table);
        int c = placeCruisers(cruisers, table);
        int d = placeBattleships(battleships, table);

        System.out.println("Enemy has: " + a + " gunboat(s)");
        System.out.println("Enemy has: " + b + " destroyers(s)");
        System.out.println("Enemy has: " + c + " cruiser(s)");
        System.out.println("Enemy has: " + d + " battleship(s)");

    }

    static int placeGunboats(int howMany, String[][] table) {
        int amount = 0;
        for (int i = 0; i < howMany; i++) {
            int x = getRandom(10);
            int y = getRandom(10);

            if (table[x][y] == " ") {
                table[x][y] = "O";
                amount++;
            }
        }
        return amount;
    }

    static int placeDestroyers(int howMany, String[][] table) {
        int amount = 0;
        for (int i = 0; i < howMany; i++) {
            int x = getRandom(9);
            int y = getRandom(9);
            int rest = getRandom(2);

            if (
                    table[x][y] == " " &&
                            table[x + rest][y + 1 - rest] == " ") {
                table[x][y] = "O";
                table[x + rest][y + 1 - rest] = "O";
                amount++;
            }
        }
        return amount;
    }

    static int placeCruisers(int howMany, String[][] table) {
        int amount = 0;
        for (int i = 0; i < howMany; i++) {
            int x = getRandom(8);
            int y = getRandom(8);
            int rest = getRandom(2);

            if (
                    table[x][y] == " " &&
                            table[x + rest][y + 1 - rest] == " " &&
                            table[x + rest * 2][y + (1 - rest) * 2] == " ") {
                table[x][y] = "O";
                table[x + rest][y + 1 - rest] = "O";
                table[x + rest * 2][y + (1 - rest) * 2] = "O";
                amount++;
            }
        }
        return amount;
    }

    static int placeBattleships(int howMany, String[][] table) {
        int amount = 0;
        for (int i = 0; i < howMany; i++) {
            int x = getRandom(7);
            int y = getRandom(7);
            int rest = getRandom(2);

            if (
                    table[x][y] == " " &&
                            table[x + rest][y + 1 - rest] == " " &&
                            table[x + rest * 2][y + (1 - rest) * 2] == " " &&
                            table[x + rest * 3][y + (1 - rest) * 3] == " ") {
                table[x][y] = "O";
                table[x + rest][y + 1 - rest] = "O";
                table[x + rest * 2][y + (1 - rest) * 2] = "O";
                table[x + rest * 3][y + (1 - rest) * 3] = "O";
                amount++;
            }
        }
        return amount;
    }

}
