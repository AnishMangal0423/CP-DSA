package TLE_LVL_2.CS31_Sheet._1200;


/**
 *
 * Concept :- Finding the Minimum Length of Step that vika will put to reach same colored Plank with the flexilibity that
 *            she can ignore one plank in Between.
 *
 * Approch :- Okay so There is No restriction over Number of planks she can Move so, we have to keep the track of index.
 *            1. Long Story of Question.
 *            2. Understanding the Problem.
 *            3. Using the Indexes of Same colors storage.
 *            4. Difference of Indexes track.
 *            5. Sorting them.
 *            6. Maximum and breaking the largest jump into 2 and compare it with second last.
 *
 *
 *  Learning :- Always we have jump qns , we can use Array of indexes, difference, sortings, breakings, comparisions.
 *
 *
 *
 * **/

import java.util.*;

public class E_Vika_and_the_Bridge{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[]arr = new int[n];
            for(int i=0; i<n; i++)arr[i] = sc.nextInt();

            HashMap<Integer, ArrayList<Integer>>map = new HashMap<>();

            for(int i=0; i<n; i++){
                int val = arr[i];
                if(map.containsKey(val)==false){
                    ArrayList<Integer>temp = new ArrayList<>();
                    temp.add(i);
                    map.put(val, temp);
                }

                else{
                    ArrayList<Integer>temp = map.get(val);
                    temp.add(i);
                    map.put(val, temp);
                }
            }

            int mini = Integer.MAX_VALUE;
            for(int kii : map.keySet()){

                ArrayList<Integer>temp = new ArrayList<>();
                ArrayList<Integer>m = map.get(kii);

                temp.add(m.get(0)+1);
                for(int i=1; i<m.size(); i++){
                    temp.add(m.get(i)-m.get(i-1));
                }
                temp.add(n - (m.get(m.size()-1)));
                Collections.sort(temp);

//                System.out.println(temp);
                int last = temp.get(temp.size()-1);
                int slast = temp.get(temp.size()-2);
                mini = Math.min(mini, Math.max(((last)+1)/2 , slast));

            }

            System.out.println(mini-1);

        }
    }
}
