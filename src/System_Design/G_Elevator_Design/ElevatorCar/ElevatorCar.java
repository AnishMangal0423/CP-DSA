package System_Design.G_Elevator_Design.ElevatorCar;

import System_Design.G_Elevator_Design.Directions.Directions;
import System_Design.G_Elevator_Design.DisplayBoard.Display;
import System_Design.G_Elevator_Design.InternalButtons.InternalButtons;
import System_Design.G_Elevator_Design.Status.Status;

public class ElevatorCar {

   public int ElevatorCarid;

    public Display display;

    public int currentfloor=0;
    public Status status;

    public String directions;

   public InternalButtons internalButtons;

    public ElevatorCar(int elevatorcarId, Display display, Status status, String direction, InternalButtons internalButtons) {

        this.ElevatorCarid=elevatorcarId;
        this.display=display;
        this.status=status;
        this.directions=direction;
        this.internalButtons=internalButtons;
    }
}
