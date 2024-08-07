package CodeForces.Contests.Div4.Div_4_964__06082024;

import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-->0){

//            int n = sc.nextInt();

            int[]arr = new int[4];

            for(int i=0; i<4; i++)arr[i]=sc.nextInt();

            int ans = 0;

             if(arr[0] >arr[2] && arr[1] > arr[3])ans++;
             if(arr[0]>arr[3] && arr[1]>arr[2])ans++;
             if(arr[1]>arr[2] && arr[0]>arr[3])ans++;
             if(arr[1]>arr[3] && arr[0]>arr[2])ans++;

            System.out.println(ans);
        }
    }
}
