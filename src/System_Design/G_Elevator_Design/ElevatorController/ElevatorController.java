package System_Design.G_Elevator_Design.ElevatorController;

import System_Design.G_Elevator_Design.ElevatorCar.ElevatorCar;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class RequestObjects{
    int floorNumber;
    String Direction;


    RequestObjects(int f, String direction){
        this.floorNumber=f;
        this.Direction=direction;
    }
}
public class ElevatorController {

    int ElevatorControllerId;
    ElevatorCar elevatorCar;

    // -- Algo's

    PriorityQueue<RequestObjects>minPq=new PriorityQueue<>((a, b)->{
        if(a.floorNumber!=b.floorNumber)return a.floorNumber-b.floorNumber;
        return 0;
    });

    PriorityQueue<RequestObjects>maxpq = new PriorityQueue<>((a, b)->{
        if(a.floorNumber!=b.floorNumber) return b.floorNumber-a.floorNumber;
        return 0;
    });

    Queue<RequestObjects>pendings = new LinkedList<>();

    public ElevatorController(int id, ElevatorCar car){
        this.ElevatorControllerId = id;
        this.elevatorCar=car;
    }

    public void AcceptRequest(int floorNumber , String direction) {
        // Give - Algo's.

        // Sabse phle to elevator ki actual direction dekho.
        String elevatorDirection = elevatorCar.directions;
        int elevatorFloorLevel = elevatorCar.currentfloor;

        if(elevatorDirection.equals(direction)){
            if(floorNumber >= elevatorFloorLevel){
                minPq.add(new RequestObjects(floorNumber , direction));
            }

            else{
                pendings.add(new RequestObjects(floorNumber, direction));
            }
        }

        else{

            maxpq.add(new RequestObjects(floorNumber, direction));
        }
moveCar();
//        System.out.println();
        // agar jo request aayi h aur fulfill ho sakti h too min/max stack mai daloo
        // else pending mai dalo
    }

    public void moveCar() {
        while (minPq.size() > 0 || maxpq.size() > 0 || pendings.size() > 0) {
            String elevatorDirection = elevatorCar.directions;
            int elevatorFloorLevel = elevatorCar.currentfloor;

            if (elevatorDirection.equals("UP")) {
                while (!minPq.isEmpty()) {
                    RequestObjects front = minPq.poll();
                    try {
                        // Simulate the elevator moving to the next floor with a 2-second delay
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    elevatorFloorLevel = front.floorNumber;
                    System.out.println("Lift is Stopped at Floor No : " + front.floorNumber + " Direction is Up");
                }

                // Change direction
                while (!pendings.isEmpty()) {
                    minPq.add(pendings.poll());
                }
                elevatorCar.directions = "DOWN";
            }

            if (elevatorDirection.equals("DOWN")) {
                while (!maxpq.isEmpty()) {
                    RequestObjects front = maxpq.poll();
                    try {
                        // Simulate the elevator moving to the next floor with a 2-second delay
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    elevatorFloorLevel = front.floorNumber;
                    System.out.println("Lift is Stopped at Floor No : " + front.floorNumber + " Direction is Down");
                }

                // Change direction
                while (!pendings.isEmpty()) {
                    maxpq.add(pendings.poll());
                }
                elevatorCar.directions = "UP";
            }
        }

        System.out.println("All Requests are Completed and Now Lift is in Idle Condition");
        return;
    }
}
