package System_Design.D_Factory_Design_Pattern.Abstract_Factory_Design.MainFactory;

import System_Design.D_Factory_Design_Pattern.Abstract_Factory_Design.VehicleFactory.Luxuary_Factory;
import System_Design.D_Factory_Design_Pattern.Abstract_Factory_Design.VehicleFactory.OrdinaryFactory;
import System_Design.D_Factory_Design_Pattern.Abstract_Factory_Design.VehicleFactory.VehicleFactory;

public class Factory{

  public VehicleFactory getVehicleFactory(String input1){

      switch (input1){
          case "LUXIORIOUS" : return new Luxuary_Factory();
          case "ORDINARY" : return new OrdinaryFactory();
          default:return null;
      }
  }
}

