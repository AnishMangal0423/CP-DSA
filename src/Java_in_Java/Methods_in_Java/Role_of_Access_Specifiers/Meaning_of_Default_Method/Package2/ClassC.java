package Java_in_Java.Methods_in_Java.Role_of_Access_Specifiers.Meaning_of_Default_Method.Package2;

import Java_in_Java.Methods_in_Java.Role_of_Access_Specifiers.Meaning_of_Default_Method.Package1.ClassA;

public class ClassC {

    void Name(){

        System.out.println("Hii i am In Class C");
    }
    public static void main(String[] args) {

        ClassC c = new ClassC();
        c.Name();


        ClassD d = new ClassD();
        d.Name();

        ClassA a = new ClassA();
//        a.Name();      --> Giving Error becuase in Default only same Package classes are Allowed to access.

    }
}
