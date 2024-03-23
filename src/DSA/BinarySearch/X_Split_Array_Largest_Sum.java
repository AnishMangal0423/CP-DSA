package DSA.BinarySearch;

import java.util.Scanner;

/**
 *
 * Problem Statement :- Simple just we have to Make the groups of Subarrays such that Maximum sum among all can be minimized.
 *
 * Thought Process --> Brute Force -
 *                Number of groups formed when val = 1 , jada groups bn jayenge hna , ya fir possible hi na bnana.
 *                val=2.. jada groups bn rhe h
 *                val=3,..jada bn rhe h
 *                val=4.. jistne chaie otne hi bne ,... bas yhi ans h
 *
 *                val=5 may be ans
 *                val=6 may be ans
 *                val=sum of array may be ans.
 * **/


public class X_Split_Array_Largest_Sum{

    public static int Groups(int[]arr, int mid){

        int n = arr.length;
        int count = 0;
        int sum = 0;
        for(int i=0; i<n; i++){

            sum+=arr[i];

            if(sum > mid){
                count++;
                sum=arr[i];
            }
        }

        return count+1;
    }
    public static int BianrySearch(int[]arr, int groups){

        int n = arr.length;
        int maxi = -1;
        int sum = 0;
        for(int i=0; i<n; i++){
            maxi=Math.max(maxi , arr[i]);
            sum+=arr[i];
        }

        int s = maxi;
        int e = sum;
        int ans = (int)1e9;
        while (s <= e){

            int mid = (s + e)/2;

            int N_Groups_on_Mid = Groups(arr , mid);

            System.out.println(s +" "+ mid +" "+ e+" "+ N_Groups_on_Mid +" "+ groups);
            if(N_Groups_on_Mid <= groups) {
                ans = Math.min(ans, mid);
                e=mid-1;
            }
            else if(N_Groups_on_Mid > groups) s = mid+1;
//            else e = mid-1;  // here also ans is determined.

        }

        return ans;

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr=new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        System.out.println("Enter the Number of Groups : ");
        int groups = sc.nextInt();

        System.out.println("Minimum of Maximum Sum possible in K groups is ?: " + BianrySearch(arr , groups));



    }
}
