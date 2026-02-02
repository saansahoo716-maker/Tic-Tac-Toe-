import java.util.Scanner;
public class tictactoe {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char a = '1', b = '2', c = '3';
        char d = '4', e = '5', f = '6';
        char g = '7', h = '8', i = '9';

        char player = 'X';
        int move;
        boolean gameOver = false;

        for (int turn = 1; turn <= 9 && !gameOver; ) {

            System.out.println();
            System.out.println(a + " | " + b + " | " + c);
            System.out.println("--+---+--");
            System.out.println(d + " | " + e + " | " + f);
            System.out.println("--+---+--");
            System.out.println(g + " | " + h + " | " + i);
            System.out.println();

            System.out.println("Player " + player + ", enter your move (1-9): ");
            move = sc.nextInt();

            boolean validMove = true;

            switch (move) {
                case 1:
                    if (a == 'X' || a == 'O') validMove = false;
                    else a = player;
                    break;
                case 2:
                    if (b == 'X' || b == 'O') validMove = false;
                    else b = player;
                    break;
                case 3:
                    if (c == 'X' || c == 'O') validMove = false;
                    else c = player;
                    break;
                case 4:
                    if (d == 'X' || d == 'O') validMove = false;
                    else d = player;
                    break;
                case 5:
                    if (e == 'X' || e == 'O') validMove = false;
                    else e = player;
                    break;
                case 6:
                    if (f == 'X' || f == 'O') validMove = false;
                    else f = player;
                    break;
                case 7:
                    if (g == 'X' || g == 'O') validMove = false;
                    else g = player;
                    break;
                case 8:
                    if (h == 'X' || h == 'O') validMove = false;
                    else h = player;
                    break;
                case 9:
                    if (i == 'X' || i == 'O') validMove = false;
                    else i = player;
                    break;
                default:
                    System.out.println("Invalid position!");
                    continue;
            }

            if (!validMove) {
                System.out.println("Position already taken! Try again.");
                continue;
            }
            if ((a == player && b == player && c == player) ||
                (d == player && e == player && f == player) ||
                (g == player && h == player && i == player) ||
                (a == player && d == player && g == player) ||
                (b == player && e == player && h == player) ||
                (c == player && f == player && i == player) ||
                (a == player && e == player && i == player) ||
                (c == player && e == player && g == player)) {

                System.out.println("Player " + player + " wins!");
                gameOver = true;
            }

            player = (player == 'X') ? 'O' : 'X';
            turn++;
        }

        if (!gameOver) {
            System.out.println("Game Draw!");
        }
    }
}

