package Java_in_Java.Oops.Inheritance;


class class1{

    private int a;
    private int b;

    class1(int aa, int bb){

        System.out.println("class 1 consructor");
        this.a=aa;
        this.b=bb;
    }

    int getA(){
        return a;
    }

    int getB(){
        return b;
    }
}

class class2 extends class1{

    int c;
    int d;

    class2(int a, int b, int c, int d){

        super(a, b);
        System.out.println("class 2 consructor");
        this.c=c;
        this.d=d;
    }
}

class class3 extends class2{


    int e;
    int f;

    class3(int a,int b, int c, int d, int e, int f){
        super(a, b, c, d);
        System.out.println("class 3 consructor");
        this.e=e;
        this.f=f;
    }


}
public class MultiLevel_Inheritance{

    public static void main(String[] args) {


        class3 c3 = new class3(2,3,4,5,6,7);

        System.out.println(c3.c);
        System.out.println(c3.d);
        System.out.println(c3.e);

        System.out.println(c3.getA());
        System.out.println(c3.getB());

    }
}
