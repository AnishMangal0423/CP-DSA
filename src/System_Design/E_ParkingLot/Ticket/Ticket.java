package System_Design.E_ParkingLot.Ticket;

import System_Design.D_Factory_Design_Pattern.Abstract_Factory_Design.Vehicles.Vehicle;
import System_Design.E_ParkingLot.ParkingSpot.ParkingSpot;
import System_Design.E_ParkingLot.Vehicle.Vehiclee;

public class Ticket {

   public long entryTime;
    public ParkingSpot parkingSpot;
    public Vehiclee vehiclee;


    public Ticket(long entryTime, ParkingSpot parkingSpot, Vehiclee vehiclee){
        this.entryTime=entryTime;
        this.parkingSpot=parkingSpot;
        this.vehiclee=vehiclee;
    }
}
