package LeetCode.POTD;

import java.util.Arrays;
import java.util.Scanner;

public class G_SpecialArray_ElementsGreater_ThenX__27052024 {
    public static int FindGreaterXBinary(int[]arr, int s, int e){

        if(s > e)return -1;
        int mid = (s + e)/2;

        int NoBigger = 0;
        for(int i=0; i<arr.length; i++) if(arr[i]>=mid)NoBigger++;

        if(mid == NoBigger)return mid;
        else if(mid > NoBigger)  return FindGreaterXBinary(arr, s, mid-1);
        else return FindGreaterXBinary(arr, mid+1, e);

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr=new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        System.out.println("Finding Element by binary serach ?: "+ FindGreaterXBinary(arr, 0, 1000));
    }
}
