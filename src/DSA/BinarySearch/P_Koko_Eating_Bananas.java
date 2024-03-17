package DSA.BinarySearch;

import java.util.Map;
import java.util.Scanner;


/*****
 * Problem :- Binary Search on Numbers.
 * Approch :- An array is given and we have to find the certain speed. below or equal such that he eat all bananas.
 *            Approch :- Check for all numbers . and got tle.
 *
 *            Approch-2 :- Check for certain numbers and get the answer. using BS.
 *                Using the s=1, and e = maxi.
 *
 *
 * Edge Case / Learning point  -----> Here it is possible that , lets suppose for hour 6,7,8 ans is same and equal to gaurdhour
 *                                    so we cannot return 8 as ans, becuase 6 is the ans , so we have range of numbers which is
 *                                    giving the same answers, patch of numbers.
 *                                    so inseated of ans using s and e , try to maintain the ans in an variable.
 *                                    always when we are dealing with the patch either.
 *
 *
 * TC - O(Log(Maximum Pile[i]) ~ O(log(10^9))
 * SC - O(1)
 * **/

public class P_Koko_Eating_Bananas{

    public static long BinarySearch(long[]arr, long hours){

        long maxi = arr[0];
        for(int i=1; i< arr.length; i++) maxi=Math.max(maxi, arr[i]);

        long s = 1;
        long e = maxi;
        long ans = e;

        while (s <= e){

            long mid = (s + e)/2;

            long hours_count = 0;

            for(int i=0; i<arr.length; i++){
                hours_count+=(arr[i]/mid + ((arr[i]%mid!=0)?1:0));
            }
//            System.out.println(mid + " hours count : " + hours_count +" "+ s + " "+ e+" "+ hours);
//            if(hours_count == hours)return mid;    --> Wrong condition.
            if (hours_count <= hours){
              ans = Math.min(ans, mid);
                e=mid-1;
            }
            else s=mid+1;
        }
return s;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of Array : ");
        int n = sc.nextInt();
        long[]arr=new long[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextLong();

        long hours = sc.nextLong();

        System.out.println("Minimum speed of Koko to eat all Bananas Before Gaurd comes is : " + BinarySearch(arr, hours)+" per/hour");
    }
}
