package System_Design.G_Elevator_Design.InternalButtons;

import System_Design.G_Elevator_Design.ElevatorController.ElevatorController;
import java.util.*;

public class InternalButtonsDispatcher {

    public void SubmitRequest(int LiftId, int floorNumber , String Direction, HashMap<Integer, ElevatorController> ElevatorManagementBox){

        ElevatorController elevatorController = ElevatorManagementBox.get(LiftId);
        elevatorController.AcceptRequest(floorNumber, Direction);
    }

}
