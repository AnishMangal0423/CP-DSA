package CodeForces.Contests.Div3.Div3__Round970__01092024;

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-->0){

            int a= sc.nextInt();
//            int[]arr = new int[n];
//            for(int i=0; i<n; i++)arr[i]=sc.nextInt();

            int b = sc.nextInt();

            if((a==0 && b%2!=0) || (b==0 && a%2!=0) || a%2!=0){
                System.out.println("NO");
            }
            else System.out.println("Yes");


        }
    }
}
