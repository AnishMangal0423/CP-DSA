package System_Design.H_SnakeLadder_Design.Dice;

public class Dice {

    public int DiceCount;

    public Dice(int count){
        this.DiceCount=count;
    }


   public int RollDice(){
        int sum = 0;

        for(int i=0; i<DiceCount; i++){
            sum+=(int) (Math.random()*6) + 1;
        }
        return sum;
    }
}
// Configure Faces of Dice.
//