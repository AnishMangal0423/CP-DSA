package DSA.Stack_and_Queue;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class I_Next_Greater_Element_1{

    public static void NextGreaterElement(int[]arr){

        Stack<Integer>stack=new Stack<>();
        int n = arr.length;

        for(int i=n-1; i>=0; i--){

            int val = arr[i];

            while (stack.isEmpty()==false && val > stack.peek()){
                stack.pop();
            }

            if(stack.isEmpty()==true){
                arr[i]=-1;
            }
            else{
                arr[i]=stack.peek();
            }

            stack.push(val);
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr= new int[n];

        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        NextGreaterElement(arr);
        System.out.println("Next Greater Element in an array : " + Arrays.toString(arr));

    }
}
