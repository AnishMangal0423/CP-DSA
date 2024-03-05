package Java_in_Java.Classes_in_Java.Nested_Classes.Static_Nested_Classes;

class Outers{

    int x = 10;
    static int y = 20;
   private static class Inner{            // Private , public, protected, default all are allowed.

        void display(){
            System.out.println(y + " Inside the Inner Classes");
        }
    }

    public void MakeInnerObj(){
       Inner i = new Inner();
       i.display();
    }
}
public class Private_Nested_Demo2 {

    public static void main(String[] args) {

        Outers o = new Outers();
        o.MakeInnerObj();
    }
}
