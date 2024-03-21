package Codechef.Contests.Starter__126C__20032024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/**
 * Link :- https://www.codechef.com/problems/PERDIS
 * Problem :- We have given an array of Permuatation (1-n) and some places are mispalced and some are places correctly and we
 *            have to shuffle them via adjacent moves such that every number is misplaced and retuen minimum moves.
 *
 *
 *     Approch-1 :- use the Subarray Approch.
 *         Edge Case :- Managing the last part of the dp array. and some more calculation.
 *
 *     Approch-2 :- Use the pointer Approch.
 *         we will make , status pointer where status = 0 will show the ans addition and starting of correct pair and
 *         if incoorect found again starts the new beginning to search more.
 *         or if correct found will end up via status 1 and not added in the ans because n+1/2 will be added like that.

 *
 * **/
public class Q3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc=sc.nextInt();
        while (tc-->0){

            int n = sc.nextInt();
            int[]arr=new int[n];
            for(int i=0; i<n; i++) arr[i]=sc.nextInt();


// ---------------------------------  Method - 1 ----------------------------------------------------------------------
            int[]dp=new int[n];

            ArrayList<Integer>ans = new ArrayList<>();
            if(arr[0]==1)dp[0]=1;
            for(int i=2; i<=n; i++){
                if(arr[i-1]==i)dp[i-1]=1+dp[i-2];
                else ans.add(dp[i-2]);

                System.out.println(Arrays.toString(dp));
            }

            ans.add(dp[n-1]);

            long maiin=0;

            for(int i : ans){
                maiin+=(i+1)/2;
            }

            System.out.println(maiin);

// ---------------------------------------------- Method - 2 ----------------------------------------------------------


         long aans = 0 , status = 0;

         for(int i=0; i<n; i++){

             // Correct Position
             if(arr[i]==i+1){
                 aans += (status == 0) ? 1 : 0;

                 if(status == 0) status=1;
                 else status = 0;
             }

             // Wrong position
             else status  = 0;
         }

            System.out.println(aans);

        }

    }
}
