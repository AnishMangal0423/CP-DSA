package System_Design.E_ParkingLot.ParkingSpot;

import System_Design.D_Factory_Design_Pattern.Abstract_Factory_Design.Vehicles.Vehicle;
import System_Design.E_ParkingLot.ParkingSpotManager.ParkingSpotManager;
import System_Design.E_ParkingLot.Vehicle.Vehiclee;

public class ParkingSpot {

    public int id;
    public boolean isFree = true;

   public int price;
    public Vehiclee vehiclee = null;


    ParkingSpot(int price, int id){
        this.id=id;
        this.price=price;
    }

    public int isParkingSlotFree(){
        return (isFree==true)?id : -1;
    }

    public void AddParkingSlotStatus(boolean status){
        isFree=status;
    }
    public void  addVechile(Vehiclee v){
        vehiclee= v;
        isFree=false;
    }

    public void removeVechile(){
        vehiclee=null;
        isFree=true;
    }
}
