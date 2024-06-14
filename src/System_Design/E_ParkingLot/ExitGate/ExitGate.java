package System_Design.E_ParkingLot.ExitGate;

import System_Design.E_ParkingLot.Factories.ParkingSpotManagerFactory;
import System_Design.E_ParkingLot.ParkingSpot.ParkingSpot;
import System_Design.E_ParkingLot.ParkingSpotManager.ParkingSpotManager;
import System_Design.E_ParkingLot.Ticket.Ticket;
import System_Design.E_ParkingLot.Vehicle.Vehiclee;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExitGate{

    // Get Payment
    // Exit Fn

    ParkingSpotManagerFactory factory;
    Ticket t;

    public ExitGate(ParkingSpotManagerFactory factory, Ticket t){
        this.factory=factory;
        this.t=t;
    }

    public int ExitVechile(Vehiclee v, List<ParkingSpot> list){

        String VehicleeType = v.VehicleeType;
        int VechileId = v.VehicleeNumber;

        int price = -1;
        int parkingGate = -1;
        ParkingSpotManager manager = factory.getParkingSpotManager(VehicleeType,list);

        for(ParkingSpot spot : list){
            if(spot.vehiclee==v){
                spot.removeVechile();
                price=spot.price;
                parkingGate=spot.id;
                break;
            }
        }

         //  Generate Price -

       long entryTime = t.entryTime;


        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String dateTimeString = now.format(formatter);
        long dateTimeLong = Long.parseLong(dateTimeString);
        long exitTime = dateTimeLong;

        int TotalPrice = (int)(exitTime-entryTime)*price;

        System.out.println("Vechile of Type?: "+VehicleeType+"Vechile Number?: "+VechileId+"from ParkingNo?: "+parkingGate);

        return TotalPrice;
    }


}
