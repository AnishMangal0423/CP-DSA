package System_Design.E_ParkingLot.EntryGate;

import System_Design.E_ParkingLot.Factories.ParkingSpotManagerFactory;
import System_Design.E_ParkingLot.ParkingLotMainClass;
import System_Design.E_ParkingLot.ParkingSpot.ParkingSpot;
import System_Design.E_ParkingLot.ParkingSpotManager.ParkingSpotManager;
import System_Design.E_ParkingLot.Ticket.Ticket;
import System_Design.E_ParkingLot.Vehicle.Vehiclee;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EntryGate {

   Vehiclee vehiclee;

   Ticket ticket;
   ParkingSpotManagerFactory factory;

   public EntryGate(ParkingSpotManagerFactory factory){
      this.factory=factory;
   }
   public Ticket passVechile(Vehiclee v, List<ParkingSpot> list){

     String VehicleeType = v.VehicleeType;
      ParkingSpotManager manager = factory.getParkingSpotManager(VehicleeType,list);
      // isParking Available
      int ParkingSlotId = manager.isParkingAvailable();

      // Park the Vechile.
      if(ParkingSlotId!=-1){
         manager.addVechile(v, ParkingSlotId);

         // Generate Ticket.

          LocalDateTime now = LocalDateTime.now();
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
          String dateTimeString = now.format(formatter);
          long dateTimeLong = Long.parseLong(dateTimeString);
//          // Print the result
////          System.out.println("Current date and time in yyyyMMddHHmmss format as long: " + dateTimeLong);
          ParkingSpot parkingspot = list.get(ParkingSlotId);
         Ticket t = new Ticket(dateTimeLong, parkingspot , v);

         return t;
      }


     else{
         System.out.println("Sorry , We have Not any Parking Available for ?: "+ VehicleeType);
         return null;
      }
   }
}
