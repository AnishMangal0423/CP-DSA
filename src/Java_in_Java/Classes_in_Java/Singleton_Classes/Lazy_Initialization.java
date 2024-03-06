package Java_in_Java.Classes_in_Java.Singleton_Classes;


class A{

    int a = 10;

    static private A obj = null;
    private A(){
    }

    static A getInstance(){

        if(obj == null){
            obj = new A();
        }
        return obj;
    }
}
public class Lazy_Initialization{

    public static void main(String[] args) {

//        System.out.println(A.obj);    --> Giving error because My obj is Private.
       A obj1 = A.getInstance();
       A obj2 = A.getInstance();
       A obj3 = A.getInstance();

        if(obj1 == obj2 && obj2 == obj3){
            System.out.println("All objects are just refrencing to that singele static obj only ");
        }

        System.out.println(obj1.a);
    }
}
