package Java_in_Java.Classes_in_Java.Nested_Classes.Non_Static_Nested_Classes;

class Outer2{

    int a = 1;
    static int b = 2;

    void GotoInner(){
        int c = 10;

        class LocalInner{                       // Local class in a Function. can't be public, protected, .. bcz it is in A local block
            static int d = 20;

            void  display(){

                System.out.println("Inside Local Inner Class..");
                System.out.println(a +" "+b+" "+c+" "+d);
            }
        }


        LocalInner l = new LocalInner();
        l.display();

    }

}
public class Local_Inner_Classes {
    public static void main(String[] args) {

        Outer2 o = new Outer2();
        o.GotoInner();
    }
}
