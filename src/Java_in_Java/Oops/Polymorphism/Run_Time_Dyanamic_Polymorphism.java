package Java_in_Java.Oops.Polymorphism;

/**
 *
 * It is Called Run time p.. because which overridded method is executed it wholesly depends of which class obj it is.
 * and In Modern Java object creation happens on Run time., so...
 *
 * Byte code is written at compile time , but decision is made at Run-time.
 * **/

class Base{

    void Display(){
        System.out.println("Hii I am in Base class fn");
    }
}

class Derived extends Base{

    int a=50;
    void Display(){

        System.out.println("Hii I am in Derived class Fn");
    }

    void Name(){

        System.out.println("Hii My name in Anish derived");
    }


}


public class Run_Time_Dyanamic_Polymorphism {

    public static void main(String[] args) {

          Derived d1 = new Derived();           //  D-D -> will work fine.
          d1.Display();


//        Base b1 = new Derived();               // B-D
//        b1.Display();                         --> Working because will point to certian properties of derived class and object (new .. ) overided
//                                                    Method will execute.



//        Derived d2 =  new Base();              // D-B
//        d2.Display();                          --> Giving Error because Child cannot point to parent object.
//


        Base b1 = new Base();                    // B-B  will work fine.
        b1.Display();


    }
}
