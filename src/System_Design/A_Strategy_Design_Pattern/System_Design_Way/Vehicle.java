package System_Design.A_Strategy_Design_Pattern.System_Design_Way;

import System_Design.A_Strategy_Design_Pattern.System_Design_Way.Stratergy.Drive_Stratergy;

public class Vehicle {

    Drive_Stratergy obj;

    Vehicle(Drive_Stratergy obj){
        this.obj=obj;
    }

    void drive(){
        obj.Drive();
    }
}
