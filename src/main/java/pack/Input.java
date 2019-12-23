package pack;

public class Input {

    static int getColumn(String coordinate) {
        coordinate.toLowerCase();

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
