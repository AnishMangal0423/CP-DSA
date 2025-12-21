package System_Design_Sanket_V2.LLD.A_Solid_Priciples.SRP.GoodCode;

/**
 * With SRP principle each class has its own responsibility.
 * So if any logic needs to be changed we can change in that particular class only.
 *
 * **/
public class Booking {

    Payment payment;
    Notification notification;

    public Booking(){
        this.payment = new Payment();
        this.notification = new Notification();
    }
    public static void bookFlight(String user, String flightDetails){
        // Booking logic
        System.out.println("Booking flight for " + user);
    }


    public static void main(String[] args) {

        String user = "John Doe";
        String flightDetails = "Flight 123 from A to B";
        double amount = 299.99;
        String message = "Your flight has been booked successfully!";

        Booking booking = new Booking();
        booking.bookFlight(user, flightDetails);
        booking.payment.processPayment(user, amount);
        booking.notification.sendNotification(user, message);
    }
}
