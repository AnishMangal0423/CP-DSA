package System_Design_Sanket_V2.LLD.A_Solid_Priciples.OCP.GoodCode;

import System_Design_Sanket_V2.LLD.A_Solid_Priciples.OCP.Bad_Code.PaymentMethod;
import java.util.List;

/**
 * In this improved version, we define a PaymentType interface that declares a makePayment method.
 * Each payment method (CreditCard, DebitCard, UPI) implements this interface and provides its own payment processing logic.
 * The PaymentManager class can now work with any payment method that implements the PaymentType interface,
 * adhering to the Open/Closed Principle by being open for extension but closed
 * **/
public class PaymentManager {

    public static void makePayment(List<PaymentType>payments, String user, double amount){
        for(PaymentType payment : payments){
            payment.makePayment(user, amount);
        }
    }
    public static void main(String[] args) {


    }
}
