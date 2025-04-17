package LeetCode.POTD;

import java.util.HashMap;
import java.util.Scanner;
//Input: nums = [3,1,4,3,2,2,4], k = 2 freq = 2, 1, 3,
//        Output: 4
//        Explanation: There are 4 different good subarrays:
//        - [3,1,4,3,2,2] that has 2 pairs.
//        - [3,1,4,3,2,2,4] that has 3 pairs.
//        - [1,4,3,2,2,4] that has 2 pairs.
//        - [4,3,2,2,4] that has 2 pairs.

public class ZB_Number_of_Good_Subarrays_2537_16042025 {

    public static long countGood(int[]nums, int k){

        int n = nums.length;
        int l=0;
        int r=0;

        long ans=0;
        int samecount=0;
        HashMap<Integer, Integer>freqmap = new HashMap<>();
        while(l<=r){
            System.out.println(l+" "+ r);
            int val1 = nums[l];
            int val2 = nums[r];

            if(freqmap.containsKey(val2)==false){
                freqmap.put(val2, 1);
                r++;
            }
            else{
                int val = freqmap.get(val2);
                freqmap.put(val2 , val+1);
                samecount++;
                if(samecount >=k) {
                    ans += (long) (n - (r));
                    int vaal = freqmap.get(val1);
                    freqmap.put(val1, vaal - 1);
                    if (vaal - 1 == 1) samecount--;
                    l++;
                }
                else r++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Length of array :- ");
        int n = sc.nextInt();

        int[]nums = new int[n];
        System.out.println("Enter the nums elements :- ");
        for(int i=0; i<n; i++)nums[i]=sc.nextInt();

        System.out.println("Enter the Good factor k :- ");
         int k = sc.nextInt();

        System.out.println("The number of Good subarrays :- " + countGood(nums, k));
    }
}
