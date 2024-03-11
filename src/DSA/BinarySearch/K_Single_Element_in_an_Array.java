package DSA.BinarySearch;

import java.util.*;

/**
 *
 * Question :- Finding the unique single element in array.
 * Concept :- Binary Search.
 * Approch :- Use the xor approch-
 *            TC - O(N)
 *
 *
 *Approch-2 :- Using the binary serach and rejecting the other half if length of that subarray is even , and if other half
 *             has length as odd then our ans lies there.
 *
 *             Approch - 3 3 7 10 10 11 11
 *              mid is index 3 value 10 now chef it is the ans or not by seeing adajacent elements.
 *              if not, then if similar element lies in left then lenleft-2 if odd and even check.
 *              if not , means similar element lies in right then leftlength is even or odd.and then shifting.
 *
 *              It means There will be 3 types of Length , LeftLength , similarelementLength, RightLength.
 *                                                            [3,3,7] ,      [10, 10]        , [11, 11]
 *                                                            means ans lies here.
 *
 *
 *  Learning/Edge Cases --> I was also thinking of this approch in terms of length but not able to come up completely
 *                          becuase of indexes i was thinking of i=0 so , how we will tackle the i-1 index and all.
 *                          But-
 *                          1. Here lengeth is always odd , so no problem always mid will always be in between.
 *                          2. You can also use the BS From ind =1 to ind = n-2
 *
 *
 *   TC - O(LogN)
 *   SC - O(1)
 *
 *
 * ** Note ** --> It is also Not neccassry that Array must be sorted , you have to only keep pairs together like 6,6,1
 *                is alsso correct , but 6,1,6 is wrong , becuase we are dealting with pairs and length not any comparisions.
 *
 *
 *
 * **/
public class K_Single_Element_in_an_Array{
    public static int BinarySearch(int[]arr){

        int s = 0;
        int e = arr.length-1;

        while (s < e){

            int mid = (s + e)/2;
            if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]) return arr[mid];

            else if(arr[mid]==arr[mid-1]) {
                int len = (mid-s+1)-2;

                if(len%2!=0) e= mid-2;
                else s=mid+1;
            }

            else{
                int len = mid-s;

                if(len%2==0)s=mid+2;
                else e=mid-1;
            }
        }

        return arr[s];
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Length of array :- ");
        int n = sc.nextInt();
        int[]arr=new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        System.out.println("Unique Element in array is :- " + BinarySearch(arr));

    }
}
