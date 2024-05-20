package LeetCode.POTD;

import java.util.ArrayList;
import java.util.Scanner;

public class A_SumofAll_SubsetXOR__20052024 {

    /**
     *
     * TC - O(2^N)
     * SC - O(N)
     * */

    public static int SumXor(int[]arr, int i, int sum){

        if(i==arr.length) return sum;

        // taken -

        sum^=arr[i];
        int taken = SumXor(arr, i+1, sum);
        sum^=arr[i];
        int Non_taken = SumXor(arr,i+1, sum);

        return taken + Non_taken;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[]nums = new int[size];

        for(int i=0; i<size; i++) nums[i]=sc.nextInt();

        System.out.println("Sum of All subsets Xor is ?: " + SumXor(nums, 0, 0));
    }
}
