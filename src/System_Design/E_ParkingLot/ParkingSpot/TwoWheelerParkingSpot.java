package System_Design.E_ParkingLot.ParkingSpot;

import System_Design.D_Factory_Design_Pattern.Abstract_Factory_Design.Vehicles.Vehicle;
import System_Design.E_ParkingLot.ParkingSpotManager.TwoWheelerParkingSpotManager;

public class TwoWheelerParkingSpot extends ParkingSpot{

    public TwoWheelerParkingSpot(int id){
        super(10, id);
    }
    public int price(){ return 10; }

}
