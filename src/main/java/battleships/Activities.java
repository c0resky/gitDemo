package battleships;

import java.util.Random;

public class Activities {

    static void displayGame(String[][] my1, String[][] my2, String[][] enemy1, String[][] enemy2) {

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
                System.out.print(my2[i][j] + "  ");
            }

            System.out.println(" ");
        }
        System.out.println();
//        System.out.println("  |A |B |C |D |E |F |G |H |I |J         |A |B |C |D |E |F |G |H |I |J");
//        for (int i = 1; i < 11; i++) {
//            if (i < 10) {
//                System.out.print((i) + " |");
//            } else {
//                System.out.print((i) + "|");
//            }
//            for (int j = 1; j < 11; j++) {
//                System.out.print(enemy1[i][j] + "  ");
//            }
//            System.out.print("     ");
//            if (i < 10) {
//                System.out.print((i) + " |");
//            } else {
//                System.out.print((i) + "|");
//            }
//            for (int j = 1; j < 11; j++) {
//                System.out.print(enemy2[i][j] + "  ");
//            }
//
//            System.out.println(" ");
//        }
    }

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

        System.out.println("Deploying: " + a + " gunboat(s)");
        System.out.println("Deploying: " + b + " destroyers(s)");
        System.out.println("Deploying: " + c + " cruiser(s)");
        System.out.println("Deploying: " + d + " battleship(s)");

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

    static int getRow(String coordinate) {

        if (coordinate.isEmpty()) {
            return 10;
        } else if (coordinate.length() < 2) {
            return 10;
        } else if (String.valueOf(coordinate.charAt(1)).equals("1") && coordinate.length() > 2 && String.valueOf(coordinate.charAt(2)).equals("0")) {
            return 9;
        } else {
            coordinate = String.valueOf(coordinate.charAt(1));
            return Integer.parseInt(coordinate) - 1;
        }
    }

    static int getColumn(String coordinate) {
        coordinate = coordinate.toLowerCase();
        if (coordinate.isEmpty()) {
            return 10;
        }

        coordinate = String.valueOf(coordinate.charAt(0));
        if (coordinate.equals("a")) {
            return 0;
        } else if (coordinate.equals("b")) {
            return 1;
        } else if (coordinate.equals("c")) {
            return 2;
        } else if (coordinate.equals("d")) {
            return 3;
        } else if (coordinate.equals("e")) {
            return 4;
        } else if (coordinate.equals("f")) {
            return 5;
        } else if (coordinate.equals("g")) {
            return 6;
        } else if (coordinate.equals("h")) {
            return 7;
        } else if (coordinate.equals("i")) {
            return 8;
        } else if (coordinate.equals("j")) {
            return 9;
        } else {
            return 10;
        }
    }

    static int playerFire(int x, int y, String[][] displayTable, String[][] target) {

        if (target[x + 1][y + 1].equals("O")) {
            displayTable[x + 1][y + 1] = "X";
            displayTable[x + 2][y + 2] = ".";
            displayTable[x][y + 2] = ".";
            displayTable[x][y] = ".";
            displayTable[x + 2][y] = ".";
            int size = checkShipSize(x, y, target);
            checkIfSunk(x + 1, y + 1, size, displayTable);
            return 1;
        } else {
            System.out.println("Missed!");
            displayTable[x + 1][y + 1] = ".";
            return 0;
        }
    }

    static int checkShipSize(int x, int y, String[][] table) {
        int size = 1;

        for (int i = 1; i < 5; i++) {
            if (table[x + 1 + i][y + 1] == "O") {
                size++;
            } else {
                break;
            }
        }
        for (int i = 1; i < 5; i++) {
            if (table[x + 1 - i][y + 1] == "O") {
                size++;
            } else {
                break;
            }
        }
        for (int i = 1; i < 5; i++) {
            if (table[x + 1][y + 1 + i] == "O") {
                size++;
            } else {
                break;
            }
        }
        for (int i = 1; i < 5; i++) {
            if (table[x + 1][y + 1 - i] == "O") {
                size++;
            } else {
                break;
            }
        }
        if (size == 1) {
            System.out.println("Hit! You hit a gunboat!");
        } else if (size == 2) {
            System.out.println("Hit! You hit a destroyer!");
        } else if (size == 3) {
            System.out.println("Hit! You hit a cruiser!");
        } else if (size == 4) {
            System.out.println("Hit! You hit a battleship!");
        }
        return size;
    }

    static void checkIfSunk(int x, int y, int size, String[][] displayTable) {
        int hit = 1;
        if (size == 1) {
            displayTable[x][y - 1] = ".";
            displayTable[x][y + 1] = ".";
            displayTable[x - 1][y] = ".";
            displayTable[x + 1][y] = ".";
        } else if (size == 2) {
            for (int i = 1; i < size; i++) {
                if (displayTable[x + i][y] == "X") {
                    hit++;
                } else {
                    break;
                }
            }
            for (int i = 1; i < size; i++) {
                if (displayTable[x - i][y] == "X") {
                    hit++;
                } else {
                    break;
                }
            }
            for (int i = 1; i < size; i++) {
                if (displayTable[x][y + i] == "X") {
                    hit++;
                } else {
                    break;
                }
            }
            for (int i = 1; i < size; i++) {
                if (displayTable[x][y - i] == "X") {
                    hit++;
                } else {
                    break;
                }
            }
            if (hit == size) {
                System.out.println("You have sunk a destroyer!");
                for (int i = 0; i <= size; i++) {
                    if (displayTable[x + i][y].equals(" ")) {
                        displayTable[x + i][y] = ".";
                        break;
                    } else if (displayTable[x + i][y].equals(".")) {
                        break;
                    }
                }
                for (int i = 0; i <= size; i++) {
                    if (displayTable[x - i][y].equals(" ")) {
                        displayTable[x - i][y] = ".";
                        break;
                    } else if (displayTable[x - i][y].equals(".")) {
                        break;
                    }
                }
                for (int i = 0; i <= size; i++) {
                    if (displayTable[x][y + i].equals(" ")) {
                        displayTable[x][y + i] = ".";
                        break;
                    } else if (displayTable[x][y + i].equals(".")) {
                        break;
                    }
                }
                for (int i = 0; i <= size; i++) {
                    if (displayTable[x][y - i].equals(" ")) {
                        displayTable[x][y - i] = ".";
                        break;
                    } else if (displayTable[x][y - i].equals(".")) {
                        break;
                    }
                }
            }
        } else if (size == 3) {
            for (int i = 1; i < size; i++) {
                if (displayTable[x + i][y] == "X") {
                    hit++;
                } else {
                    break;
                }
            }
            for (int i = 1; i < size; i++) {
                if (displayTable[x - i][y] == "X") {
                    hit++;
                } else {
                    break;
                }
            }
            for (int i = 1; i < size; i++) {
                if (displayTable[x][y + i] == "X") {
                    hit++;
                } else {
                    break;
                }
            }
            for (int i = 1; i < size; i++) {
                if (displayTable[x][y - i] == "X") {
                    hit++;
                } else {
                    break;
                }
            }
            if (hit == size) {
                System.out.println("You have sunk a cruiser!");
                for (int i = 0; i <= size; i++) {
                    if (displayTable[x + i][y].equals(" ")) {
                        displayTable[x + i][y] = ".";
                        break;
                    } else if (displayTable[x + i][y].equals(".")) {
                        break;
                    }
                }
                for (int i = 0; i <= size; i++) {
                    if (displayTable[x - i][y].equals(" ")) {
                        displayTable[x - i][y] = ".";
                        break;
                    } else if (displayTable[x - i][y].equals(".")) {
                        break;
                    }
                }
                for (int i = 0; i <= size; i++) {
                    if (displayTable[x][y + i].equals(" ")) {
                        displayTable[x][y + i] = ".";
                        break;
                    } else if (displayTable[x][y + i].equals(".")) {
                        break;
                    }
                }
                for (int i = 0; i <= size; i++) {
                    if (displayTable[x][y - i].equals(" ")) {
                        displayTable[x][y - i] = ".";
                        break;
                    } else if (displayTable[x][y - i].equals(".")) {
                        break;
                    }
                }
            }
        } else if (size == 4) {
            for (int i = 1; i < size; i++) {
                if (displayTable[x + i][y] == "X") {
                    hit++;
                } else {
                    break;
                }
            }
            for (int i = 1; i < size; i++) {
                if (displayTable[x - i][y] == "X") {
                    hit++;
                } else {
                    break;
                }
            }
            for (int i = 1; i < size; i++) {
                if (displayTable[x][y + i] == "X") {
                    hit++;
                } else {
                    break;
                }
            }
            for (int i = 1; i < size; i++) {
                if (displayTable[x][y - i] == "X") {
                    hit++;
                } else {
                    break;
                }
            }
            if (hit == size) {
                System.out.println("You have sunk a battleship!");
                for (int i = 0; i <= size; i++) {
                    if (displayTable[x + i][y].equals(" ")) {
                        displayTable[x + i][y] = ".";
                        break;
                    } else if (displayTable[x + i][y].equals(".")) {
                        break;
                    }
                }
                for (int i = 0; i <= size; i++) {
                    if (displayTable[x - i][y].equals(" ")) {
                        displayTable[x - i][y] = ".";
                        break;
                    } else if (displayTable[x - i][y].equals(".")) {
                        break;
                    }
                }
                for (int i = 0; i <= size; i++) {
                    if (displayTable[x][y + i].equals(" ")) {
                        displayTable[x][y + i] = ".";
                        break;
                    } else if (displayTable[x][y + i].equals(".")) {
                        break;
                    }
                }
                for (int i = 0; i <= size; i++) {
                    if (displayTable[x][y - i].equals(" ")) {
                        displayTable[x][y - i] = ".";
                        break;
                    } else if (displayTable[x][y - i].equals(".")) {
                        break;
                    }
                }
            }
        }
    }

}
