package System_Design.B_Observer_Design_Pattern.Observable;

import System_Design.B_Observer_Design_Pattern.Observer.NotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class CargoObservable implements StocksObservable{

    List<NotificationObserver>observers = new ArrayList<>();
    int stockCount = 0;
    public void add(NotificationObserver ob){
        observers.add(ob);
    }

    public void remove(NotificationObserver ob){
        observers.remove(ob);
    }

    public void notifySubscribers(){

        for(NotificationObserver obs : observers){
            obs.update("Cargo Pents are Available Now");
        }
    }

    public void setStockCount(int newCount){

        if(stockCount==0){
            notifySubscribers();
        }
        stockCount+=newCount;
    }

    public int getStockCount(){

        return stockCount;
    }

}
