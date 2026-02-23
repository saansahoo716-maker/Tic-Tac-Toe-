import java.util.Scanner;
public class TicTacToe2Darray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[3][3];
        char player = 'X';
        int moves = 0;
        boolean win = false;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = '-';

        while (!win && moves < 9) {
            System.out.println("-------------");
            for (int i = 0; i < 3; i++) {
                System.out.print("| ");
                for (int j = 0; j < 3; j++)
                    System.out.print(board[i][j] + " | ");
                System.out.println("\n-------------");
            }
            System.out.println("Player " + player + " enter row and column (0-2):");
            int r = sc.nextInt();
            int c = sc.nextInt();

            if (r < 0 || r > 2 || c < 0 || c > 2 || board[r][c] != '-') {
                System.out.println("Invalid move! Try again.");
                continue;
            }
            board[r][c] = player;
            moves++;
            for (int i = 0; i < 3; i++) {
                if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                    win = true;
                if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
                    win = true;
            }

            if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player))
                win = true;

            if (win) {
                System.out.println("Player " + player + " wins!");
                break;
            }
            player = (player == 'X') ? 'O' : 'X';
        }
        if (!win)
            System.out.println("It's a draw!");
    }
}
