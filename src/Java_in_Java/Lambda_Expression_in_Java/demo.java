package Java_in_Java.Lambda_Expression_in_Java;

/***
 *
 * Lambda can only be used when we have only one method in an Interface.
 *
 * */
interface Bird{
    int canFlyHeight(int h);
}
public class demo{
    public static void main(String[] args) {

         Bird b = (int h) ->{
             System.out.println("Yeah, You have Implemented lambda exp");
             return h;
         };

        System.out.println(b.canFlyHeight(10));
    }
}
