import java.util.Scanner;

public class TicTacToe {
    public static char[][] board = new char[3][3];
    public static char currentPlayer = 'X';
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            initializeBoard();
            printBoard();
            while (true) {
                playerMove();
                printBoard();
                if (checkWin()) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }
                if (checkDraw()) {
                    System.out.println("The game is draw!");
                    break;
                }
                switchPlayer();
            }
        } finally {
            sc.close();
        }
    }

    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void playerMove() {
        int row, col;
        while (true) {
            System.out.println("Player " + currentPlayer + " , enter your move (row and column):");
            row = sc.nextInt();
            col = sc.nextInt();
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
                board[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("This move is not valid");
            }
        }
    }

    public static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public static boolean checkWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }

    public static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
