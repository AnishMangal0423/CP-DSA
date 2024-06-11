package System_Design.C_Decorator_Design_Pattern.Topped_Pizza;

//import System_Design.C_Decorator_Design_Pattern.Base_Pizza.Base_Pizza;

import System_Design.C_Decorator_Design_Pattern.Base_Pizza.Base_Pizza;

public class Mushroom_Pizza implements Base_Pizza {

    Base_Pizza b;

    public Mushroom_Pizza(Base_Pizza b){
        this.b=b;
    }
    public int cost(){
        return b.cost()+30;
    }
}
