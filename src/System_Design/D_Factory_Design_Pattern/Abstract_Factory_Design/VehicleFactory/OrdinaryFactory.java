package System_Design.D_Factory_Design_Pattern.Abstract_Factory_Design.VehicleFactory;

import System_Design.D_Factory_Design_Pattern.Abstract_Factory_Design.VehicleFactory.VehicleFactory;
import System_Design.D_Factory_Design_Pattern.Abstract_Factory_Design.Vehicles.Swift_Dezire;
import System_Design.D_Factory_Design_Pattern.Abstract_Factory_Design.Vehicles.Vehicle;

public class OrdinaryFactory implements VehicleFactory {

    public Vehicle TypeofVehicle(String input){

        switch (input) {
            case "SWIFTDEZIRE": return new Swift_Dezire();
            default:return null;
        }
    }
}

