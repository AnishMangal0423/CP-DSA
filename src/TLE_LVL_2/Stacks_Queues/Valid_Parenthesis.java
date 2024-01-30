package TLE_LVL_2.Stacks_Queues;

import java.util.Scanner;
import java.util.Stack;

public class Valid_Parenthesis{

    /****

     Some Intresting Edge Cases.

     (((((()  ->>> stk has eleemnts at last
     ())))))) --> stk becomed empty in between.
     ((()))  --> checking balance.

      TC - O(N)
      SC - O(N)

     */
    public static boolean isValid(String brackets){

        Stack<Character>stk=new Stack<>();

        for(int i=0; i<brackets.length(); i++){

            char bracket = brackets.charAt(i);


            if(bracket == '(' || bracket=='{' || bracket=='[')stk.add(bracket);

            else if(stk.size() > 0) {
                if (bracket == ')' && stk.peek() == '(') stk.pop();
                else if (bracket == ']' && stk.peek()=='[')stk.pop();
                else if(bracket == '}' && stk.peek()=='{')stk.pop();
                else return false;
            }
            else return false;

        }

        return stk.isEmpty();
    }

/*

    TC - O(N)
    SC - O(1)   -> 91 /96 Passed. --> WRONG METHOD.

    "([)]" this is the testcase where it will Fail so it is Mandatory to note that by maintaining variables
           we can maintains counts and all but we cannot maintain the order .. that's why it is necassary to maintain stack.
           we can Balance out a 1 type of Bracket by it.

    public static boolean isValid_Constant_Space(String brackets){

        int round=0, curly=0, square=0;

        for(int i=0; i<brackets.length(); i++) {
            char c = brackets.charAt(i);
            if (c == '(') round++;
            else if (c == '{') curly++;
            else if (c == '[') square++;

            else if (c == ']' && square > 0) square--;
            else if (c == '}' && curly > 0) curly--;
            else if (c == ')' && round > 0) round--;
            else return false;

        }
        return (round==0 && curly==0 && square==0);
    }


 */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String brackets = sc.next();

        System.out.println(isValid(brackets));
    }
}
