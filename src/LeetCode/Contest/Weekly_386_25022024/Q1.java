package LeetCode.Contest.Weekly_386_25022024;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Concept :- Frequency Count of Array.
 * Learning :- Actual Time Complexity of Modern HashMaps in Java.
 *
 * HashMaps :- When First Java version JDK-1/2/3 was released then hashmap was made in Such a way that hashmaps
 *             Stores the most frequent elemnt like one Bucket(like an array) then it's tc becomes O(N)
 *                                                But , from Java-8 the most densed Bucket is also implemented
 *             Using the Trees and All which gives the Answer and all in O(LogN) time to serach key in hashmaps
 *             at Wost case..
 *
 *
 *
 *  Time complexity :-  O(NlogN)
 *  Space complexity :- O(N)        ~ All things are measured at Worst Case.
 *
 *
 *
 * **/

public class Q1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[]nums = new int[n];

        for(int i=0; i<n; i++)nums[i]=sc.nextInt();

        HashMap<Integer, Integer>m = new HashMap<>();

        for(int i=0; i<n; i++){

            if(m.containsKey(nums[i])==false){
                m.put(nums[i] , 1);
            }

            else{
                int vaal = m.get(nums[i]);

                if(vaal==2) System.out.println(false);
                m.put(nums[i], vaal+1);
            }
        }

        System.out.println(true);
    }
}



/**
 *
 * In Java, starting from JDK 8, the HashMap implementation uses a data structure known as a hash table
 * to store keys and values. In particular, it uses a combination of linked lists and a mechanism called tree bins
 * to handle situations where there are many keys with the same hash code (collisions).
 *
 * When a certain bucket in the hash table (resulting from a hash code) has too many entries
 * (e.g., due to hash collisions), the linked list for that bucket is converted into a tree.
 * This is known as the treeify operation, and it aims to improve the performance of operations in scenarios
 * with a large number of collisions. The tree used is a red-black tree, a self-balancing binary search tree.
 *
 * The introduction of trees in HashMap was done to address the issue of performance degradation when
 * there are a lot of collisions in a particular bucket. Tree-based structures have better worst-case
 * time complexity for certain operations compared to linked lists.
 *
 * It's worth noting that the exact implementation details might be subject to change in different JDK versions,
 * so always refer to the documentation and source code of the specific JDK version you are working with for the
 * most accurate and up-to-date information.
 *
 * **/
