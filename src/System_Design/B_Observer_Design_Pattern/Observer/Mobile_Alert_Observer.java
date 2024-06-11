package System_Design.B_Observer_Design_Pattern.Observer;


import System_Design.B_Observer_Design_Pattern.Observable.StocksObservable;

public class Mobile_Alert_Observer implements NotificationObserver {

    String userName;
    StocksObservable observable;

    public Mobile_Alert_Observer(String userName , StocksObservable observable){
        this.userName=userName;
        this.observable=observable;
    }

    public void update(String msg){
        NotifyViaMessage(userName, msg);
    }

    public void NotifyViaMessage(String userName, String msg){
        System.out.println("Message is sent to the : " + userName+"userName, Go and Buy your Product! "+msg);
    }
}
