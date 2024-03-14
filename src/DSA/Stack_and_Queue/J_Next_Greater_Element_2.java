package DSA.Stack_and_Queue;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/***
 *
 *
 * Best solution h ye iska.
 * TC - O(2n + 2n)
 * SC - O(2n) stack space.
 *
 * **/
public class J_Next_Greater_Element_2{

    public static void NextGreaterElement2(int[]arr, int[]ans){

        int n = arr.length;
        Stack<Integer>stk = new Stack<>();
        for(int i=2*n-1; i>=0; i--){

            int val = arr[i % n];
            while (stk.isEmpty()==false && stk.peek() <= val) stk.pop();

            if(stk.isEmpty()!=true)ans[i % n]= stk.peek();

            stk.push(val);
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr= new int[n];

        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        int[]ans = new int[n];
        Arrays.fill(ans, -1);
        NextGreaterElement2(arr, ans);
        System.out.println("Next Greater Element in an array : " + Arrays.toString(ans));

    }
}
