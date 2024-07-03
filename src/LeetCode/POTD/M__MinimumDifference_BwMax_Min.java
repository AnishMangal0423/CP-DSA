package LeetCode.POTD;

import java.util.PriorityQueue;
import java.util.Scanner;

public class M__MinimumDifference_BwMax_Min {

    public static int[] MinPq(int[]arr){

        // I want to Get Min 3 Elements -
        PriorityQueue<Integer>pqmax = new PriorityQueue<>((a, b)-> b-a);
        for(int i=0; i<arr.length; i++){

            pqmax.add(arr[i]);

            if(pqmax.size()>3) pqmax.poll();
        }

        int[]Minarr = new int[3];
        for(int i=0; i<3; i++)Minarr[2-i]=pqmax.poll();

        return Minarr;
    }

    public static int[] MaxPq(int[]arr){

        // I want to Get Min 3 Elements -
        PriorityQueue<Integer>pqmax = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++){

            pqmax.add(arr[i]);

            if(pqmax.size()>3) pqmax.poll();
        }

        int[]Minarr = new int[3];
        for(int i=0; i<3; i++)Minarr[2-i]=pqmax.poll();

        return Minarr;
    }

    public static int MinDiff(int[]arr){

        int n = arr.length;
        if(n<=3)return 0;

        int[]maxPq = MaxPq(arr);
        int[]minPq = MinPq(arr);

        int target = 0;
        int firstdiff = maxPq[1]-maxPq[2];
        int secronddiff = minPq[2]-minPq[1];
        if(firstdiff >= secronddiff){
            return maxPq[2]-minPq[1];
        }
        else return maxPq[1]-minPq[2];


    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array ");
        int n = sc.nextInt();
        int[]arr = new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        System.out.println("Minimum Difference is :- " + MinDiff(arr));
    }
}
