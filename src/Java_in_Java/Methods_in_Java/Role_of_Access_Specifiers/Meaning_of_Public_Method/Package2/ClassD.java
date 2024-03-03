package Java_in_Java.Methods_in_Java.Role_of_Access_Specifiers.Meaning_of_Public_Method.Package2;

import Java_in_Java.Methods_in_Java.Role_of_Access_Specifiers.Meaning_of_Public_Method.Package1.ClassB;

/**
 *
 * What is the Significance of Doing these --
 * .........................................
 *
 * 1. Lets suppose we are Making TV and we want some Digital Buttons of same as AC
 *    - One way is to Make the team for making the Digital Buttons.
 *    - Another Method is to do tie-up with Ac firm and they will say , hey we are Public to use , anyone
 *      Can use us Freely ,, Only you make the Object (Purchase the button) and use its functionalities and
 *      Stick to your Device and Use them.
 *
 *     So the sprit is you can access to any Public mtd and its Functionalities By creating the obj of that class.
 * ***/

public class ClassD {
    void Address(){
        System.out.println(" You are in Class D ");
    }

    public static void main(String[] args) {

        /** Here we can see that You can callto any method of Any package and class , by having Public specifier to that
         Method and always declare public to the methods , otherwise it will take it as Default and give error let suppose
         You remove public from B Class Name function.

         **/
        ClassB b = new ClassB();
        b.Name();

        /***
         * From same Package Class..
         * **/

        ClassC c = new ClassC();
        c.Address();

    }
}
