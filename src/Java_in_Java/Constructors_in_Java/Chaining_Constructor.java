package Java_in_Java.Constructors_in_Java;

class Base{
    int a;
    int b;

    Base(int a, int b){
        System.out.println("I am in Base class ");
        this.a= a;
        this.b = b;
    }
}

class Child extends Base{
    int c;
    int d;

    Child(int a, int b, int c, int d){
        super(a, b);
        System.out.println("I am in Child Class");
        this.c = c;
        this.d = d;
    }
}
public class Chaining_Constructor{

    public static void main(String[] args) {

        Child c = new Child(2,3,4,5);
        System.out.println(c.a);
        System.out.println(c.b);
        System.out.println(c.c);
        System.out.println(c.d);
    }
}
