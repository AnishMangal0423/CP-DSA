package System_Design.F_TicTacToe_Game.Player;

import System_Design.F_TicTacToe_Game.Pieces.PlayingPieceType;

public class Player {

    public int PlayerId;

    public String PlayerName;

    public PlayingPieceType piece;

    public Player(int PId, String PName, PlayingPieceType p){

        this.PlayerId=PId;
        this.PlayerName=PName;
        this.piece=p;
    }
}
