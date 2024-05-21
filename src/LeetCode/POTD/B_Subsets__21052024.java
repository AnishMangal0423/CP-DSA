package LeetCode.POTD;
import com.sun.source.tree.ArrayAccessTree;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * TC - O(2^N * N)
 * SC - O(2^N * N)  --> as the answer array space.
 *
 * **/

public class B_Subsets__21052024 {
    public static void Subset(int[]arr,int ind , ArrayList<ArrayList<Integer>>temp, ArrayList<Integer>helper){

        if(ind == arr.length){
            ArrayList<Integer>variable = new ArrayList<>(helper);
            temp.add(variable);
            return;
        }

        helper.add(arr[ind]);
        Subset(arr, ind+1, temp, helper);
        helper.remove(helper.size()-1);
        Subset(arr, ind+1, temp, helper);
    }

    public static void PowerSubset(int[]arr, ArrayList<ArrayList<Integer>>ans){

        int n = arr.length;
        int N_PowerSets = (1 << n);

        for(int i=0; i<N_PowerSets; i++){

            ArrayList<Integer>temp = new ArrayList<>();

            for(int j=0; j<n; j++){

                if((i & (1 << j))!=0){
                    temp.add(arr[j]);
                }
            }

            ans.add(temp);
        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr=new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();
        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
        Subset(arr,0, ans, new ArrayList<>());
        System.out.println("All the Subsets of the Given ArrayList is ?: " + ans);

        ArrayList<ArrayList<Integer>>PowersetAns = new ArrayList<>();
        PowerSubset(arr, PowersetAns);
        System.out.println("All the Subsets that I founded using Powerset Method ?: " + PowersetAns);

    }
}
