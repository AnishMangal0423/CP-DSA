package System_Design.E_ParkingLot;

import System_Design.E_ParkingLot.EntryGate.EntryGate;
import System_Design.E_ParkingLot.ExitGate.ExitGate;
import System_Design.E_ParkingLot.Factories.ParkingSpotManagerFactory;
import System_Design.E_ParkingLot.ParkingSpot.FourWheelerParkingSpot;
import System_Design.E_ParkingLot.ParkingSpot.ParkingSpot;
import System_Design.E_ParkingLot.ParkingSpot.TwoWheelerParkingSpot;
import System_Design.E_ParkingLot.Ticket.Ticket;
import System_Design.E_ParkingLot.Vehicle.Vehiclee;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ParkingLotMainClass {

    public static void main(String[] args) {

        List<ParkingSpot>twoWheeler = new ArrayList<>();
        List<ParkingSpot>fourWheeler = new ArrayList<>();
        for(int i=0; i<2; i++){
            twoWheeler.add(new TwoWheelerParkingSpot(i));
            fourWheeler.add(new FourWheelerParkingSpot(i));
        }

        ParkingSpotManagerFactory factory = new ParkingSpotManagerFactory();
        Vehiclee v1 = new Vehiclee("TwoWheeler", 1);
        Vehiclee v2 = new Vehiclee("TwoWheeler", 2);
        Vehiclee v3 = new Vehiclee("FourWheeler", 3);

        EntryGate G1 = new EntryGate(factory);
        Ticket t1 = G1.passVechile(v1, v1.VehicleeType=="TwoWheeler"?twoWheeler:fourWheeler);
        if(t1!=null) System.out.println("Vechile Type ?: "+ t1.vehiclee.VehicleeType + "Entry Time ?: " + t1.entryTime +"Parking No?: "+ t1.parkingSpot.id );

        Ticket t2 = G1.passVechile(v2, v2.VehicleeType=="TwoWheeler"?twoWheeler:fourWheeler);
        if(t2!=null) System.out.println("Vechile Type ?: "+ t2.vehiclee.VehicleeType + "Entry Time ?: " + t2.entryTime +"Parking No?: "+ t2.parkingSpot.id );

        ExitGate Exitgate1 = new ExitGate(factory, t1);
       int TicketPrice =  Exitgate1.ExitVechile(v1, v1.VehicleeType=="TwoWheeler"?twoWheeler:fourWheeler);
        System.out.println("Amount to be Paid ?: "+TicketPrice);

        int TicketPrice2 =  Exitgate1.ExitVechile(v2, v2.VehicleeType=="TwoWheeler"?twoWheeler:fourWheeler);
        System.out.println("Amount to be Paid ?: "+TicketPrice2);
    }
}
