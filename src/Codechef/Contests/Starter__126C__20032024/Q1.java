package Codechef.Contests.Starter__126C__20032024;

import java.util.Scanner;

/**
 *Question Link :-  https://www.codechef.com/problems/DICEGAME3
 * Problem :- Problem is to get the Maximum score.
 * Mistake ::- Question Reading and Understanding Mistake.
 *             Always-Always Read the Problem Correctly and Give the Ans by understanding and making Logic to it.
 *
 * **/

public class Q1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc=sc.nextInt();
        while (tc-->0){

            int n = sc.nextInt();
//            int[]arr=new int[n];
//            for(int i=0; i<n; i++) arr[i]=sc.nextInt();

           int scr=0;
//           scr+=arr[0];
//           scr+=arr[n-1];
//           for(int i=1; i<n-1; i++){
//               if(arr[i-1]==1){
//                   scr+=(2*arr[i]);
//               }
//               else scr+=arr[i];
//           }
if(n%2==0){
    scr+=(n/2)*(13);
}
else{
    scr+=((n-1)/2)*(13) + 6;
}

            System.out.println(scr);

        }

    }
}
