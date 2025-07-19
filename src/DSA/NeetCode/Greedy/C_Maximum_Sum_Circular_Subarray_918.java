package DSA.NeetCode.Greedy;

import java.util.Scanner;

public class C_Maximum_Sum_Circular_Subarray_918 {

    public static int MaxSum(int[]nums){

        int n = nums.length;
        int sum =0;
        int G_maxSum = Integer.MIN_VALUE;
        int temp_maxSum =0;
        int G_minSum = Integer.MAX_VALUE;
        int temp_minSum =0;

        for(int i=0; i<n; i++){

            int val = nums[i];
            sum += val;
            temp_maxSum += val;
            G_maxSum = Math.max(G_maxSum, temp_maxSum);
            if(temp_maxSum < 0)temp_maxSum =0;
            temp_minSum += val;
            G_minSum = Math.min(G_minSum, temp_minSum);
            if(temp_minSum > 0)temp_minSum =0;
        }

        if(G_minSum == sum)return G_maxSum;
        return Math.max(G_maxSum, (sum - G_minSum));
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        System.out.println("The maximum possible sum is : " + MaxSum(arr));
    }
}
