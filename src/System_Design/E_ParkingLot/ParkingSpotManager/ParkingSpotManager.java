package System_Design.E_ParkingLot.ParkingSpotManager;

import System_Design.D_Factory_Design_Pattern.Abstract_Factory_Design.Vehicles.Vehicle;
import System_Design.E_ParkingLot.ParkingSpot.ParkingSpot;
import System_Design.E_ParkingLot.Vehicle.Vehiclee;

import java.util.List;

public class ParkingSpotManager {

    int id = -1;
    List<ParkingSpot>slots;


    Vehiclee vehiclee;

    public ParkingSpotManager(List<ParkingSpot>slotsComing){
        slots=slotsComing;
    }
    public int isParkingAvailable(){
        for(ParkingSpot slot : slots){
            if(slot.isParkingSlotFree()!=-1){
                return id =  slot.isParkingSlotFree();
            }
        }

        return -1;
    }

    public void addVechile(Vehiclee v, int id){
        if(id!=-1){
            ParkingSpot  slot = slots.get(id);
            slot.addVechile(v);
        }
    }

    public void removeVechile(){
            ParkingSpot  slot = slots.get(id);
            slot.removeVechile();
        }
    }

//    Ticket GenerateTicket(){}





