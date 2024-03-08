package DSA.BinarySearch;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * Concept :- Normal Binary Search-
 * Complexities :- TC - O(2logN)
 *                 SC - O(1)
 *
 * ***/

public class F_Ceil_and_Floor_value_of_X{
    public static void LowerValue(int[]arr, int[]ans, int target){

        int s = 0;
        int e = arr.length-1;

        while (s <= e){

            int mid = (s + e)/2;

            if(arr[mid] > target) e = mid-1;
            else if (arr[mid] < target){
                ans[0]= Math.max(ans[0] , arr[mid]);
                s = mid+1;
            }
            else {
                ans[0] = arr[mid];
                break;
            }

        }

    }


    public static void UpperValue(int[]arr, int[]ans, int target){

        int s = 0;
        int e = arr.length-1;

        while (s <= e){

            int mid = (s + e)/2;

            if(arr[mid] > target) {
             ans[1] = Math.min(ans[1], arr[mid]);
                e = mid-1;
            }
            else if (arr[mid] < target) s = mid+1;
            else {
                ans[1] = arr[mid];
                break;
            }

        }

    }


    public static void main(String[] args) {
        System.out.println("Enter the Size of Array :- ");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[]arr = new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();
        System.out.println("Enter the Key, for which we have to find Floor and Ceil Value.");
        int target = sc.nextInt();

        int[]ans = new int[2];
        ans[0]=-1;
        ans[1]=Integer.MAX_VALUE;

        LowerValue(arr, ans, target);
        UpperValue(arr, ans, target);

        System.out.println("Floor and Ceil Values are :-  "+Arrays.toString(ans));
    }
}
