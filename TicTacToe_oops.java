import java.util.Scanner;
interface Playable {
    char getSymbol();          
    int[] makeMove(char[][] board);
}

abstract class Player implements Playable {
     String name;
     char symbol;
    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }
    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
}
class HumanPlayer extends Player {
     Scanner sc;
    public HumanPlayer(String name, char symbol, Scanner sc) {
        super(name, symbol);
        this.sc = sc;
    }
    public int[] makeMove(char[][] board) {
        System.out.println(name + " (" + symbol + ") — enter row and column (0-2):");
        int row = sc.nextInt();
        int col = sc.nextInt();
        return new int[]{row, col};
    }
}

class Board {
     char[][] grid;
    public Board() {
        grid = new char[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                grid[i][j] = '-';
    }

    public char[][] getGrid() {
        return grid;
    }

    public boolean isCellEmpty(int r, int c) {
        return grid[r][c] == '-';
    }

    public boolean isValidMove(int r, int c) {
        return r >= 0 && r <= 2 && c >= 0 && c <= 2 && isCellEmpty(r, c);
    }

    public void placeMove(int r, int c, char symbol) {
        grid[r][c] = symbol;
    }

    public boolean checkWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol) return true;
            if (grid[0][i] == symbol && grid[1][i] == symbol && grid[2][i] == symbol) return true;
        }
        if (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) return true;
        if (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol) return true;

        return false;
    }

    public void display() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++)
                System.out.print(grid[i][j] + " | ");
            System.out.println("\n-------------");
        }
    }
}
class Game {
     Board board;
     Player[] players;
     int currentPlayerIndex;
     int moves;
    public Game(Player p1, Player p2) {
        this.board = new Board();
        this.players = new Player[]{p1, p2};
        this.currentPlayerIndex = 0;
        this.moves = 0;
    }

    public void start() {
        boolean gameOver = false;

        while (!gameOver && moves < 9) {
            board.display();

            Player current = players[currentPlayerIndex];
            int[] move = current.makeMove(board.getGrid());
            int row = move[0];
            int col = move[1];

            if (!board.isValidMove(row, col)) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            board.placeMove(row, col, current.getSymbol());
            moves++;

            if (board.checkWin(current.getSymbol())) {
                board.display();
                System.out.println(current.getName() + " wins!");
                gameOver = true;
            } else {
                currentPlayerIndex = (currentPlayerIndex + 1) % 2;
            }
        }

        if (!gameOver) {
            board.display();
            System.out.println("It's a draw!");
        }
    }
}
public class TicTacToe_oops{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HumanPlayer player1 = new HumanPlayer("Alice", 'X', sc);
        HumanPlayer player2 = new HumanPlayer("Bob",   'O', sc);

        Game game = new Game(player1, player2);
        game.start();
    }
}