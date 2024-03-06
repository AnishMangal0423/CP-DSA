package Java_in_Java.Interfaces_in_Java.Uses_of_Interfaces;

class Living{

    int a = 10;
    int b = 20;
    int c = 30;

    public void isLiving(){
        System.out.println("Yes, Living Beings can Breathe :)");
    }
}
interface Terestial{
    void canMove();
    void canWalk();
}

interface Aquatic{
    void canMove();
    void canSwim();
}

// Matlab aab Ambhiian at a time living i trah bhi h khali, terestial ki trah bhi h , aqautic bhi h .. 1 at a time.
// Yhi hota h multiple Imheritance.
// Class ek se jada nhi ho sakti extend, interface 10^5 ho sakte h.
class Amphibian extends Living implements Terestial, Aquatic{

    @Override
    public void canMove(){
        System.out.println("Yeah I oviously Amphibian can Move, ");
    }

    @Override
    public void canWalk(){
        System.out.println("Yeah Ambhibian can walk also ");
    }

    @Override
    public void canSwim(){
        System.out.println("Yeah Ambhibian can swim also ");
    }

}

public class Multiple_Inheritance_by_Interfaces {
    public static void main(String[] args) {

        Amphibian a = new Amphibian();
        a.canMove();
        a.isLiving();
    }
}
