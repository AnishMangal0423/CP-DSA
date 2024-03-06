package Java_in_Java.Classes_in_Java.Singleton_Classes;

/**
 *
 * Isme sab thekk h bas baat itni si kharab h ki , static wali memory hoti h wo bhaut jaldi Load ho jati h , so agar
 * kisi ne getInstance() call hi nhi kiya tab bhi, ek singleton class ka obj bn gya h, THta is completely wastage.
 *
 * **/
class B{

    int a = 10;

    static private B obj = new B();
    private B(){
    }

    static B getInstance(){
        return obj;
    }
}
public class Eager_Intilization{

    public static void main(String[] args) {

//        System.out.println(B.obj);    --> Giving error because My obj is Private.
        B obj1 = B.getInstance();
        B obj2 = B.getInstance();
        B obj3 = B.getInstance();

        if(obj1 == obj2 && obj2 == obj3){
            System.out.println("All objects are just refrencing to that singele static obj only ");
        }

        System.out.println(obj1.a);
    }
}
