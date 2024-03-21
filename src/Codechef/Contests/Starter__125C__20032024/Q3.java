package Codechef.Contests.Starter__125C__20032024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        int tc=sc.nextInt();
//        while (tc-->0){
//
//            int n = sc.nextInt();
//            int[]arr=new int[n];
//            for(int i=0; i<n; i++) arr[i]=sc.nextInt();
//
//            int[]dp=new int[n];
//
//            ArrayList<Integer>ans = new ArrayList<>();
//            if(dp[0]==1)dp[0]=1;
//            for(int i=2; i<=n; i++){
//                if(dp[i]==i)dp[i]=1+dp[i-1];
//                else ans.add(dp[i-1]);
//            }
//
//            long maiin=0;
//
//            for(int i : ans){
//                if(i==1)maiin+=1;
//                else maiin+=i-1;
//            }
//
//            System.out.println(maiin);
//        }

        Scanner sc = new Scanner(System.in);

        int tc=sc.nextInt();
        while (tc-->0){

            int n = sc.nextInt();
            int[]arr=new int[n];
            for(int i=0; i<n; i++) arr[i]=sc.nextInt();

            int[]dp=new int[n];

            ArrayList<Integer>ans = new ArrayList<>();
            if(arr[0]==1)dp[0]=1;
            for(int i=2; i<=n; i++){
                if(arr[i-1]==i)dp[i-1]=1+dp[i-2];
                else ans.add(dp[i-2]);

                System.out.println(Arrays.toString(dp));
            }

            ans.add(dp[n-1]);
//            System.out.println(ans);
            long maiin=0;

            for(int i : ans){
                maiin+=(i+1)/2;
            }

            System.out.println(maiin);
        }

    }
}
