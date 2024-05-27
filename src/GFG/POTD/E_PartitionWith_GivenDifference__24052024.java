package GFG.POTD;

import java.util.ArrayList;
import java.util.Scanner;

public class E_PartitionWith_GivenDifference__24052024 {

    public static int Partition(int[]arr, int sum, int d, int index, int NowSum , ArrayList<ArrayList<Integer>>store, ArrayList<Integer>helper){

        if(index == arr.length)return 0;
        int s1 = NowSum;
        int s2 = sum-s1;

        System.out.println(s1+" "+ s2+" In " + index);
//        if(s1-s2==d)return 1;

        int taken = Partition(arr, sum , d, index+1, NowSum+arr[index] , store, helper);
        int non_taken = Partition(arr, sum, d, index+1, NowSum , store, helper);

        return taken + non_taken;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[]arr = new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();


        ArrayList<ArrayList<Integer>>store = new ArrayList<>();
        ArrayList<Integer>helper = new ArrayList<>();
        int sum=0; for(int i=0; i<n; i++)sum+=arr[i];
      int val =  Partition(arr, sum, d, 0, 0, store, helper);
        System.out.println("Pairs that have s1-s2=d are ?: " + val);

    }
}
