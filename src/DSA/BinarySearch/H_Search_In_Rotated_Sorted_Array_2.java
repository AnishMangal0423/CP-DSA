package DSA.BinarySearch;

import java.util.Scanner;

/**
 *
 *Concept :- Simple Binary Search.
 *Approch :- Jo Iksa 1st part tha osme , distnict numbers the to 100% pta tha ki kisi na kisi traf to sorted line hogi hi.
 *          But jab duplicates bhi allowed ho gye to concept to same hi rha lekin hmm kuch TestCases mai phas Jayenge.
 *
 * Edge Cases :-   [1, 0, 1, 1, 1] target = 0
 *                Aab agar purani approch se chanlenge we would say ki 0 line 2 par lie karega matlab from index [3,4] wali par
 *                kyuki 1 == 1 to h , to isme to zero hoga nhi to else mai daal denge , jabki 0 to osi 1, 1 mai fsa tha
 *
 *                to hmm kya kare ese case mai-
 *                hme ye to pta chal gya ki 1 target nhi h , nhi to oper target matching hi true return krdeta.
 *                aur arr[s], arr[e] ==1 kabhi ans nhi ho payenge to hmm apna serach space kam kar sakte h so, we have
 *                shrinked the space .. fir search krne ke liye we will apply BS.
 *
 *                More eg of this - [3,3,2,3,3,3,3,3]  target = 2
 *
 *       Time Complexity :- Avg Case - O(logN)
 *                         Worst case - O(n/2)
 *
 *       Space complexity :- O(1)
 *
 *
 *
 * **/
public class H_Search_In_Rotated_Sorted_Array_2{

    public static boolean BianrySearch(int[]arr, int target){

        int s = 0;
        int e = arr.length-1;

        while (s <= e){

            int mid = (s + e)/2;

            if(arr[mid]==target)return true;

            else if(arr[s] == arr[mid] && arr[mid] == arr[e]){     // This is the Extra Condition that We have Added.
                s++; e--;                                          // Shrinked the array, tarverse [1,0,1,1,1]
            }

            else if(arr[s] <= arr[mid]){
                 if(target >= arr[s] && target<=arr[mid]) e = mid-1;
                 else s = mid+1;
            }

            else {
                if(target >= arr[mid] && target<= arr[e]) s = mid+1;
                else e = mid-1;
            }

        }

        return false;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array- ");
        int n = sc.nextInt();
        int[]arr = new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        System.out.println("Enter the target element in array- ");
        int target = sc.nextInt();

        System.out.println("Is Target Element Present in an Array :- " + BianrySearch(arr, target));
    }
}
