package Java_in_Java.Oops_in_Java.Inheritance;


class Living{

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

// Matlab aab Ambhiian at a time living ki trah bhi h khali, terestial ki trah bhi h , aqautic bhi h .. 1 at a time.
// Yhi hota h multiple Imheritance. bhaut sare log milke kre to , jab ek ne najariye se dekhe to baat sari satisfy honi chaiye.
class Amphibian extends Living implements Terestial, Aquatic {

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

public class Multiple_Inheritance{
    public static void main(String[] args) {

        Amphibian a = new Amphibian();
        a.canMove();
        a.isLiving();
    }
}
