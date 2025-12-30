package System_Design_Sanket_V2.LLD.A_Solid_Priciples.OCP.GoodCode;

public class CreditCard implements PaymentType{

    public void makePayment(String user, double amount){
        // Payment processing logic
        System.out.println("Processing credit card payment of " + amount + " for " + user);
    }
    public static void main(String[] args) {

    }
}
