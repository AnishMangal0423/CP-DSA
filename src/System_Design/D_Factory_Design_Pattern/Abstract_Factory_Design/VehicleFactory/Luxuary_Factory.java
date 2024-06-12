package System_Design.D_Factory_Design_Pattern.Abstract_Factory_Design.VehicleFactory;

import System_Design.D_Factory_Design_Pattern.Abstract_Factory_Design.VehicleFactory.VehicleFactory;
import System_Design.D_Factory_Design_Pattern.Abstract_Factory_Design.Vehicles.BMW;
import System_Design.D_Factory_Design_Pattern.Abstract_Factory_Design.Vehicles.Vehicle;

public class Luxuary_Factory implements VehicleFactory {

    public Vehicle TypeofVehicle(String input){

        switch (input) {
            case "BMW": return new BMW();
            default:return null;
        }
    }
}
