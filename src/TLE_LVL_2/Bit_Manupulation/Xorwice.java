package TLE_LVL_2.Bit_Manupulation;

import java.util.*;

public class Xorwice{


    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);
        int tc=sc.nextInt();

        sc.nextLine();



        while(tc-- > 0){

            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println((a^(a|b)) + (b^(a|b)));

        }



    }

}