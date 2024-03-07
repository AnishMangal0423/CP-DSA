package Java_in_Java.Interfaces_in_Java.CringeOf_Java8;


/***
 *
 *   Showing the Clear kaat image that if in Multiple inheitance two interfaces has same defaut fn with implementation
 *   then we have to implement in class also , it is restricted.
 *
 *   But in abstarct classes , if cannot use it, we canNot use 2 classes as extends.
 *
 *
 * **/
interface Mountains{

    void Height();

    // Lately added Function as Default -

    default int Temperature(){
        return 10;
    }

    default boolean isRocky(){
        return false;
    }
}

interface Rivers{

    void Length();

    default int Temperature(){
        return 1;
    }
}


class Himalya implements Mountains, Rivers{          // First it is Giving error that both interface can't have same fn, and implement both.

    @Override
    public void Height(){
        System.out.println("Himalya Mountain is 1000m tall");
    }

    @Override
    public void Length(){
        System.out.println("Length of Himalaya is 100m");}

    @Override
    public int Temperature(){           // Ye appko bnana padega warna error dega ki kiska fn call kre.
                                       // matlab jab dono ke pass default same ho tb to sarri classes mai implement krna hi padega.
        return -1;
    }

}

public class Default_Functions_in_Interface{

    public static void main(String[] args) {


        Himalya h = new Himalya();
        System.out.println(h.Temperature());
        System.out.println("is Rocky : "+ h.isRocky()); // --> Lets see that class also have access to Implemented all functions , like an extend Keyword.

        Mountains m = h;
        m.Height();                             // Showing that interface can point , but not have objects of there own.

        Rivers r = h;
        r.Length();

    }
}
