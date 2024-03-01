package DSA.BinarySearch;

import java.util.Scanner;

/**
 * TC - O(logN)
 * SC - O(1) Time.
 * **/
public class Binary_Search_Logic{

    public static boolean Binary_Search(int[]arr, int l, int r, int target){

        if(l>r)return false;

        int mid = (l+r)/2;

        if(arr[mid] == target)return true;
        else if(arr[mid] > target) return Binary_Search(arr, l, mid-1, target);
        else return Binary_Search(arr, mid+1, r, target);

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[]arr = new int[n];
        for(int i=0; i<n; i++)arr[i] = sc.nextInt();

        int target = sc.nextInt();

        boolean ans = Binary_Search(arr, 0, n-1, target);
        System.out.println(ans);
    }
}
