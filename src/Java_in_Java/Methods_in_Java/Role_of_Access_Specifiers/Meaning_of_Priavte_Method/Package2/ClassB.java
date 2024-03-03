package Java_in_Java.Methods_in_Java.Role_of_Access_Specifiers.Meaning_of_Priavte_Method.Package2;

import Java_in_Java.Methods_in_Java.Role_of_Access_Specifiers.Meaning_of_Priavte_Method.Package1.ClassA;


/***
 *
 * Let supoose we have Supreme Court and it does Not want to disclose the Case with any High Court and Other teams of
 * Supreme Court , only Judge knows it.
 *
 * So in Private Specifires we can't Import the methods or Buttons of Other class , onjects and then using there methods.
 * Accessibity :- Only in Same Class only.
 * **/

public class ClassB {

   private void Name(){
        System.out.println("In class B");
    }

    public static void main(String[] args) {

       ClassB b = new ClassB();
       b.Name();


        ClassA a = new ClassA();
//        a.Name();     --> It is Giving Errror.


        ClassC c = new ClassC();
//        c.Name();    --> It is Giivng error.

    }
}
