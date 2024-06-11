package System_Design.C_Decorator_Design_Pattern;

//import System_Design.C_Decorator_Design_Pattern.Base_Pizza.Base_Pizza;
import System_Design.C_Decorator_Design_Pattern.Base_Pizza.*;
import System_Design.C_Decorator_Design_Pattern.Topped_Pizza.Chesse_Pizza;
import System_Design.C_Decorator_Design_Pattern.Topped_Pizza.Mushroom_Pizza;
import System_Design.C_Decorator_Design_Pattern.Topped_Pizza.OTC_Pizza;

public class Restaurant {

    public static void main(String[] args) {

        Base_Pizza b1 = new Wheat_Pizza();

        Base_Pizza t1 = new Mushroom_Pizza(b1);
        Base_Pizza t2 = new OTC_Pizza(t1);
        Base_Pizza t3 = new Chesse_Pizza(t2);
        System.out.println("Normal Margethita Base Pizza Cost ?: " + b1.cost());
        System.out.println("Base Pizza + Mushrrom Pizza ?: "+ t1.cost());
        System.out.println("Base + Mushrrom + OTC cost ?: " +t2.cost());
        System.out.println("Base + Mushroom + OTC + Cheese Cost ?: " +t3.cost());
    }
}
