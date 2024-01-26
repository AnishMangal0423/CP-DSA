package Codechef.Contests.Starter_118D__24012024;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int tc=sc.nextInt();

        while (tc-- >0){

            int n=sc.nextInt();
            int p =sc.nextInt();

         if((100*n)/p >=75) System.out.println("YES");
         else System.out.println("NO");

        }
    }
}
