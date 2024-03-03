package Java_in_Java.Methods_in_Java.Role_of_Access_Specifiers.Meaning_of_Protected_Method.Package2;

import Java_in_Java.Methods_in_Java.Role_of_Access_Specifiers.Meaning_of_Protected_Method.Package1.ClassA1;
import Java_in_Java.Methods_in_Java.Role_of_Access_Specifiers.Meaning_of_Protected_Method.Package2.ClassC;
import Java_in_Java.Methods_in_Java.Role_of_Access_Specifiers.Meaning_of_Protected_Method.Package1.ClassA;

public class ClassB extends ClassA1 {

    protected void Name(){
        System.out.println(" You are in Class B ");
    }


    public static void main(String[] args) {

        ClassB b = new ClassB();       // Same Class , Allowed to access.
        b.Name();


        ClassC c = new ClassC();      // Same Package Classes are allowed.
        c.Name();


        ClassA a = new ClassA();           // Different Package Class are only Allowed when it is child only.
//        a.Name();     --> Giving error.


        Address();   // Allowed because first it Become child.

    }
}
