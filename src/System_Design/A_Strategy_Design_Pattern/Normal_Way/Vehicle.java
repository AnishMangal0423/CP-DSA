package System_Design.A_Strategy_Design_Pattern.Normal_Way;

public class Vehicle {

    void Drive(){
        System.out.println("Normal Vehicle-Drive Class");
    }
    public static void main(String[] args) {


        Vehicle v1 = new Vehicle();
        v1.Drive();
        v1= new Sports_Vehicle();
        v1.Drive();
        v1=new Passenger_vehicle();
        v1.Drive();
        v1=new Off_Roading_Vehicle();
        v1.Drive();


    }
}
