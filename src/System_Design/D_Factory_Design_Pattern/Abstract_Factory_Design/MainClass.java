package System_Design.D_Factory_Design_Pattern.Abstract_Factory_Design;

import System_Design.D_Factory_Design_Pattern.Abstract_Factory_Design.MainFactory.Factory;
import System_Design.D_Factory_Design_Pattern.Abstract_Factory_Design.VehicleFactory.VehicleFactory;
import System_Design.D_Factory_Design_Pattern.Abstract_Factory_Design.Vehicles.Vehicle;

public class MainClass {

    public static void main(String[] args) {

        Factory f1 = new Factory();   // Normal Main Factory Object.
        VehicleFactory lf1 = f1.getVehicleFactory("LUXIORIOUS");    // --> Luxiorious Factory
        VehicleFactory of1 = f1.getVehicleFactory("ORDINARY");      // --> Ordinary Factory

        Vehicle v1 = lf1.TypeofVehicle("BMW");   // --> Finding Vechile in Factories.
        Vehicle v2 = of1.TypeofVehicle("SWIFTDEZIRE");  // --> Finding Vechile in Factories.

        v1.Type();  // --> Calling Type .
        v2.Type();


        /**
         *
         * So the architecture of Abstract Factory design Pattern is :-
         *
         * Main Class --->  MainFactory class  --> VehicleFactoryInterface  ----> Vehicle Interface.
         *
         *
         *
         * **/
    }
}
