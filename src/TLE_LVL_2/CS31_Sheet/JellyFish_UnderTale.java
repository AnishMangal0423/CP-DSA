package TLE_LVL_2.CS31_Sheet;

import java.util.Scanner;

public class JellyFish_UnderTale{

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int tc=sc.nextInt();

        while (tc-->0){

            int a=sc.nextInt();
            int b=sc.nextInt();
            int n=sc.nextInt();

            int ans=b;
            for(int i=0; i<n; i++){
                int input = sc.nextInt();
                ans+=Math.min(a-1, input);
            }

            System.out.println(ans);
        }
    }
}
