package System_Design.E_ParkingLot.Vehicle;

import System_Design.D_Factory_Design_Pattern.Abstract_Factory_Design.Vehicles.Vehicle;
import System_Design.E_ParkingLot.Factories.ParkingSpotManagerFactory;
import System_Design.E_ParkingLot.ParkingSpotManager.ParkingSpotManager;

public class Vehiclee {

    public String VehicleeType;
    public int VehicleeNumber;

  public Vehiclee(String VehicleeType, int VehicleeNumber){
       this.VehicleeType=VehicleeType;
       this.VehicleeNumber = VehicleeNumber;
   }
}
