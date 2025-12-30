package System_Design_Sanket_V2.LLD.A_Solid_Priciples.OCP.Bad_Code;

import java.util.List;

/**
 * In this example, the PaymentMethod class violates the Open/Closed Principle because
 * it requires modification whenever a new payment method is added. Each time a new
 * payment method is introduced, the makePayment method must be changed to include
 * the new payment type, leading to potential bugs and maintenance issues.
 * To adhere to the Open/Closed Principle, we could refactor the code to use an interface or abstract class for payment methods,
 * allowing new payment methods to be added without modifying existing code.
 *
 * **/
public class PaymentMethod {

    public static void makePayment(List<String>payments, double amount){
        for(String payment : payments){
            if(payment.equals("CREDIT_CARD")){
                CreditCard c = new CreditCard();
                System.out.println("Processing credit card payment of " + amount);
                c.makePayment("user", amount, "CREDIT_CARD");
            } else if(payment.equals("DEBIT_CARD")){
                DebitCard d = new DebitCard();
                System.out.println("Processing debit card payment of " + amount);
                d.makePayment("user", amount, "DEBIT_CARD");
            } else if(payment.equals("UPI")){
                System.out.println("Processing UPI payment of " + amount);
                UPI u = new UPI();
                u.makePayment("user", amount, "UPI");
            }else {
                System.out.println("Unknown payment method");
            }
        }
    }

    public static void main(String[] args) {


    }
}
