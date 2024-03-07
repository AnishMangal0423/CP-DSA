package Java_in_Java.Interfaces_in_Java.CringeOf_Java8;

/**
 *
 *
 * What i Want to convey is the -
 * 1. Extension of Interfaces and child interfaces.
 * 2. Extension of default and defination methods.
 * 3. how a defalut method can become abstarct again also.
 *
 *
 * **/
interface f1{

    void m1();
    default void m2(){
        System.out.println("I am in a Interface 1 and exploring the things..");
    }
}

interface f2 extends f1{

    void m1();

    void m2();                                  // It had made m2 function again abstarct.

    default void m3(){
        System.out.println("Hii i am in Interface 2, and felling ok..");
    }


    void m4();
}
interface f3 extends f2{

      default void m1(){
          System.out.println(" I am in Interface 3");
      }

      default void m2(){
          System.out.println("I am in Interface 3");
      }

      default void m4(){
          System.out.println(" I am in Interfaces 3");
      }

}


class c1 implements f3{

}

public class Extending_the_Interfaces{

    public static void main(String[] args) {

         c1 c = new c1();
         c.m4();


         f2 f2 = c;      // Good to see it's Output., f2 has access to all 4 fns but it will give output of whenever it is invoked.
         f2.m2();
         f2.m3();


         f1 f1 = c;
         f1.m1();
    }
}
