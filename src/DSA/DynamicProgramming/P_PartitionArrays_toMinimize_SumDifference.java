package DSA.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



/***
 *
 * This Question will Always Give TLE Becuase it's not of DP Question , it will 3d dp and have High Constraints.
 *
 * */
public class P_PartitionArrays_toMinimize_SumDifference {

    public static int MinDiff_Memoization(int[]arr, int index, int sumNow, int sum, int count){

        int LimitedSize = (arr.length)/2;
        int n = arr.length;
        int sum1 = sumNow;
        int sum2 = sum-sum1;
        if(count==LimitedSize){
            return Math.abs(sum1-sum2);
        }
        if(index < 0) return Integer.MAX_VALUE;
        // Take -
        int a = MinDiff_Memoization(arr, index-1, sumNow+arr[index] , sum, count+1);
        int b = MinDiff_Memoization(arr, index-1, sumNow, sum, count);

//        System.out.println(a+" "+ b+" "+ index+" "+ sumNow);
        return Math.min(a, b);
    }
    public static void main(String[] args) {

        System.out.println("Enter the Size of Array ?: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr=new int[n];
        int sum =0;
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }

        Arrays.sort(arr);
        int largestSum = 0;
        for(int i=n-1; i>=n/2; i--)largestSum+=arr[i];
        int[][][]dp = new int[n][largestSum+1][n/2];
        System.out.println("The Minimum Difference in Sum of 2 Partitions ?: " + MinDiff_Memoization(arr, n-1, 0 ,sum,0));
    }
}
