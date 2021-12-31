
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("****************************************************");
        System.out.println("+++++++++++++++Welcome To Minesweeper+++++++++++++++");
        System.out.println("----------------------------------------------------");
        System.out.println("Please enter the size of the board you wanna play : ");
        System.out.print("Row Number : ");
        int rownumber = scanner.nextInt();
        System.out.print("Column Number : ");
        int columnnumber = scanner.nextInt();
        MineSweeper mineSweeper = new MineSweeper(rownumber,columnnumber);
        mineSweeper.run();
        
        
        
    }
    
}
