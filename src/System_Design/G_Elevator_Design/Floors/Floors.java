package System_Design.G_Elevator_Design.Floors;

import System_Design.G_Elevator_Design.Directions.Directions;
import System_Design.G_Elevator_Design.ExternalButtons.ExternalButtons;

public class Floors {

   public int floorNumber;
    public ExternalButtons exteranalButton;

//    Directions direction;

    public Floors(int floorNumber, ExternalButtons exteranalButton){
        this.floorNumber=floorNumber;
        this.exteranalButton=exteranalButton;
    }
}
