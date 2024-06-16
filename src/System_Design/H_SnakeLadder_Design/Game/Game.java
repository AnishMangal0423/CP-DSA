package System_Design.H_SnakeLadder_Design.Game;

import System_Design.H_SnakeLadder_Design.Board.SnakeLadderBoard;
import System_Design.H_SnakeLadder_Design.Dice.Dice;
import System_Design.H_SnakeLadder_Design.Player.Player;

import java.util.Deque;
import java.util.LinkedList;

public class Game {

    SnakeLadderBoard Board;

    Dice dice;

    boolean isWinner = false;

    Deque<Player>players=new LinkedList<>();

    int size;
    public Game(SnakeLadderBoard board, Dice dice){
        Player p1 = new Player(1,0);
        Player p2 = new Player(2,0);
        this.Board=board;
        this.dice=dice;
        players.addFirst(p1);
        players.addFirst(p2);
        this.size=Board.size;
       StartGame();
    }


    public void StartGame(){

        while (isWinner==false){

            // Roll the dice.
            Player p = players.removeLast();
            int DiceCountValue = dice.RollDice();

            int FinalPosition = p.position + DiceCountValue;
            if(FinalPosition >= (size*size)){
                System.out.println("Game Over , and Won By Player with Id : " + p.playerId);
                return;
            }
                int row = (FinalPosition)/size;
            int col = (row%2==0)?(FinalPosition%size) : (size - FinalPosition%size - 1);
            // Check where it has jump or not-
//            System.out.println(row + " hhh  "+ col);
            if(Board.Board[row][col].jump !=null){
                int jumpStart = Board.Board[row][col].jump.startPoint;
                int jumpend = Board.Board[row][col].jump.endPoint;

                // snake found-
                if(jumpStart > jumpend){
                    System.out.println("Snake Cut the Player with Id "+p.playerId + " at Position "+ jumpStart);
                    p.position=jumpend;
                }

                else{
                    System.out.println("Ladder found by Player with Id "+p.playerId + " at Position "+ jumpStart);
                   p.position=jumpend;
                }

            }

            else{
             p.position = FinalPosition;
            }
            System.out.println("Dice Rolled by player "+ p.playerId +"Got the Dice Value as "+ DiceCountValue +" and Final Position is "+p.position);
         players.addFirst(p);

        }
    }

}
