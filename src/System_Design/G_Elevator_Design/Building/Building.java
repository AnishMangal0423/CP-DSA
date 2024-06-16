package System_Design.G_Elevator_Design.Building;

import System_Design.G_Elevator_Design.Directions.Directions;
import System_Design.G_Elevator_Design.DisplayBoard.Display;
import System_Design.G_Elevator_Design.ElevatorCar.ElevatorCar;
import System_Design.G_Elevator_Design.ElevatorController.ElevatorController;
import System_Design.G_Elevator_Design.ExternalButtons.ExternalButtons;
import System_Design.G_Elevator_Design.Floors.Floors;
import System_Design.G_Elevator_Design.InternalButtons.InternalButtons;
import System_Design.G_Elevator_Design.Status.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Building {

    public int NumofFloors;
   public List<Floors> floors;

   HashMap<Integer, ElevatorController>ElevatorManagementBox=new HashMap<>();
   HashMap<Integer, ElevatorCar>elevatorMap=new HashMap<>();
   Scanner sc;

    public Building(int NumofFloors){
        this.NumofFloors=NumofFloors;
        floors= new ArrayList<>(NumofFloors);
        sc = new Scanner(System.in);
        MakeFloors();
        MakeElevatorCars();
    }


    public void MakeFloors(){

        for(int i=0; i<NumofFloors; i++){

            ExternalButtons externalButtons = new ExternalButtons();
            Floors floor = new Floors(i, externalButtons);
            floors.add(floor);
        }
    }
    public void MakeElevatorCars(){

        // Okay so we are making 2 Lifts and 2 Controllers-

        for(int i=0; i<2; i++){
            System.out.println("Enter the ElevatorCarId ");
            int elevatorcarId = sc.nextInt();

            Display display = new Display();
            InternalButtons internalButtons = new InternalButtons();
            ElevatorCar elevatorCar = new ElevatorCar(elevatorcarId,display,Status.Moving, "UP", internalButtons);
            ElevatorController elevatorController = new ElevatorController(elevatorcarId, elevatorCar);

            ElevatorManagementBox.put(elevatorcarId , elevatorController);
            elevatorMap.put(elevatorcarId, elevatorCar);

            elevatorController.moveCar();
        }
    }


    public void CompleteAllRequestsofUsers(){

        // user-1 : came and press lift1 to go from from 2 to floor 4 and direction is up.
        System.out.println("Choose By which Lift Number You want to Go -");
        int liftNo = sc.nextInt();
        System.out.println("Enter the Floor Number:- ");
        int floorNumber = sc.nextInt();
        System.out.println("Enter the Direction You want to Go :- ");
        String dir = sc.next();
        SubmitRequestofUser(liftNo, floorNumber , dir, "EXT");

    }


    public void SubmitRequestofUser(int LiftNo, int floorNumber , String direction, String fn){

        Floors f = floors.get(floorNumber);
        ElevatorCar elevatorCar = elevatorMap.get(LiftNo);

        if(fn.equals("EXT")) f.exteranalButton.PressButton(LiftNo, floorNumber, direction,ElevatorManagementBox);
        else elevatorCar.internalButtons.PressButton(LiftNo, floorNumber, direction, ElevatorManagementBox);



    }




}
