package System_Design.G_Elevator_Design.ExternalButtons;

import System_Design.G_Elevator_Design.ElevatorController.ElevatorController;

import java.util.HashMap;

public class ExternalButtons {

    ExternalButtonDispatcher externalButtonDispatcher;

   public ExternalButtons(){
        externalButtonDispatcher=new ExternalButtonDispatcher();
    }
    public void PressButton(int LiftId, int floorNumber , String Direction, HashMap<Integer, ElevatorController> ElevatorManagementBox){

         externalButtonDispatcher.SubmitRequest(LiftId, floorNumber, Direction, ElevatorManagementBox);
    }


}
