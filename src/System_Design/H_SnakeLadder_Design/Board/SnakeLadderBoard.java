package System_Design.H_SnakeLadder_Design.Board;

import System_Design.H_SnakeLadder_Design.Cells.Cells;
import System_Design.H_SnakeLadder_Design.Jump.Jump;

import java.util.Scanner;

public class SnakeLadderBoard {

    public int size;

    public Cells cells;

    public Cells[][]Board;

    Scanner sc = new Scanner(System.in);

    public SnakeLadderBoard(int size){
        this.size=size;
        Board=new Cells[size][size];
        MakeBoard();
    }

    public void MakeBoard(){

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                Cells c = new Cells(null);
                Board[i][j]=c;
            }
        }


        AddLadderandSnake();
    }

    public void AddLadderandSnake(){

        System.out.println("How Many Snakes You want :- ");
        int NumberofSnake = sc.nextInt();
        for(int i=1; i<=NumberofSnake; i++){
            System.out.println("Enter the Starting and End Value Coordinate of Snake : "+ i);
            int startingSnake = sc.nextInt();
            int endSnake = sc.nextInt();

            if(startingSnake > endSnake){
                Jump j = new Jump(startingSnake, endSnake);
                int row = (startingSnake)/size;
                int col = (row%2==0)?(startingSnake%size) : (size - startingSnake%size - 1);
                Board[row][col].jump= j;
            }

            else{
                System.out.println("Input is Incorrect for Snake");
                return;
            }
        }


        System.out.println("How Many Ladders You want :- ");
        int NumberofLadder = sc.nextInt();

        for(int i=1; i<=NumberofLadder; i++){
            System.out.println("Enter the Starting and End Value Coordinate of Ladder : "+ i);
            int startingLadder = sc.nextInt();
            int endLadder = sc.nextInt();

            if(startingLadder < endLadder){
                Jump j = new Jump(startingLadder, endLadder);
                int row = (startingLadder)/size;
                int col = (row%2==0)?(startingLadder%size) : (size - startingLadder%size - 1);
                Board[row][col].jump= j;
            }

            else{
                System.out.println("Input is Incorrect for Ladder");
                return;
            }
        }


    }




}
