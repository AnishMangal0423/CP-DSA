package Java_in_Java.Methods_in_Java.Static_Methods;

class Base{
    static void display(){
        System.out.println("I am in Base Class");
    }
}
/**
 *
 * I am not able to understand more but ha .. static ka matlb to atleast samaj agya
 *
 * **/
public class Static_Methods_and_Overriding extends Base{

    static void display(){
        System.out.println("I am in Child Class");
    }
    public static void main(String[] args) {

        Base.display();
        Static_Methods_and_Overriding.display();


        Base b = new Base();
        Base obj1 = new Static_Methods_and_Overriding();
        obj1.display();
        b.display();

    }
}
