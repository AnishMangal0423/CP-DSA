package System_Design.H_SnakeLadder_Design;

import System_Design.H_SnakeLadder_Design.Board.SnakeLadderBoard;
import System_Design.H_SnakeLadder_Design.Dice.Dice;
import System_Design.H_SnakeLadder_Design.Game.Game;
import System_Design.H_SnakeLadder_Design.Player.Player;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Starting the Snake and Ladder Game - ");
        Player p1 = new Player(1,0);
        Player p2 = new Player(2,0);
        Dice d1 = new Dice(1);
        System.out.println("Enter the Size of Board : ");
        int size = sc.nextInt();
        SnakeLadderBoard Board = new SnakeLadderBoard(size);

        Game game = new Game(Board, d1);

    }
}
