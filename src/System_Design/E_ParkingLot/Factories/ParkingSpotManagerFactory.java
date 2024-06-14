package System_Design.E_ParkingLot.Factories;

import System_Design.D_Factory_Design_Pattern.Abstract_Factory_Design.Vehicles.Vehicle;
import System_Design.E_ParkingLot.ParkingSpot.ParkingSpot;
import System_Design.E_ParkingLot.ParkingSpotManager.FourWheelerParkingSpotManager;
import System_Design.E_ParkingLot.ParkingSpotManager.ParkingSpotManager;
import System_Design.E_ParkingLot.ParkingSpotManager.TwoWheelerParkingSpotManager;

import javax.swing.event.ListDataEvent;
import java.util.List;

public class ParkingSpotManagerFactory {

    public ParkingSpotManager getParkingSpotManager(String VechileType, List<ParkingSpot>list) {

        switch (VechileType) {

            case "TwoWheeler":
                return new TwoWheelerParkingSpotManager(list);
            case "FourWheeler":
                return new FourWheelerParkingSpotManager(list);

            default:return null;
        }
    }
}
