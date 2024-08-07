package CodeForces.Contests.Div4.Div_4_964__06082024;

import java.util.Scanner;

/**
 * Good Question :-
 * Agar hmse bola aaye ki kisi no ko 3 se divide krte krte 0 bna ne mai kitna time lagega to log num lagega
 * and agar ye kaam n Continous numbers ke liye krna ho too nlogn nhi O(n) mai bhi ho jayega -
 * arr[i] =  arr[i/3] + 1;
 * se.
 *
 * Bas yhi logic that , ise O(n) time mai hi krna tha.
 * O(nlogN) mai
 *
 *
 * **/
public class Q5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();


        int []arr = new int[200001];

        for(int i = 1 ; i <= 200000 ; i++){
            arr[i] = arr[i/3] + 1;
        }

        int dp [] = new int[200001];

        for(int i = 1 ; i <= 200000 ; i++){
            dp[i] += arr[i] + dp[i-1];
        }



        while (t-->0){

            int l = sc.nextInt();
            int r = sc.nextInt();


            int ans = arr[l]*2;

            ans += (dp[r] - dp[l]);

            System.out.println(ans);
        }
    }
}
