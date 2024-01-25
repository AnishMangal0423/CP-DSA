package CodeForces.Practice;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class C_Comparision_String {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int[]dp=new int[n];

            int maxi=2;

            dp[0]=2;
            for(int i=1; i<n; i++){

                if(s.charAt(i-1)==s.charAt(i))dp[i]=dp[i-1]+1;
                else dp[i]=2;

                maxi= Math.max(maxi, dp[i]);
            }

            System.out.println(maxi);
        }
    }

}
