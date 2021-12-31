
import java.util.Random;
import java.util.Scanner;

public class MineSweeper {

    int[][] board;
    int[][] map;
    int rownumber;
    int coulumbnumber;
    int size;
    boolean gamestatus;
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public MineSweeper(int rownumber, int coulumbnumber) {
        this.rownumber = rownumber;
        this.coulumbnumber = coulumbnumber;
        this.map = new int[this.rownumber][this.coulumbnumber];
        this.board = new int[this.rownumber][this.coulumbnumber];
        this.size = this.rownumber * this.coulumbnumber;
    }

    public void run() {
        puttingMines();

        System.out.println("Oyun başladı...");
        int userrow, usercolumn;
        int counter1 = 0;
        this.gamestatus = true;
        while (this.gamestatus == true) {
            showGameBoard(this.board);
            System.out.print("Please enter your row value : ");
            userrow = scanner.nextInt();
            System.out.print("Please enter your column value : ");
            usercolumn = scanner.nextInt();
            if ((userrow < 0 || userrow > this.rownumber - 1) && (usercolumn < 0 || usercolumn > this.coulumbnumber - 1)) {
                System.out.println("Unavaible Coordinats...");
                continue;
            }
            if (this.map[userrow][usercolumn] == -1) {
                this.gamestatus = false;
                System.out.println("Game Over...");
            } else {
                checkMine(userrow, usercolumn);
                this.gamestatus = true;
                counter1++;
                if (counter1 == (this.size - this.size / 4)) {
                    System.out.println("Congratulations, You won the game...");
                    break;
                }
            }

        }
    }

    public void puttingMines() {
        int randomRow, randowCol, counter = 0;
        while (counter != (size / 4)) {
            randomRow = random.nextInt(rownumber);
            randowCol = random.nextInt(coulumbnumber);
            if (map[randomRow][randowCol] != -1) {
                map[randomRow][randowCol] = -1;
                counter++;
            }

        }
    }

    public void showGameBoard(int[][] gameboard) {
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[0].length; j++) {
                if (gameboard[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(gameboard[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void checkMine(int row, int column) {

        if ((column < coulumbnumber - 1) && (this.map[row][column + 1] == -1)) {
            this.board[row][column] = this.board[row][column] + 1;
        }
        if ((column > 0) && (this.map[row][column - 1] == -1)) {
            this.board[row][column] = this.board[row][column] + 1;
        }
        if ((row < rownumber - 1) && (this.map[row + 1][column] == -1)) {
            this.board[row][column] = this.board[row][column] + 1;
        }
        if ((row > 0) && (this.map[row - 1][column] == -1)) {
            this.board[row][column] = this.board[row][column] + 1;
        }
        if ((row > 0) && (column > 0) && (this.map[row - 1][column - 1] == -1)) {
            this.board[row][column] = this.board[row][column] + 1;
        }
        if ((row > 0) && (column < this.coulumbnumber - 1) && (this.map[row - 1][column + 1] == -1)) {
            this.board[row][column] = this.board[row][column] + 1;
        }
        if ((row < this.rownumber - 1) && (column > 0) && (this.map[row + 1][column - 1] == -1)) {
            this.board[row][column] = this.board[row][column] + 1;
        }
        if ((row < this.rownumber - 1) && (column < this.coulumbnumber - 1) && (this.map[row + 1][column + 1] == -1)) {
            this.board[row][column] = this.board[row][column] + 1;
        }
        if (board[row][column] == 0) {
            board[row][column] = 0;
        }
    }
}
