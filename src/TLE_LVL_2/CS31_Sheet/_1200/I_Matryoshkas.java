package TLE_LVL_2.CS31_Sheet._1200;

import java.util.Arrays;
import java.util.Scanner;

public class I_Matryoshkas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc=sc.nextInt();

        while (tc-->0){

            int n = sc.nextInt();
            long []arr= new long[n];
            for(int i=0; i<n; i++)arr[i]=sc.nextLong();

            Arrays.sort(arr);

            long[]dp=new long[n];
            dp[0]=1;
            long maxi = 1;
            for(int i=1; i<n; i++){
                if(arr[i]==arr[i-1]){
                    dp[i]=1+dp[i-1];
                }
                else dp[i]=1;

                maxi=Math.max(maxi, dp[i]);
            }

            System.out.println(maxi);
        }
    }
}
