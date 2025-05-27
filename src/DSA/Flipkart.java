package DSA;

import java.util.*;
public class Flipkart {


    public static String pass(String s, int k){

        Map<Character, Integer>freq = new HashMap<>();
        Queue<Character>queue = new LinkedList<>();

        for(char ch : s.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch, 0)+1);

            if(freq.get(ch)==1){
                queue.add(ch); // Non - Repeating case.
            }

            while(!queue.isEmpty() && freq.get(queue.peek()) > 1){

                queue.poll();
            }
        }


        int count=0;

        for(char ch : queue){
            count++;

            if(count==k){
                return String.valueOf(ch);
            }
        }
      return null;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();

        System.out.println(pass(s, k));


    }
}
