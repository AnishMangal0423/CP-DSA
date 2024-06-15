package System_Design.F_TicTacToe_Game;

import System_Design.F_TicTacToe_Game.Pieces.PlayingPieceTypeO;
import System_Design.F_TicTacToe_Game.Pieces.PlayingPieceTypeX;
import System_Design.F_TicTacToe_Game.Player.Player;
import System_Design.F_TicTacToe_Game.StartGame.StartGame;

import java.util.*;

public class RunGameMainClass {

    public static void main(String[] args) {

        Deque<Player> PlayerQueue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Players - ");
        int noOfPalyers = sc.nextInt();

        if(noOfPalyers==1){
            System.out.println("Sorry 1 Player Can't Play the Match \uD83D\uDE05");
            System.out.println("Try to Come-up with atleast 2 People -");
            return;
        }
        System.out.println("Toss Started - ");
        for(int i=0; i<noOfPalyers; i++){
            System.out.println("Enter the Player Id , Player Name, Player Piece Type Choosen");
            int id = sc.nextInt();
            String name = sc.next();
            String Choose = sc.next();
            char charChoose = Choose.charAt(0);
            PlayerQueue.addLast(new Player(id, name, (charChoose=='X')? new PlayingPieceTypeX(): new PlayingPieceTypeO()));
        }

        System.out.println("Now Enter the Size of Board for our Players -");
        int size = sc.nextInt();

        StartGame Game1 = new StartGame(PlayerQueue, size);


    }
}
