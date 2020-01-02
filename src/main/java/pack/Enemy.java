package pack;

import java.util.Random;

public class Enemy {

    private static int getRandom(int range) {
        Random r = new Random();
        return r.nextInt(range);
    }

    static void placeShips(String[][] table) {

        int gunboats = 4;
        int destroyers = 3;
        int cruisers = 2;
        int battleships = 1;
        int a, b, c, d;

        do {
            // czyszczenie tablicy wejsciowej
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 12; j++) {
                    table[i][j] = " ";
                }
            }
            a = placeGunboats(gunboats, table);
            b = placeDestroyers(destroyers, table);
            c = placeCruisers(cruisers, table);
            d = placeBattleships(battleships, table);
        } while (a != gunboats || b != destroyers || c != cruisers || d != battleships);

        System.out.println("Enemy has: " + a + " gunboat(s)");
        System.out.println("Enemy has: " + b + " destroyers(s)");
        System.out.println("Enemy has: " + c + " cruiser(s)");
        System.out.println("Enemy has: " + d + " battleship(s)");

    }

    static int placeGunboats(int howMany, String[][] table) {
        int amount = 0;
        for (int i = 0; i < howMany; i++) {
            int x = getRandom(10) + 1;
            int y = getRandom(10) + 1;

            if (table[x][y] == " ") {
                table[x][y] = "O";
                table[x - 1][y] = ".";
                table[x + 1][y] = ".";
                table[x][y - 1] = ".";
                table[x][y + 1] = ".";
                table[x - 1][y - 1] = ".";
                table[x - 1][y + 1] = ".";
                table[x + 1][y - 1] = ".";
                table[x + 1][y + 1] = ".";
                amount++;
            }
        }
        return amount;
    }

    static int placeDestroyers(int howMany, String[][] table) {
        int amount = 0;
        for (int i = 0; i < howMany; i++) {
            int x = getRandom(9) + 1;
            int y = getRandom(9) + 1;
            int rest = getRandom(2);

            if (
                    table[x][y] == " " && table[x + rest][y + 1 - rest] == " ") {
                table[x][y] = "O";
                table[x + rest][y + 1 - rest] = "O";
                table[x - rest][y - 1 + rest] = "."; // po lewej lub powyżej
                table[x + 1 - rest][y + rest] = "."; // prawa lub dół
                table[x - 1 + rest][y - rest] = "."; // lewa lub góra
                table[x + 2 * rest][y - 2 * rest + 2] = "."; // koniec
                table[x + 1][y + 1] = "."; // prawy dół
                table[x + 1][y - 1] = ".";  // lewy dół
                table[x - 1][y + 1] = "."; // prawa góra
                table[x - 1][y - 1] = "."; // lewa góra
                table[x + rest + 1][y - rest + 2] = "."; // prawy dół koniec
                table[x + 3 * rest - 1][y - 3 * rest + 2] = "."; // lewa lub góra koniec
                amount++;
            }
        }
        return amount;
    }

    static int placeCruisers(int howMany, String[][] table) {
        int amount = 0;
        for (int i = 0; i < howMany; i++) {
            int x = getRandom(8) + 1;
            int y = getRandom(8) + 1;
            int rest = getRandom(2);

            if (
                    table[x][y] == " " &&
                            table[x + rest][y + 1 - rest] == " " &&
                            table[x + rest * 2][y + (1 - rest) * 2] == " "
            ) {
                table[x][y] = "O";
                table[x + rest][y + 1 - rest] = "O";
                table[x + rest * 2][y + (1 - rest) * 2] = "O";
                table[x - rest][y - 1 + rest] = "."; // po lewej lub powyżej
                table[x + 1 - rest][y + rest] = "."; // prawa lub dół
                table[x - 1 + rest][y - rest] = "."; // lewa lub góra
                table[x + 3 * rest][y - 3 * rest + 3] = "."; // koniec
                table[x + 1][y + 1] = "."; // prawy dół
                table[x + 1][y - 1] = ".";  // lewy dół
                table[x - 1][y + 1] = "."; // prawa góra
                table[x - 1][y - 1] = "."; // lewa góra
                table[x + rest + 1][y - rest + 2] = "."; // prawy dół 3
                table[x + 3 * rest - 1][y - 3 * rest + 2] = "."; // lewa lub góra 3
                table[x + 2 * rest + 1][y - 2 * rest + 3] = "."; // prawy dół koniec
                table[x + 4 * rest - 1][y - 4 * rest + 3] = "."; // lewa lub góra koniec
                amount++;
            }
        }
        return amount;
    }

    static int placeBattleships(int howMany, String[][] table) {
        int amount = 0;
        for (int i = 0; i < howMany; i++) {
            int x = getRandom(7) + 1;
            int y = getRandom(7) + 1;
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
                table[x - rest][y - 1 + rest] = "."; // po lewej lub powyżej
                table[x + 1 - rest][y + rest] = "."; // prawa lub dół
                table[x - 1 + rest][y - rest] = "."; // lewa lub góra
                table[x + 4 * rest][y - 4 * rest + 4] = "."; // koniec
                table[x + 1][y + 1] = "."; // prawy dół
                table[x + 1][y - 1] = ".";  // lewy dół
                table[x - 1][y + 1] = "."; // prawa góra
                table[x - 1][y - 1] = "."; // lewa góra
                table[x + rest + 1][y - rest + 2] = "."; // prawy dół 3
                table[x + 3 * rest - 1][y - 3 * rest + 2] = "."; // lewa lub góra 3
                table[x + 2 * rest + 1][y - 2 * rest + 3] = "."; // prawy dół 4
                table[x + 4 * rest - 1][y - 4 * rest + 3] = "."; // lewa lub góra 4
                table[x + 3 * rest + 1][y - 3 * rest + 4] = "."; // prawy dół koniec
                table[x + 5 * rest - 1][y - 5 * rest + 4] = "."; // lewa lub góra koniec
                amount++;
            }
        }
        return amount;
    }

}
