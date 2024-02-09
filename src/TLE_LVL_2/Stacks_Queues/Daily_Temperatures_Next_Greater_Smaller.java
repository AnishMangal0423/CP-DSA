package TLE_LVL_2.Stacks_Queues;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Daily_Temperatures_Next_Greater_Smaller {


    public static void Next_Greater_Temperature(int[]arr, int[]Greater_ans){


        Stack<Integer>stk = new Stack<>();
        int n=arr.length;

        for(int i=n-1; i>=0; i--){

            while (!stk.isEmpty() && arr[stk.peek()] <= arr[i]){
                stk.pop();
            }

            if(!stk.isEmpty()){
                Greater_ans[i]= stk.peek() - i;
            }

            stk.push(i);
        }

    }


    public static void Next_Smaller_Temperature(int[]arr, int[]Smaller_ans){


        Stack<Integer>stk = new Stack<>();
        int n=arr.length;

        for(int i=n-1; i>=0; i--){

            while (!stk.isEmpty() && arr[stk.peek()] >= arr[i]){
                stk.pop();
            }

            if(!stk.isEmpty()){
                Smaller_ans[i]= stk.peek() - i;
            }

            stk.push(i);
        }

    }



    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[]arr=new int[n];

        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        int[]Greater_ans=new int[n];

        Next_Greater_Temperature(arr, Greater_ans);

        System.out.println("Next Larger Temperature Day : "+ Arrays.toString(Greater_ans));


        int[]Smaller_ans = new int[n];

        Next_Smaller_Temperature(arr, Smaller_ans);

        System.out.println("Next Smaller Temperature Day : "+ Arrays.toString(Smaller_ans));


    }

}
//put: temperatures = [73,74,75,71,69,72,76,73]
//        Output: [1,1,4,2,1,1,0,0]