package LeetCode.Contest.Weekly_386_25022024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


/**
 *
 * Concept :- Binary Search .
 * Learning :- How to Implement the Binary search when Data is given According to 1-Based Indexing.
 *
 * Intution :- Before Implementing Binary search , You have to think that..
 *            1. Time is Montonously Increasing if mid is ok ... then mid+1, mid+2,.. all will satisfy.(we will move left).
 *            2. If mid is Not satisy nid-1, mid-2 will also not satisy. (we will Move right).
 *            3. Now convert the Whole qn in 0-Based Indexing that is More Good.
 *            4. Now Remember that high will be our ans.
 *            5. You can Keep high as Infinity as well upto Int_max.. But we are keeping m+1
 *            6. So if midvalue will satisfy then high == mid and high will be ans or move left.
 *            7. If mid is not satisfying then move left to mid+1.
 *            8. If mid is m+1 then it can't be ans.
 *            9. Ans range id [1...m].
 *
 *
 *
 *   Time Complexity :-  O(MlogM)  ~ In worst Case.
 *   Space Complexity :- O(M)  ~  M space is Used.
 *
 * **/

public class Q3{
    public static boolean BinarySearch(int[]nums, int[]changeIndexes , int seconds){

        int[]last = new int[nums.length];
        Arrays.fill(last, -1);

        for(int i=0; i<seconds; i++){
            last[changeIndexes[i]-1] = i;
        }


        int marked = 0;
        int oprn = 0;

        for(int i=0; i< seconds; i++){

            if(i == last[changeIndexes[i]-1]){

                if(nums[changeIndexes[i]-1] > oprn)return false;
                else{
                    oprn-=nums[changeIndexes[i]-1];
                    marked++;
                }
            }

            else oprn++;
        }
        return marked == nums.length;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[]nums = new int[n];
        int[]changeIndexes = new int[m];

        for(int i=0; i<n; i++)nums[i]=sc.nextInt();
        for(int i=0; i<m; i++)changeIndexes[i]=sc.nextInt();

        int low = 0;
        int high= m+1;

        while (low < high){

            int mid = (low + high)/2;

            if(BinarySearch(nums, changeIndexes , mid) == true){

                high = mid;
            }

            else {

                low = mid+1;
            }
        }

        if(high==m+1) System.out.println(-1);
        else System.out.println(high);

    }
}
