package Codechef.Contests.Starter__127C__27032024;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc-->0) {
            long n = sc.nextLong();
//            int[] arr = new int[n];

//            for(int i=0; i<n; i++)arr[i]=sc.nextInt();

      long l = sc.nextLong();

      long val=l;
      long prev = -1;
     for(int i=0; i<n; i++){

         System.out.print(val+" ");
         prev=val;
         val=prev+l;
     }
            System.out.println("");

        }
    }
}
