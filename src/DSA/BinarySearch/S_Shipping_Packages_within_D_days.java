package DSA.BinarySearch;

import java.util.Scanner;

/**
 *
 * Concept ;- Application of Modified Binary Search.
 *Approches ;-
 *      Approch-1 :- Brute Force solution- we have to find certainer weight of which it can load in given days.
 *                   and starting point will be - highest number because atleast all weights should port.
 *                   and ending number will be sum of all weights to port in only 1 day.
 *
 *            1. TC - O( (Sum of Elements) * (N))  ~ 10^10.
 *            2. SC - O(1)
 *
 *
 *      Approch-2 :- Use Binary Search smartly and find the certains digits which will give number of less and high according to calculation.
 *                   If we found days <= Given days means value will be higher isi liye jada no club karke kam grp bnaya h so ans updated and e=mid-1
 *                   And, vice-vera.
 *
 *           1. TC - O( log(Sum of Elements) * N)  ~ 10^6
 *           2. SC - O(1)
 *           3. Just write the N loop function as MidcheckGroups easily by... calculating the sum and check whether > mid or
 *              not and all...

 * **/
public class S_Shipping_Packages_within_D_days {

    public static int FindDaysonMid(int[]weights, int mid){

        int count = 0;
        int n = weights.length;

        int sum=0;
        for(int i=0; i<n; i++){
            sum+=weights[i];
            if(sum > mid){
                count++;
                sum=weights[i];
            }
        }

        return count + 1 ;
    }
    public static int FindCapacity(int[]weights, int days){

        int n = weights.length;
        int sum = 0;
        int maxi=-1;
        for(int i=0; i<n; i++){
            sum+=weights[i];
            maxi=Math.max(maxi, weights[i]);
        }

        int s = maxi;
        int e = sum;
        int ans = (int) 1e9;

        while (s <= e){

            int mid = (s + e)/2;

            int No_of_Groups = FindDaysonMid(weights, mid);

            System.out.println(s +" "+ mid+" "+e +" "+ No_of_Groups) ;
            if(No_of_Groups <= days){
                ans = Math.min(ans, mid);
                e=mid-1;
            }

            else s=mid+1;

        }
        return ans;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[]weights = new int[n];
        for(int i=0; i<n; i++)weights[i]=sc.nextInt();

        int days = sc.nextInt();

        System.out.println("Min Capacity of ship to Complete the work in k days is : " + FindCapacity(weights , days));
    }
}
