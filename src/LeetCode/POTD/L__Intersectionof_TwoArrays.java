package LeetCode.POTD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class L__Intersectionof_TwoArrays {

    public static int[] Intersection(int[]nums1, int[]nums2){

         int n1 = nums1.length;
         int n2 = nums2.length;
         if(n1 < n2)return Intersection(nums2, nums1);
        HashMap<Integer, Integer>map = new HashMap<>();

        for(int i=0; i<n1; i++){
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        }

        ArrayList<Integer>ans = new ArrayList<>();

        for(int i=0; i<n2; i++){

            int arrval = nums2[i];
            if(map.containsKey(arrval)==true && map.get(arrval)>0){

                int val = map.get(arrval);
                map.put(arrval, val-1);
                ans.add(arrval);
            }

            else{
                continue;
            }

        }

        int[]anss = new int[ans.size()];
        for(int i=0; i<ans.size(); i++)anss[i]=ans.get(i);
return  anss;

    }
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[]nums1 = new int[n1];
        int[]nums2=new int[n2];
        for(int i=0; i<n1; i++)nums1[i]=sc.nextInt();
        for(int j=0; j<n2; j++)nums2[j]=sc.nextInt();

        System.out.println(Arrays.toString(Intersection(nums1, nums2)));
    }
}
