package System_Design.A_Strategy_Design_Pattern.System_Design_Way;

import System_Design.A_Strategy_Design_Pattern.System_Design_Way.Stratergy.Passenger_Type_Stratergy;

public class Normal_Vehicle extends Vehicle{

    Normal_Vehicle(){
        super(new Passenger_Type_Stratergy());
    }
}
