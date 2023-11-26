import javax.swing.*;
import java.util.*;

class SnakeRunner {
    public void SnakeRun() {
        int boardWidth = 600;
        int boardHeight = boardWidth;

        JFrame frame = new JFrame("Snake\t\t press space to start");
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SnakeGame snakeGame = new SnakeGame(boardWidth, boardHeight);
        frame.add(snakeGame);
        frame.pack();
        snakeGame.requestFocus();
    }
}

public class App {

    public static void main(String[] args) throws Exception {

        System.out.println("\t \t \tWelCome To Our Many Game One Plateform");
        System.out.println("\t \t \t1- Snake Runner");
        System.out.println("\t \t \t2- TicTacToe");
        System.out.println("\t \t \t3- Rock Paper Scissors");

        Scanner scanner = new Scanner(System.in);
        System.out.print("\n\t \t \tEnter Your Choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.println("\t \t \tYou have chosen the game of Snake Runner.");
                SnakeRunner snakeRunner = new SnakeRunner();
                snakeRunner.SnakeRun();
            }
            case 2 -> {
                System.out.println("\t \t \tYou have chosen the game of TicTacToe.");
                TicTacToe ticTacToe = new TicTacToe();
            }
            case 3 -> {
                System.out.println("\t \t \tYou have chosen the game of Rock Paper Scissors.");
                RockPaperScissorsGame game = new RockPaperScissorsGame();
            }
            default -> System.out.println("\t \t \tInvalid Input! Please Enter a valid number!");
        }

    }
}
