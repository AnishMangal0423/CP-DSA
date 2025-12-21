package System_Design_Sanket_V2.LLD.A_Solid_Priciples.SRP.BadCode;

/**
 * All Logic in a single class Violating SRP.
 * so if any logic needs to be changed we have to change in this class only.
 * So to follow SRP we need to separate the logic into different classes.
 * **/
public class Booking {

    public static void bookFlight(String user, String flightDetails){
        // Booking logic
        System.out.println("Booking flight for " + user);
        // Payment processing logic
        System.out.println("Processing payment for " + user);
        // Notification logic
        System.out.println("Sending notification to " + user);
    }

    public static void PaymentProcessing(String user, double amount){
        // Payment processing logic
        System.out.println("Processing payment of " + amount + " for " + user);
    }


    public static void sendNotification(String user, String message){
        // Notification logic
        System.out.println("Sending notification to " + user + ": " + message);
    }


    public static void main(String[] args) {

        String user = "John Doe";
        String flightDetails = "Flight 123 from A to B";
        double amount = 299.99;
        String message = "Your flight has been booked successfully!";

        bookFlight(user, flightDetails);
        PaymentProcessing(user, amount);
        sendNotification(user, message);

    }
}
