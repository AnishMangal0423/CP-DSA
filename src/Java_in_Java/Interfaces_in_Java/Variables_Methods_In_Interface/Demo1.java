package Java_in_Java.Interfaces_in_Java.Variables_Methods_In_Interface;

interface Area{

    double PIE = 3.14;
    int X = 2;                   // --> Beacuse these all are static final , we should use UpperCase.

//    private void Length();      // Giving error that make the body and use it in interface or also make public fn and use it everywhere.

    public void Length();

}

class Square implements Area{

    @Override
    public void Length() {
        System.out.println("Area of Square ");
    }
}
public class Demo1{

    public static void main(String[] args) {

        Area a = new Square();
        System.out.println(Area.X);
        System.out.println(Area.PIE);
        a.Length();
    }
}
