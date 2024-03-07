package DSA.BinarySearch;

import java.util.Scanner;

public class D_Search_Insert_Position {

    public static int BinarySearch(int[]arr, int Key){

        int n = arr.length;
        int low = 0;
        int high = n-1;

        while (low <= high){

            int mid = (low + high)/2;

            if(arr[mid]==Key) return mid;
            else if(arr[mid] > Key){
                high = mid-1;
            }
            else low = mid + 1;

        }
        return low;
    }
    public static void main(String[] args) {

        System.out.println("Enter the Size of Array : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();
        System.out.println("Enter the key to search  : ");
        int Key = sc.nextInt();

        System.out.println("Index of Inserting Key : " + BinarySearch(arr, Key));
    }
}
