package DSA.Heaps;

import java.util.Arrays;
import java.util.Scanner;


/**
 * TC - O(N)
 * SC - O(logN)
 *
 * Kaffi logo ko lagta h , ki TC - O(NlogN) hona chaiye par jab documentation padoge to ye proof o(n) mai hi ho jata h.
 * */
public class B_Convert_MinHeap_to_MaxHeap{

    public static void swap(int[]arr, int i1, int i2){
        int k= arr[i1];
        arr[i1]= arr[i2];
        arr[i2] = k;
    }
    public static void ToMaxHeap(int[]arr, int index){

        int n = arr.length;

            int parent = index;
            int leftindex= -1 , leftValue = Integer.MIN_VALUE;
            int rightindex = -1 , rightValue = Integer.MIN_VALUE;

            if((2*parent + 1) < n) leftValue = arr[2*parent+1];
            if((2*parent)+2 < n) rightValue = arr[2*parent+2];

            if(arr[parent] >= leftValue && arr[parent] >= rightValue)return;
            else if(leftValue >= rightValue){
                System.out.println(leftValue +" "+ rightValue);
                swap(arr , parent , 2*parent+1);
                ToMaxHeap(arr , 2*parent+1);
            }
            else {
                swap(arr, parent, 2 * parent + 2);
                ToMaxHeap(arr, 2 * parent + 2);
            }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[]arr=new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        for(int i=(n/2)-1; i>=0; i--) {
            ToMaxHeap(arr , i);
        }
        System.out.println("Max Heap Conversion is ?: "+ Arrays.toString(arr));

    }
}
