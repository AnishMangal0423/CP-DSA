package LeetCode.POTD;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


/**
 *
 * Problem/ Concept :- Hame saree Subsets Find krne h , and then har subset par yeh baat chalani h ki kisi bhi subset mai two values ke
 *                     difference k nhi hona chaiye.
 *
 *  Approches :- 1. Brute Force -
 *                  Normally saree subsets nikalkar O(N^2) use krlo.
 *                   TC - O(2^N * N^2)
 *
 *                2. Optimal Solution :-
 *                   HashMap bagera use kro like backtracked Hashmap and then entries ko remove krte rhna jese hi kaam ho jaye os dicision node par too.
 *                   TC - O(2^N * N) + O(NlogN) + O(N)
 *                   SC - O(2*N * N) for Ans array.
 *                        O(N) hashmap and helper array.
 *
 *
 *
 * **/

public class D_BeautifulSubsets__23052024 {

    public static boolean IsHelperBeautiful(ArrayList<Integer>helper, int k , HashMap<Integer, Integer>map){

        for(int i=0; i<helper.size(); i++){
            if(map.containsKey(helper.get(i)+k)==true && map.get(helper.get(i)+k)>0){
                return false;
            }
        }


        return true;
    }
    public static void Beautiful_Subsets(int[]arr, int k,int ind, ArrayList<ArrayList<Integer>>ans, ArrayList<Integer>helper, HashMap<Integer, Integer>map){

        if (ind==arr.length){
            // helper taiyaar h -

            if(helper.size()>0 && IsHelperBeautiful(helper, k, map)==true){
                ans.add(new ArrayList<>(helper));
            }


            return;
        }

        helper.add(arr[ind]);
        map.put(arr[ind], map.getOrDefault(arr[ind], 0)+1);
        Beautiful_Subsets(arr, k, ind+1, ans, helper, map);
        int rem = helper.get(helper.size()-1);
        helper.remove(helper.size()-1);
        map.put(rem, map.get(rem)-1);
        Beautiful_Subsets(arr, k, ind+1, ans, helper, map);


    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr=new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();
        int k = sc.nextInt();

        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
        ArrayList<Integer>helper = new ArrayList<>();

        HashMap<Integer, Integer>map = new HashMap<>();
        Arrays.sort(arr);

        Beautiful_Subsets(arr, k, 0,  ans, helper, map);
        System.out.println("Number of Beautiful Subsets are ?: " + ans);
    }
}
