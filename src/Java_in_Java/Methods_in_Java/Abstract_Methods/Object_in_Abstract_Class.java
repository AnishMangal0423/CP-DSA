package Java_in_Java.Methods_in_Java.Abstract_Methods;

/***
 *
 *
 * Object of Abstract class is Not possible , but Object of Extended Class can Be made and abstarct class can have Constructor.
 * */

abstract class Anish{

    int a;

    Anish(int a){
        this.a=a;
    }

    abstract void Eat();
}

class Tushar extends Anish{

    Tushar(int a){
        super(a);
    }
    @Override
    void Eat(){
        System.out.println("I can eat");
    }
}
public class Object_in_Abstract_Class {
    public static void main(String[] args) {

        Anish obj = new Tushar(10);
        System.out.println(obj.a);
    }
}
