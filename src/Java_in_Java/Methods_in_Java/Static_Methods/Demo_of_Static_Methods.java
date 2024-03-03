package Java_in_Java.Methods_in_Java.Static_Methods;

import jdk.swing.interop.DispatcherWrapper;

/**
 *
 * Concepts :- Static variables, Static Methods.
 *
 * Printed the All the combinations of static or Non static Variables and Methods.
 * and Demo of changing the static variables.
 *
 * We can see Static is of class , not of objects.
 * and statics are shared in common area.
 *
 * And if some variables will change the value then the value of all objects will change.
 *
 * **/
public class Demo_of_Static_Methods{
      int a = 100;
      static  int b = 200;
      static int c = 300;

      public int sum(){
          return  a + b;
      }

      public static int sum1(){
          return b + c;
      }

    public static int sum2(){
//        return a + c;    --> giving error because Static referencing to Non static reference.
        return -1;
    }

    public void Display(){
        System.out.println(a + " "+ b+" "+ c);
    }


    public static void main(String[] args) {

        System.out.println(Demo_of_Static_Methods.sum1());   // Calling the Functions by class Name.
        Demo_of_Static_Methods obj1 = new Demo_of_Static_Methods();
        Demo_of_Static_Methods obj2 = new Demo_of_Static_Methods();

        obj1.b = 10;
        System.out.println(obj1.sum1());
        System.out.println(obj2.sum1());

    }


    /***
     *
     *     Mtd                              Variables                        Result
     *     Static                           static                           ok
     *     Static                           Non static                       No Error
     *     Non static                       static                           ok
     *     Non static                       Non static                       ok
     *
     *
     * */


}
