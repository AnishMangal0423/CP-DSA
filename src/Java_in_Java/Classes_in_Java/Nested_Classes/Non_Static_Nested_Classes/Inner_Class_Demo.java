package Java_in_Java.Classes_in_Java.Nested_Classes.Non_Static_Nested_Classes;

class Outer{

    int x = 10;
    static int y = 20;
    class Inner{
         void display(){
             System.out.println("We are in Non-static Inner class "+x + " "+ y);
         }
    }
}
public class Inner_Class_Demo{
    public static void main(String[] args) {

        Outer o = new Outer();
        Outer.Inner i = o.new Inner();
        i.display();

    }
}
