package Interviews.Amazon;
import  java.util.*;

/**
 *
 *  It is not that much clean code but yeah , It's a Good & Edge cases handling in stacks
 *
 *    Based on Montonic stacks.
 *
 *    Edge Cases -
 *    1. if k==n
 *    2. if k==0
 *    3. if 0 comes in front of stack (Leading Zeros).
 *    4. if at last , k !=0. so It is the time to remove last k elements.
 *
 *    And otherwise it is a simple Montonic stack.
 *
 *    TC - O(2N)
 *    SC - O(N)
 *
 * **/


public class A_Remove_K_digits{
    public static String removeKdigits(String num, int k) {
        Stack<Character> stk = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (!stk.isEmpty() && k > 0 && stk.peek() > digit) {
                stk.pop();
                k--;
            }
            stk.push(digit);
        }

        while (k > 0 && !stk.isEmpty()) {
            stk.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }

        sb.reverse();

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        // Test cases
      Scanner sc = new Scanner(System.in);
      String s = sc.nextLine();

      int k = sc.nextInt();
      System.out.println(removeKdigits(s, k));
    }
}
