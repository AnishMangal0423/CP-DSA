//package DSA.DP;
//
//import java.util.Arrays;
//import java.util.Scanner;
//import java.util.TreeMap;
//
//public class m {
//
//    public static void main(String[] args) {
//
//        Scanner sc=new Scanner(System.in);
//
//        int n=sc.nextInt();
//        String word=sc.next();
//
//
//        TreeMap<Character, Integer>m=new TreeMap<>();
//
//        for(int i=0; i<n; i++){
//
//            char c=word.charAt(i);
//
//            if(m.containsKey(c)==true){
//                int val=m.get(c);
//                m.put(c, val+1);
//            }
//
//            else m.put(c, 1);
//        }
//
//
//        int i=0;
//        int l=1;
//        int ans=0;
//        for(Character c : m.keySet()){
//
//            if(i%8==0 && i>1)l++;
//
//            ans+=l*(m.get(c));
//            i++;
//        }
//
//int[]arr=new int[26];
//
//        for(int j=0; j<n; j++){
//            char c=word.charAt(j);
//            arr[c-'a']++;
//        }
//
//        Arrays.reverse(arr);
//
//    }
//}


import java.util.*;

class m {
    public int minimumPushes(String word) {
        int n = word.length();

        int[] arr = new int[26];

        for (int j = 0; j < n; j++) {
            char c = word.charAt(j);
            arr[c - 'a']++;
        }

        // Convert to Integer[] for sorting
        Integer[] arrInteger = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(arrInteger, Comparator.reverseOrder());
        System.out.println(Arrays.toString(arrInteger));

        int i = 0;
        int l = 1;
        int ans = 0;
        for (int aa : arrInteger) {
            if (i % 8 == 0 && i > 1) l++;

            ans += l * aa;
            i++;
        }
        return ans;
    }
}
