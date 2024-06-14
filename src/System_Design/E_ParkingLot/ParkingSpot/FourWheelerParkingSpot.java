package System_Design.E_ParkingLot.ParkingSpot;

import System_Design.D_Factory_Design_Pattern.Abstract_Factory_Design.Vehicles.Vehicle;

public class FourWheelerParkingSpot extends ParkingSpot{

    public FourWheelerParkingSpot(int id){
        super(20, id);
    }
    public int price(){ return 20; }

}
