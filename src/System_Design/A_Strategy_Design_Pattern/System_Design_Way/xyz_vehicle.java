package System_Design.A_Strategy_Design_Pattern.System_Design_Way;

import System_Design.A_Strategy_Design_Pattern.System_Design_Way.Stratergy.xyz_type_stratergy;

public class xyz_vehicle extends Vehicle{

    xyz_vehicle(){

        super(new xyz_type_stratergy());
    }

}
