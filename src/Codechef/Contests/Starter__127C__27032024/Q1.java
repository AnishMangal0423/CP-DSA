package Codechef.Contests.Starter__127C__27032024;

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc-->0) {
            int a= sc.nextInt();
//            int[] arr = new int[n];

//            for(int i=0; i<n; i++)arr[i]=sc.nextInt();


            int b = sc.nextInt();

            int cnt = 0;

            while (a-b < 10){
                a+=4;
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}
