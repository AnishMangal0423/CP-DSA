package System_Design_Sanket_V2.LLD.A_Solid_Priciples.OCP.Bad_Code;

public class UPI {
    public void makePayment(String user, double amount, String paymentType){
        // Payment processing logic
        System.out.println("Processing " + paymentType + " payment of " + amount + " for " + user);
    }
    public static void main(String[] args) {

    }
}
