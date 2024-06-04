package LeetCode.POTD;
import java.util.HashMap;
import java.util.Scanner;


/***
 *
 * TC - O(N + 26)
 * SC - O(26)
 *
 * */
public class H__LongestPalindrome__04062024 {

    public static int maxLen(String str){

        HashMap<Character, Integer>map = new HashMap<>();

        for(int i=0; i<str.length(); i++) map.put(str.charAt(i) , map.getOrDefault(str.charAt(i) , 0)+1);
        System.out.println(map);
        int maxLength = 0;
        boolean offFlag = false;

        for(char kii : map.keySet()){

            int val = map.get(kii);

            if(val%2!=0){
                if(offFlag==false){
                    offFlag=true;
                    maxLength+=val;
                }

                else maxLength+=(val-1);
            }

            else maxLength+=val;
        }

        return maxLength;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println("Maximum Length of Palindrome String is ?: " + maxLen(str));
    }
}
