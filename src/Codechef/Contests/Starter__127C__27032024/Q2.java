package Codechef.Contests.Starter__127C__27032024;

import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc-->0) {
            int n = sc.nextInt();
//            int[] arr = new int[n];

//            for(int i=0; i<n; i++)arr[i]=sc.nextInt();

            int k=sc.nextInt();
            int x = sc.nextInt();

            if(x >= ((k-1)<<1)){
                System.out.println( ((k-1)<<1));
                System.out.println("YES");
            }

            else{
                System.out.println( ((k-1)<<1));
                System.out.println("NO");
            }



        }
    }
}
