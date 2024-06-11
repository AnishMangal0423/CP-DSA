package System_Design.A_Strategy_Design_Pattern.System_Design_Way;

import System_Design.A_Strategy_Design_Pattern.System_Design_Way.Stratergy.Off_Roading_Stratergy;

public class Off_Roading_vehicle extends Vehicle{

    Off_Roading_vehicle(){
        super(new Off_Roading_Stratergy());
    }
}
