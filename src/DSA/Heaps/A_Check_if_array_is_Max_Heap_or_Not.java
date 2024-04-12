package DSA.Heaps;

import java.util.Scanner;

public class A_Check_if_array_is_Max_Heap_or_Not{


    public static boolean isMaxHeap(long[]arr){
        int n = arr.length;

        for(int i=(n/2)-1; i>=0; i--){

            long parent = arr[i];
            long leftChild = -1;
            long rightChild = -1;

            if(2*i + 1 < n) leftChild = arr[2*i + 1];
            if(2*i + 2 < n) rightChild = arr[2*i + 2];

            if(parent < leftChild || parent <rightChild) return false;
        }
        return true;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[]arr=new long[n];
        for (int i=0; i<n; i++)arr[i]=sc.nextLong();

        System.out.println("Is Array Represents Max Heap ?: " + isMaxHeap(arr));


    }
}
