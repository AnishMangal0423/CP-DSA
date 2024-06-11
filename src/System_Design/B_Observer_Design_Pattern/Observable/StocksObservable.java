package System_Design.B_Observer_Design_Pattern.Observable;

import System_Design.B_Observer_Design_Pattern.Observer.NotificationObserver;

public interface StocksObservable {

    public void add(NotificationObserver ob);

    public void remove(NotificationObserver ob);

    public void notifySubscribers();

    public void setStockCount(int setCount);

    public int getStockCount();


}
