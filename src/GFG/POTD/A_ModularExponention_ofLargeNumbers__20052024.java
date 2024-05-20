package GFG.POTD;

import java.util.Scanner;


/**
 *
 * TC - O(LogN)
 * SC - O(1)
 * **/
public class A_ModularExponention_ofLargeNumbers__20052024{

    public static long Power_Modulo(int x, int n , int M){


    // Step-1 :: Intilizating the answer Variable.
        long ans = 1;


    // Step-2 :: Recursive while Loop.
    while (n>0){

        // Step-3 :: if n is odd , seperate one value out of it.
        if(n%2!=0){
            n--;
            ans*=x;
        }

        // Step-4 :: if n is even , doubles the x and half the n and later when n=1 then get the ans*=x;

        x=(x*x)%M;
        n/=2;
    }

    // step-5 :: return ans
       return ans%M;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int x=sc.nextInt();
        int n = sc.nextInt();
        int M = sc.nextInt();

        System.out.println("Modulo of Given Equation is ?: " + Power_Modulo(x, n, M));
    }
}
