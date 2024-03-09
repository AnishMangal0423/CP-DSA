package DSA.Stack_and_Queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * Ckeck Parenthsis -
 *
 * TC - O(2N)
 * SC - O(N)
 *
 * Three cases --> ((((( , )))))) , ((())){{{[]}}}
 *
 *
 * **/

public class G_Check_for_Valid_Paranthesis{

    public static boolean isValid(String s){

        Stack<Character>stk = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c == '(' || c =='[' || c=='{')stk.push(c);
            else {
                if(stk.size()==0)return false;
                char prev = stk.peek();
                if (c==')' && prev=='(')stk.pop();
                else if (c=='}' && prev=='{')stk.pop();
                else if(c==']' && prev=='[')stk.pop();
                else return false;
            }
        }
        return stk.size()>0 ? false : true;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string :- ");
        String s = sc.nextLine();

        System.out.println("is String have Valid Parenthesis Order :- " + isValid(s));
    }
}
