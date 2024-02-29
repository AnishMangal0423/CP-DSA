package Codechef.Contests.Starter__123D__28022024;

import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc-->0){

            int n = sc.nextInt();
//            int[]arr = new int[n];
//            for(int i=0; i<n; i++)arr[i]=sc.nextInt();
            int a =sc.nextInt();
            int b = sc.nextInt();

            int sum=0;
            if(a==0 && b==0) sum++;
            sum--;

            if (a == b)
            {
                if (n % (a + 1) != 0)
                    System.out.println("ALICE");
                else
                    System.out.println("BOB");
            }
            else if (b > a && n > a)
            {
                System.out.println("BOB");
            }
            else
                System.out.println("ALICE");
        }




        }


    }

