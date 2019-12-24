package pack;

public class Input {

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
}
