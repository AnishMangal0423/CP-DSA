package DSA.BinarySearch;

import java.util.Scanner;

/**
 *
 * Time Complexity of this function is log(M ) or log(Exponent) .
 * Space is o(1)
 * **/
public class O_Mathpow_function_in_java{

    public static long Power(long Base, long Exponent){

        long ans = 1;

        while (Exponent > 0){
            if(Exponent % 2 == 1){
                ans = ans * Base;
                Exponent= Exponent-1;
            }

            else{
                Base = Base * Base;
                Exponent/=2;
            }
        }
        return ans;
    }
    public static void main(String[] args) {

        System.out.println("Enter the Base and Exponent : ");
        Scanner sc = new Scanner(System.in);
        long Base = sc.nextLong();
        long Exponent = sc.nextLong();

        System.out.println("Value of Manual Math.pow() function is : " + Power(Base, Exponent));


    }
}
