package System_Design.B_Observer_Design_Pattern.Observer;

import System_Design.B_Observer_Design_Pattern.Observable.StocksObservable;

public class Email_Alert_Observer implements NotificationObserver {

    String email;
    StocksObservable observable;

    public Email_Alert_Observer(String emailId, StocksObservable observable){
        this.email=emailId;
        this.observable=observable;
    }

    public void update(String msg){
        NotifyViaEmail(email, msg);
    }

    public void NotifyViaEmail(String Email, String msg){
        System.out.println("Email is sent to : " + Email+" Go and Buy your Product, "+ msg);
    }
}
