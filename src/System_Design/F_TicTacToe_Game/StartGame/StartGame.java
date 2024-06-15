package System_Design.F_TicTacToe_Game.StartGame;

import System_Design.F_TicTacToe_Game.Board.Board;
import System_Design.F_TicTacToe_Game.Pieces.PlayingPieceType;
import System_Design.F_TicTacToe_Game.Player.Player;

import java.util.Deque;
import java.util.Scanner;

public class StartGame {
    Deque<Player>playerQueue;
    int BoardSize;

    Board board;

    Scanner sc;
    public StartGame(Deque<Player> playerQueue, int BoardSize){
        this.playerQueue=playerQueue;
        this.BoardSize=BoardSize;
        board = new Board(BoardSize);
        sc=new Scanner(System.in);
        StartTurns();
    }

    public boolean isPlaceAvailableToPutPiece(){
        for(int i=0; i<BoardSize; i++){
            for(int j=0; j<BoardSize; j++){
                if(board.BoardGrid[i][j]==null)return true;
            }
        }
        return false;
    }

    public boolean SafePlacetoPut(int ii, int jj){
        return (board.BoardGrid[ii][jj]==null)?true:false;
    }

    public boolean CheckWin(int i, int j, Player p){

        // Same row -
       boolean ans = false;
        PlayingPieceType pievetype = p.piece;
        int row=0;
        int col=0;
        for(;col<BoardSize; col++){
            if(board.BoardGrid[i][col]==null || board.BoardGrid[i][col]!=p.piece) {
                break;
            }
        }

        if(col==BoardSize) return true;

        // same col-
        for(; row<BoardSize; row++){
            if(board.BoardGrid[row][j]==null || board.BoardGrid[row][j]!=p.piece) break;
        }

        if(row == BoardSize) return true;

        // Diagonal -1 -

        row=0; col=BoardSize-1;
        for(; row<BoardSize; row++){
            if(board.BoardGrid[row][row]==null || board.BoardGrid[row][row]!=p.piece) break;
        }

        if(row==BoardSize)return true;


        // Diagonal-2 -
        for(; col>=0; col--){
            if(board.BoardGrid[BoardSize-col][col]==null || board.BoardGrid[BoardSize-col][col]!=p.piece)break;
        }

        if(col==0)return true;

        return false;
    }

    public void PrintBoard(){

        for(int i=0; i<BoardSize; i++){
            for(int j=0; j<BoardSize; j++){

                if(board.BoardGrid[i][j]!=null){
                    System.out.print(board.BoardGrid[i][j].piece+" |");
                }

                else System.out.print("  |");
            }

            System.out.println();
        }
    }
    public void StartTurns(){
          int isWinner = 0;
        while (isWinner==0){

         Player p = playerQueue.removeLast();

         if(isPlaceAvailableToPutPiece()==false){
             System.out.println("Match Tie, Play Again - ");
             return;
         }

         System.out.println("Enter the Position where " + p.PlayerName+ " wants to Place the Piece :- ");

         int i=sc.nextInt();
         int j=sc.nextInt();

         // Now check-place safe.

         if(SafePlacetoPut(i, j)==true){
             board.BoardGrid[i][j]=p.piece;
             PrintBoard();
             if(CheckWin(i, j, p)==true){
                 System.out.println("Player with Id "+p.PlayerId + " and Name "+p.PlayerName+" has won the match" + " and Piece Choosen by him in Starting was "+ p.piece.piece);
                 return;
             }

             else playerQueue.addFirst(p);
         }

         else{
             System.out.println("Already Piece is Present there , Try Again - ");
             playerQueue.addLast(p);
         }


     }

    }



}
