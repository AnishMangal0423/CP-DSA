package System_Design.G_Elevator_Design.InternalButtons;

import System_Design.G_Elevator_Design.ElevatorController.ElevatorController;
import System_Design.G_Elevator_Design.ExternalButtons.ExternalButtonDispatcher;

import java.util.HashMap;

public class InternalButtons {

   InternalButtonsDispatcher internalButtonsDispatcher;

   public InternalButtons(){
      internalButtonsDispatcher=new InternalButtonsDispatcher();
   }
   public void PressButton(int LiftId, int floorNumber , String Direction, HashMap<Integer, ElevatorController> ElevatorManagementBox){

      internalButtonsDispatcher.SubmitRequest(LiftId, floorNumber, Direction, ElevatorManagementBox);
   }
}
