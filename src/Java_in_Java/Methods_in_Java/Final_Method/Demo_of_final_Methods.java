package Java_in_Java.Methods_in_Java.Final_Method;

/***
 *
 * WhenEver we see something as Final we cannot chnage there Values .. or override them .. we can only call them.
 * */

class Base{
    final void display(){
        System.out.println("I am in Base Class.. ");
    }
}
public class Demo_of_final_Methods extends Base{

//    void display(){
//
//        System.out.println("I am in Child class");         ---> Now giving error saying that overRiden method
 //                                                               is Final and we cannot chnage the final Declaration.
//    }
    public static void main(String[] args) {


    }
}
