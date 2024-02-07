package CodeForces.Contests.Div_3__06022024;

import java.util.Scanner;

public class Q4_Find_the_Different_Ones {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

         int tc = sc.nextInt();

         while (tc-->0){

             int n = sc.nextInt();

             int[]arr=new int[n];
             int[]dp=new int[n];

             for(int i=0; i<n; i++){
                 arr[i]=sc.nextInt();
             }


             dp[n-1]=n;
             for(int i=n-2; i>=0; i--){
                 if(arr[i] == arr[i+1])dp[i]=dp[i+1];
                 else dp[i]=i+1;
             }

             int q = sc.nextInt();

             while (q-->0){

                 int l=sc.nextInt();
                 int r=sc.nextInt();

                 if(dp[l-1] > r-1) System.out.println(-1 +" "+(-1));

                  else System.out.println((l) + " "+(dp[l-1]+1));

             }

             System.out.println();
         }
    }
}
