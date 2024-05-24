package LeetCode.POTD;
import java.util.*;
import java.util.HashMap;
import java.util.Scanner;


/**
 *
 * problem : To hame kuch words given H and we have to use the concept ki take-non_take takking kuch variation bn payee
 *           and we will get the result that is Maximum to get out of it.
 *
 * Time Complexity ?: (2^(No of words) * N)
 * Space Complexity ?: (2 ^ (No of words))
 *
 * Overall exponential method h and we have can do for small inputs.
 * Topic - Backtracking.
 *
 * Problems ?: yrr ki hashmap backtarcking mai to ja rha h , but removal mai hashmp se kese krenge. and the solution is ki yrr hmm
 *             harr word par ek state maintain kr de ki it was taken or Not.
 *
 *
 * **/

public class E_MaximumScore_wordsFormed__24052024{


    public static boolean checkAvailable(String word, HashMap<Character, Integer>map){

        HashMap<Character, Integer> bufferMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            bufferMap.put(word.charAt(i), bufferMap.getOrDefault(word.charAt(i), 0) + 1);
        }

        for (Character key : bufferMap.keySet()) {
            int val = bufferMap.get(key);
            if (val > map.getOrDefault(key, 0)) return false;
        }

        return true;
    }
    public static int  MaximumScore(String[]words , char[]letter , int[]score, HashMap<Character, Integer>map, int index){


        if(index == words.length) return 0;

        String word = words[index];
        int wordScore = 0;
        boolean canTakeWord = checkAvailable(words[index], map);


        if (canTakeWord) {
            for (int i = 0; i < word.length(); i++) {
                char wordLetter = word.charAt(i);
                wordScore += score[wordLetter - 'a'];
                map.put(wordLetter, map.get(wordLetter) - 1);
            }
        }

        int take = canTakeWord ? wordScore + MaximumScore(words, letter, score, map,  index + 1) : 0;

        if (canTakeWord) {
            for (int i = 0; i < word.length(); i++) {
                map.put(word.charAt(i), map.get(word.charAt(i)) + 1);
            }
        }

        int nonTake = MaximumScore(words, letter, score, map,index + 1);

        return Math.max(take, nonTake);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int wordsLength = sc.nextInt();
        int letterLength = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        String[] words = new String[wordsLength];
        char[] letters = new char[letterLength];
        int[] score = new int[26];

        for (int i = 0; i < wordsLength; i++) {
            words[i] = sc.nextLine();
        }

        String letterString = sc.nextLine();
        for (int i = 0; i < letterLength; i++) {
            letters[i] = letterString.charAt(i);
        }

        for (int i = 0; i < 26; i++) {
            score[i] = sc.nextInt();
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (char letter : letters) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }
        ArrayList<String>helper = new ArrayList<>();
        ArrayList<ArrayList<String>>store = new ArrayList<>();
        System.out.println("Maximum Score that can be Formed is: " + MaximumScore(words, letters, score, map, 0));

    }
}
