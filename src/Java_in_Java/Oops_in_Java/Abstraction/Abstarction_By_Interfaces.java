package Java_in_Java.Oops_in_Java.Abstraction;

/***
 *
 * Why we are saying 100% Abstraction is .. kyuki saree methods hi implement krne padte h , aur saree hi abstarct hote h.
 * to sarii functionalities class apne hisab se likhti h too 100% abstarction h .. jabki abstarct class mai aisa nhi hota.
 *
 * **/

interface Bird{

    // Bas hmm itna samaj gye bird ke pass udne aur khane ki chamta h .. kesa udaega aur kahayega bhagwaan jane.
    void fly();
    void eat();
}

class Eagle implements Bird {

    @Override
    public void fly(){
        System.out.println("Eagle can fly.. rote rote udta hu.. process bta rhu hu");
    }

    @Override
    public void eat(){
        System.out.println("You Know .. i am eagle , how i eat.. Phle mai dabochta hu fir khata hu .");
    }
}
public class Abstarction_By_Interfaces{

    public static void main(String[] args) {


        Bird b = new Eagle();
        b.fly();
        b.eat();
    }
}

