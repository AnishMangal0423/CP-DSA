package LeetCode.POTD;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class J__Hands_of_Straights{

    public static boolean isPossible(int[]arr, int groupsize){
        int n = arr.length;

        if(n%groupsize!=0)return false;

        // O(NlogN)
        TreeMap<Integer, Integer>map=new TreeMap<>();
        for(int i=0; i<n; i++)map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        System.out.println(map);
        // O(NlogN)
        for(int i=0; i<(n/groupsize); i++){

            int prev = -1;
            int size = 0;
            for(int kii : map.keySet()){
                System.out.println(map);
                int val = map.get(kii);
                if(prev==-1 || kii-prev == 1){
                    if(val==1)map.remove(kii);
                    map.put(kii, val-1);
                    prev=kii;
                }

                else return false;
                size++;

                if(size==groupsize)break;
            }
        }

        return true;
    }
//    [1,2,3,6,2,3,4,7,8], groupSize = 3
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();
        int groupsize = sc.nextInt();

        System.out.println("Is it Possible to divide ?: " + isPossible(arr, groupsize));
    }
}
