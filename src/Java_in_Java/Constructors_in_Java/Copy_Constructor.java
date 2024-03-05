package Java_in_Java.Constructors_in_Java;

class Animal{
    int a;
    int b;

    Animal(int a, int b){
        this.a = a;
        this.b =b;
    }

    // Now making the copy Constructor-
    Animal(Animal ani){
        this.a = ani.a;
        this.b = ani.b;
    }

}
public class Copy_Constructor {

    public static void main(String[] args) {

        Animal anish = new Animal(2, 3);        // Normal constructor called.
        System.out.println(anish.a +" "+ anish.b);

        Animal shakib = new Animal(anish);              // Copy constructor called.
        System.out.println(shakib.a + " "+ shakib.b);


        Animal kushagra = anish;
        System.out.println(kushagra);          //Now here we can Understnad that Kushagra is Not making the
        System.out.println(anish);             // New obj it is only referencing to anish obj .

    }

}
