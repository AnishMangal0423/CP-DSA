package System_Design.D_Factory_Design_Pattern.Abstract_Factory_Design.VehicleFactory;

import System_Design.D_Factory_Design_Pattern.Abstract_Factory_Design.Vehicles.Vehicle;

public interface VehicleFactory {

    Vehicle TypeofVehicle(String s);
}