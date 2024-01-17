package TLE_LVL_2.Backtracking;

import java.util.*;

public class PhoneNumber_Backtracking{


    public static void Combination(String[]arr, ArrayList<String>output, String helper, int index){

        if(index == arr.length){

            output.add(helper);
            return;
        }

        String temp = arr[index];
        for(int i=0; i<temp.length(); i++){
            helper+=temp.charAt(i);
            Combination(arr, output, helper, index+1);
            helper= helper.substring(0, helper.length()-1);
        }
    }

    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);


        String digits = sc.nextLine();

        HashMap<Character, String>map=new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        String[]arr = new String[digits.length()];

        for(int i=0; i<digits.length(); i++){
            arr[i]=map.get(digits.charAt(i));
        }
        ArrayList<String>output = new ArrayList<>();


        if(digits.length() > 0) Combination(arr, output, "", 0);

        System.out.println(output);
    }

}