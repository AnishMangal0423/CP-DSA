package System_Design.F_TicTacToe_Game.Board;

import System_Design.F_TicTacToe_Game.Pieces.PlayingPieceType;

public class Board {

    public int size;

    public PlayingPieceType[][]BoardGrid;


    public Board(int size){
        this.size=size;
        BoardGrid=new PlayingPieceType[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                BoardGrid[i][j]=null;
            }
        }
    }
}
