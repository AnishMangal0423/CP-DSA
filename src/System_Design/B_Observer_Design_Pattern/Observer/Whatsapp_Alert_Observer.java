package System_Design.B_Observer_Design_Pattern.Observer;

import System_Design.B_Observer_Design_Pattern.Observable.StocksObservable;

public class Whatsapp_Alert_Observer implements NotificationObserver {

    String pno;
    StocksObservable observable;

    public Whatsapp_Alert_Observer(String pno, StocksObservable observable){
        this.pno=pno;
        this.observable=observable;
    }

    public void update(String msg){
        NotifyViaMessage(pno, msg);
    }

    public void NotifyViaMessage(String pno, String msg){
        System.out.println("Message is sent to the : " + pno +"Phone Number, Go and Buy your Product! "+msg);
    }
}
