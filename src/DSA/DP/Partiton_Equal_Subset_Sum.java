package DSA.DP;

import java.util.Scanner;
public class Partiton_Equal_Subset_Sum{

    public static boolean Partiton(int[]arr, int sum, int i){

        if(i > arr.length-1) return false;
        if(sum==0)return true;
        // take-
        boolean take=false;
        if(sum-arr[i] >= 0) {
            take= Partiton(arr, sum - arr[i], i + 1);
        }
        boolean non_take = Partiton(arr, sum , i+1);

        return take || non_take;
    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        int[]arr=new int[n];

        int sum=0;
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }

        if((sum & 1)==1) System.out.println("false");
        else System.out.println(Partiton(arr, sum/2, 0));
    }
}
