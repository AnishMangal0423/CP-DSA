package System_Design.A_Strategy_Design_Pattern.System_Design_Way;

public class Main {

    public static void main(String[] args) {

        Vehicle v1 = new Normal_Vehicle();
        v1.drive();

        v1  = new Off_Roading_vehicle();
        v1.drive();

        v1 = new xyz_vehicle();
        v1.drive();
    }
}
