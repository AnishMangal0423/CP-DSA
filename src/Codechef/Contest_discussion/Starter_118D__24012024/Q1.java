package Codechef.Contest_discussion.Starter_118D__24012024;

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int tc=sc.nextInt();

        while (tc-- >0){

            int n=sc.nextInt();

            int m=sc.nextInt();
            int p=sc.nextInt();

            System.out.println(Math.max(n*p, m*p));

        }
    }
}
