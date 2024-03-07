package Java_in_Java.Interfaces_in_Java.CringeOf_Java8;


/***
 *
 * Yeah static methods can also Have Body, directly access them.
 * They can't be Overriden.
 *
 * **/

interface Balance{
    static int checkBalance(){
        System.out.println("Yeah, I can check the Balance of Account. ");
         return 2;
    }

     void AccountNo();  // In interfaces there is explicit default we have to write, it is public in nature.

}

class Holder implements Balance{

    public void AccountNo(){  // Here that's why we have to write public.

        if(Balance.checkBalance() > 0)System.out.println("Account no is 2195 ");
    }
}

public class Static_Methods_in_Interfaces{

    public static void main(String[] args) {

        Holder h = new Holder();
        h.AccountNo();
    }

}
