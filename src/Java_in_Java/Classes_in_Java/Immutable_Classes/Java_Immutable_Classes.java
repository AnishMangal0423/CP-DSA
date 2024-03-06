package Java_in_Java.Classes_in_Java.Immutable_Classes;


 final class Immute{

    final private int x ;
    final private int y;

     Immute(int xx, int yy){
         this.x = xx;
         this.y = yy;
     }

    public int getValueX(){
         return x;
    }
 }

public class Java_Immutable_Classes{
    public static void main(String[] args) {

        // Only one time Initilization can be done.

        Immute i = new Immute(2, 3);
        System.out.println(i.getValueX());
    }
}
