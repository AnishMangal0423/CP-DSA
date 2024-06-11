package System_Design.C_Decorator_Design_Pattern.Topped_Pizza;

//import System_Design.C_Decorator_Design_Pattern.Base_Pizza.Base_Pizza;

import System_Design.C_Decorator_Design_Pattern.Base_Pizza.Base_Pizza;

public class OTC_Pizza implements Base_Pizza {

    Base_Pizza b;

    public OTC_Pizza(Base_Pizza b){
        this.b=b;
    }
    public int cost(){
        return b.cost()+20;
    }
}
