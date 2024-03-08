package DSA.BinarySearch;

import java.nio.Buffer;
import java.util.Scanner;

/**
 *
 * Concepts :- Modified Binary Search.
 * Approch :- Question ka Main point ye h Ki osme sirf ek hi dip point h.
 *           1. Iska matlab mid ke about koi na Koi si traf to increasing line hogi hi aur dusri traf Breaking Line.
 *           2. aab agar Target st Line mai hua to ok, nhi to dusri mai hoga.
 *           3. And then Applied BS.
 *
 *
 *
 *    Time Complexity :- O(logN)
 *    Space Complexity :- O(1)
 *
 * ***/

public class G_Search_in_Rotated_Sorted_Array_1{

    public static int BinarySearch(int[]arr, int target){

        int s = 0;
        int e = arr.length-1;

        while(s <= e){

            int mid = (s + e)/2;

            if(arr[mid]==target) return mid;

            // Now finding the Increasing Line-

            // ST-1
            if(arr[s] <= arr[mid]){           // Means left part is Increasing line and Right Part is Breaking Part.

                 if(target>= arr[s] && target<= arr[mid]) e =  mid-1;  // If target either will lie in st line or breaked Line so checking for st line.
                 else s = mid+1;  // Matlb target eleemnet breaked Line par h.
            }
            // ST-2
            else{    // Means Rights is Increasing and Left part is Breaked Line.

                if(target >= arr[mid] && target<= arr[e]) s = mid+1;
                else e = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

        System.out.println("Enter the Size of Array Given :- ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[]arr=new int[n];
        System.out.println("Enter the Elements of Array :- ");
        for(int i=0; i<n; i++)arr[i] = sc.nextInt();

        System.out.println("Enter the target Element to Find:- ");
        int target = sc.nextInt();

        System.out.println("Index of Targeted Element : " + BinarySearch(arr, target));
    }
}
