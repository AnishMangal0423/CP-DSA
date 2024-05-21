package GFG.POTD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B_KClosest_Elements__21052024{

    /**
     *
     * TC - O(logN + K) time
     * SC - O(k)
     *
     *
     * [1,2,3,4,5,6,7]
     * [1,2,3,5,7,9,11]
     * **/
    public static ArrayList<Integer> BinarySearch(int[]arr, int x, int si, int ei, ArrayList<Integer>ans){


        while (si <= ei) {

            int mid = (si + ei) / 2;
            if (arr[mid] == x) {
                ans.add(mid - 1);
                ans.add(mid + 1);
                return ans;
            } else if (arr[mid] > x) ei = mid - 1;
            else si = mid + 1;
        }

        if (si > ei) {
            ans.add(ei);
            ans.add(si);
        }

return ans;
    }
    public static ArrayList<Integer> Closest(int[]arr, int k, int x){

        int n = arr.length;
        ArrayList<Integer>Kans = new ArrayList<>();
        ArrayList<Integer>lowerUpperIndex = BinarySearch(arr, x, 0, arr.length-1, new ArrayList<>());

        int leftIndex = lowerUpperIndex.get(0);
        int rightIndex = lowerUpperIndex.get(1);

//        System.out.println(leftIndex +" "+rightIndex);


        for(int i=0; i<k; i++) {

            int leftValue = Integer.MAX_VALUE;
            int rightValue = Integer.MAX_VALUE;

            if(leftIndex >=0)leftValue=arr[leftIndex];
            if(rightIndex < n)rightValue=arr[rightIndex];


            if (Math.abs(x - rightValue) <= Math.abs(x - leftValue)) {
                Kans.add(rightValue);
                rightIndex++;
            } else{
                Kans.add(leftValue);
                leftIndex--;
            }

        }
        return Kans;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[]arr=new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        int k = sc.nextInt();
        int x = sc.nextInt();

        System.out.println("The k-closest Elements to x is ?: "+ Closest(arr, k , x));
    }
}
