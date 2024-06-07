package LeetCode.POTD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class I__Find_Common_Characters {

    public static List<String> CommonCharacters(String[] words){

        int n = words.length;
        HashMap<String , Integer> map = new HashMap<>();

        String first = words[0];
        for(int i=0; i<first.length(); i++){
            map.put(first.charAt(i)+"", 1);
        }
        for(int i=1; i<n; i++){
            String word = words[i];

            for(int j=0; j<word.length(); j++){

                String chars = word.charAt(j)+"";
                if(map.containsKey(chars)==true){
                    map.put(chars , map.getOrDefault(chars, 1)+1);
                }

            }
        }

        List<String>ans = new ArrayList<>();

        for(String kii : map.keySet()){

            int val = map.get(kii);
            if(val>=n)ans.add(kii);
        }

        return ans;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[]arr=new String[n];

        for(int i=0; i<n; i++)arr[i]=sc.next();

        System.out.println("Common Characters in All words is ?: " + CommonCharacters(arr));
    }
}
