package DSA.DynamicProgramming;
import java.util.Arrays;
import java.util.Scanner;


/**
 *
 * A very Good Question it is , when You will do it by Tabulation Method, Becuase there are some Edge Cases in it -
 *
 * First of All in terms of Base Cases - we will only fill the 1st row of dp.
 * and dp[0][0] will be 2 .. (kyuki osko lene, nalene) par 2 cases bn jayenge.
 * and hmm dp ko fill krna col=0 se krenge , hmm dp[i][0] =1 nhi kr sakte h kyuki it depends on 0 na ki agar 0 aata h too
 * ans bd jaata h isliye hmm base case mai bas dp ki first row ko fill krenge , dp[0][0] ko 2 rkhenge and bakki to col=0; se hi
 * fill krenge..


   TC - O(N*M)
   SC - O(N*M)
 * **/
public class O_Perfect_TargetSum{

    public static int SubsetSum(int[]arr, int[][]dp, int target ){

        int rows = arr.length;
        int cols = target+1;
        int mod= (int)Math.pow(10 , 9)+7;


        if(arr[0] <= target)dp[0][arr[0]]=1;
        if(arr[0] == 0) dp[0][arr[0]] = 2;

        for(int row=1; row<rows; row++){
            for(int col=0; col<cols; col++){

                int non_take = dp[row-1][col];

                int take = 0;

                if(col-arr[row] >=0){
                    take = dp[row-1][(col-arr[row])];
                }

                dp[row][col]= (take+non_take) % mod;
            }
        }

        for(int i=0; i<rows; i++){
           for(int j=0; j<cols; j++) System.out.print(dp[i][j]+" , ");
            System.out.println();
        }
        return dp[rows-1][cols-1];
    }
    public static void main(String[] args) {

        System.out.println("Enter the Size of Array :- ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr=new int[n];
        int sum = 0;
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }
        int target = sc.nextInt();


        int[][]dp = new int[n][target+1];
        System.out.println("The Number of Total Subsets Possible Whose sum is Equal to Target is :- " + SubsetSum(arr, dp,target));
    }
}
