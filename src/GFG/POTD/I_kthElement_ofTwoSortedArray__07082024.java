package GFG.POTD;

import java.util.Scanner;

public class I_kthElement_ofTwoSortedArray__07082024 {


    public static int[] UpperBound(int[]arr , int val){

        int s = 0;
        int e = arr.length-1;
        int ans = arr.length;

        while (s <= e){

            int mid = (s + e)/2;

             if(arr[mid] > val){
                 ans = Math.min(ans , mid);
                 e= mid-1;
             }
             else s = mid+1;
        }

        return new int[2];
    }
    public static int kthElement(int k , int[]arr1, int[]arr2){

        int n1 = arr1.length;
        int n2 = arr2.length;
        int s = Math.min(arr1[0] , arr2[0]);
        int e = Math.max(arr1[n1-1] , arr2[n2-1]);

//        k = 5, arr1[] = [2, 3, 6, 7, 9], arr2[] = [1, 4, 8, 10]
//        k = 7, arr1[] = [100, 112, 256, 349, 770], arr2[] = [72, 86, 113, 119, 265, 445, 892]
//        Output: 256
        while (s <= e){

            int mid = (s + e)/2;
                    int[]a1 = UpperBound(arr1 , mid);
                    int[]a2 = UpperBound(arr2 , mid);
            int TotalNumbers = a1[0] + a2[0];
            if(TotalNumbers == k){
               return Math.max(a1[1], a2[1]);
            }

            else if(TotalNumbers > k){
                e=mid-1;
            }
            else s = mid+1;
        }

      return -1;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for(int i=0; i<n1; i++)arr1[i] = sc.nextInt();
        for(int j=0; j<n2; j++)arr2[j] = sc.nextInt();

        int k = sc.nextInt();
        System.out.println("kth Element in Combined Array is ?: " + kthElement( k , arr1, arr2));
    }
}
