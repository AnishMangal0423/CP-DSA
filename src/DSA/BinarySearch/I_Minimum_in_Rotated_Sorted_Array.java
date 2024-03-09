package DSA.BinarySearch;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * Concept :- Modified Binary Search-
 * Approch :- I have tried to use the same concept of Finding the one sorted line about the Mid Element.
 *            Line1  mid  Line2
 *            yadi, line 2 sorted h , to result to line1 mai hi ayega , min element.
 *            aur agar line 1 sorted h , tab bhi ans line 1 mai aa sakta h   --> [2,3,4,5]
 *            aur line 2 mai bhi aa sakta h --> [2,3,4,0,1]
 *            so , sab kuch aab s, e elements ke comparision ke uper h, to dry run karke hi dekho.
 *
 *
 *         TC - O(LogN)
 *         SC - O(1)
 *
 *
 * **/
public class I_Minimum_in_Rotated_Sorted_Array{

    public static int BianrySearch(int[]arr){

        int s = 0;
        int e = arr.length -1;
        int mini = Integer.MAX_VALUE;
        while (s <= e){
            int mid = (s + e)/2;

            mini = Math.min(mini, arr[mid]);

            // Means Line 2 is sorted-
            if(arr[mid] <= arr[e]) e = mid-1;   // Case can be - [7,0,1,2,3,4,5,6]

            else{  // Means Line is 1 is sorted
                if(arr[s] > arr[e]) s = mid+1;  // But there can be min in line 2. [2,3,4,0,1]
                else e = mid-1;                // There can be min in line 1 as well [2,3,4,5]
            }
        }
        return mini;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array- ");
        int n = sc.nextInt();
        int[]arr = new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();


        System.out.println("Minimum Element Present in an Array :- " + BianrySearch(arr));
    }
}
