package Java_in_Java.Classes_in_Java.Nested_Classes.Static_Nested_Classes;
import  java.lang.*;

/**
 *
 * Yrr ye samajna h ki bhaar.anderclassobj.display() , kyu hua.. too phle ye samjo
 *
 * class a{
 *     static display(){}
 *     dis(){}
 * }
 *
 * 2 methods h agar display ko call krna h too direct hi ho jayega , a.display(), kyuki ye class ka method h obj ka nhi.
 * par dis(){}, obj ka mtd h class ka nhi.
 *
 *
 * isi trah wo bhi outer class ki class h instance ki nhi.. same vice versa.
 *
 * **/


class Outer{

    int x = 10;
    static int y = 20;
    static class Inner{

        void display(){
//            System.out.println(x + " "+ y);    --> Giving errror , Static and Non-Static variables.
            System.out.println(y + " Inside the Inner Classes");
        }
    }
}
public class Demo1{
    public static void main(String[] args) {

        // Invoking the Object of Inner class-

        Outer.Inner i = new Outer.Inner();
        i.display();


    }
}
