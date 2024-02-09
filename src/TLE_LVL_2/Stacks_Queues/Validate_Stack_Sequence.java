package TLE_LVL_2.Stacks_Queues;

import java.util.Scanner;
import java.util.Stack;

public class Validate_Stack_Sequence {

    public static boolean isValidate(int[]pushed, int[]poped){

        int index = 0;
        Stack<Integer>stk = new Stack<>();
        int n = pushed.length;

        for(int i=0; i<n; i++){

            stk.push(pushed[i]);

            while (index < n && !stk.isEmpty() && stk.peek() == poped[index]){
                stk.pop();
                index++;
            }
        }

        return index==n;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();

        int[]pushed=new int[n];
        int[]poped = new int[n];

        for(int i=0; i<n; i++)pushed[i]=sc.nextInt();
        for(int i=0; i<n; i++)poped[i]=sc.nextInt();

        System.out.println("Is Stack Validate : "+ isValidate(pushed, poped));
    }
}
