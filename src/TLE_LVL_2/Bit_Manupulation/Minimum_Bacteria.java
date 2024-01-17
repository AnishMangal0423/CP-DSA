package TLE_LVL_2.Bit_Manupulation;

import java.util.Scanner;

public class Minimum_Bacteria {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();



//        Interpreted the Question in very Wrong Manner ....
//        int min = x;
//        for(int i=0; i<64; i++){
//            if((x - (1<<i)) < 0) break;
//
//            min=Math.min(min, x-(1<<i)+1);
//            System.out.println(min);
//        }
//
//        System.out.println(min);


        // Correct Solution -

        int count =0;

        for(int i=0; i<32; i++){
            if(((x >> i) & 1) == 1) count++;
        }
        System.out.println(count);
    }
}
