package System_Design.B_Observer_Design_Pattern;

import System_Design.B_Observer_Design_Pattern.Observable.CargoObservable;
import System_Design.B_Observer_Design_Pattern.Observable.StocksObservable;
import System_Design.B_Observer_Design_Pattern.Observable.SunscreenObservable;
import System_Design.B_Observer_Design_Pattern.Observer.Email_Alert_Observer;
import System_Design.B_Observer_Design_Pattern.Observer.NotificationObserver;
import System_Design.B_Observer_Design_Pattern.Observer.Whatsapp_Alert_Observer;

public class store {

    public static void main(String[] args) {

        StocksObservable Observable1 = new SunscreenObservable();
        StocksObservable Observable2 = new CargoObservable();

        NotificationObserver obs1 = new Email_Alert_Observer("anishm0423@gmail.com", Observable1);
        NotificationObserver obs2 = new Whatsapp_Alert_Observer("9413504733", Observable1);

       Observable1.add(obs1);
       Observable1.add(obs2);

       Observable1.setStockCount(2);
        Observable1.setStockCount(2);


        Observable2.add(obs1);
        Observable2.add(obs2);

        Observable2.setStockCount(2);
    }
}
