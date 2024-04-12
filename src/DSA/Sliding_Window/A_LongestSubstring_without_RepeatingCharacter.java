package DSA.Sliding_Window;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * Concept ::- Concept of Sunstring.
 * Approch- Brute force-
 *         TC - O(N*N)
 *         SC - O(256)
 *
 *         Approch-2 :: 2-Pointer Sliding Window Approch-
 *         hmne 2 pointer le liye start and end and ek hashmap bhi le liya and then move krate gye if window mai koi repatative aaya
 *         window ko choti krke repeating character + 1 index par rkhkar , window ko sahi kr diya.
 *
 *         TC - O(N)
 *         SC - O(256)
 *
 * Note ::- Use Array of 256 rather then , using Hashmao , becuase hashmap in worst case takes logN time .
 *
 * **/
public class A_LongestSubstring_without_RepeatingCharacter{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        HashMap<Character , Integer>map = new HashMap<>();
        int start = 0;  int end = 0;
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if(!map.containsKey(curr)==false){

                int index = map.get(curr);
                if(index >= start)start=index+1;
            }

            map.put(curr , i);
            maxlen = Math.max(maxlen, end - start + 1);
            end++;
        }

        System.out.println(maxlen);
    }


    }

