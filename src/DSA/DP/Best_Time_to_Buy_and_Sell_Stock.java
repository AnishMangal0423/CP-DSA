package DSA.DP;

import java.util.Scanner;

public class Best_Time_to_Buy_and_Sell_Stock{

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();
        int[]price = new int[n];
        for(int i=0; i<n; i++)price[i]=sc.nextInt();


        int maxi = price[n-1];
        int profit = 0;
        for(int i=n-2; i>=0; i--){

            if(maxi - price[i] > profit){
                profit = maxi - price[i];
            }

            maxi=Math.max(maxi, price[i]);
        }
        System.out.println(profit);
    }
}
