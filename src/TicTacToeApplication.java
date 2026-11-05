import java.util.Scanner;

public class TicTacToeApplication {

    public static Scanner SC = new Scanner(System.in);
    public static String[] GAME;
    public static boolean PLAYER;

    static void main() {
        String midLine = "═";
        System.out.println("╔"+midLine.repeat(30)+"╗");
        System.out.println("║ TIC TAC TOE APPLICATION GAME ║");
        System.out.println("╚"+midLine.repeat(30)+"╝");
        loadNewGame();
        sleep();

        while (true){
            playerAct();

            if (endGame()) break;

            playerAct();

            if (endGame()) break;
        }
    }

    static void showBoard() {
        String midLine = "═";
        System.out.println("╔"+midLine.repeat(17)+"╗");
        System.out.println(
                "║ ("+normalizeTest(0)+") | ("+normalizeTest(1)+") | ("+normalizeTest(2)+") ║"
        );
        System.out.println(
                "║ ("+normalizeTest(3)+") | ("+normalizeTest(4)+") | ("+normalizeTest(5)+") ║"
        );
        System.out.println(
                "║ ("+normalizeTest(6)+") | ("+normalizeTest(7)+") | ("+normalizeTest(8)+") ║"
        );
        System.out.println("╚"+midLine.repeat(17)+"╝");
    }

    static String normalizeTest(int position) {

        if (GAME[position] == null) {
            return " ";
        }

        return GAME[position];
    }

    static void loadNewGame() {

        GAME = new String[9];
    }

    static void playerAct() {
        clear();

        if (PLAYER) PLAYER = false;
        else PLAYER = true;

        boolean validMovement;

        do {
            showBoard();
            int position;
            System.out.print("["
                    +(PLAYER ? "P1" : "P2")
                    +"] - Choose one position [1-9]: ");
            position = SC.nextInt();
            position--;

            validMovement =
                    validatePoint(position);

            if (validMovement) GAME[position] = PLAYER ? "X" : "O";
        } while (!validMovement);
    }

    static boolean  validatePoint(int position) {

        if (position < 0 || position > 8) {
            System.out.println("Invalid position");
            return false;
        }

        if (GAME[position] != null) {
            System.out.println("Position already have been choosen");
            return false;
        }

        return true;
    }

    static boolean endGame() {

        if (
                ((GAME[1] == GAME[0] && GAME[2] == GAME[0]) && GAME[0] != null) ||
                ((GAME[4] == GAME[3] && GAME[5] == GAME[3]) && GAME[3] != null) ||
                ((GAME[7] == GAME[6] && GAME[8] == GAME[6]) && GAME[6] != null)
        ) {
            clear();
            showBoard();
            System.out.println("Player "+(PLAYER ? "P1" : "P2")+ " had win this match!");
            return true;
        }

        if (
                ((GAME[3] == GAME[0] && GAME[6] == GAME[0]) && GAME[0] != null) ||
                        ((GAME[4] == GAME[1] && GAME[7] == GAME[1]) && GAME[1] != null) ||
                        ((GAME[5] == GAME[2] && GAME[8] == GAME[2]) && GAME[2] != null)
        ) {
            clear();
            showBoard();
            System.out.println("Player "+(PLAYER ? "P1" : "P2")+ " had win this match!");
            return true;
        }

        if (
                ((GAME[4] == GAME[0] && GAME[8] == GAME[0]) && GAME[0] != null) ||
                        ((GAME[4] == GAME[2] && GAME[6] == GAME[2]) && GAME[2] != null)
        ) {
            clear();
            showBoard();
            System.out.println("Player "+(PLAYER ? "P1" : "P2")+ " had win this match!");
            return true;
        }

        for (int i = 0; i < GAME.length; i++) {

            if (GAME[i] == null) {
                return false;
            }
        }

        clear();
        showBoard();
        System.out.println("Draw!");
        return true;
    }

    private static void clear() {

        for (int i = 0; i < 30; i++) {

            System.out.println();
        }
    }

    private static void sleep() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            return;
        }
    }
}
