package TLE_LVL_2.Stacks_Queues;


import java.util.Scanner;
import java.util.Stack;


/**
 *
 *  Approch --> Just Do push oprn in input stack and whenever there we have to like have peek or pop and output is empty
 *              move elements from input to output.
 *
 *          TC - O(N) For N elements so amortized will be O(1) For N operations .
 *          SC - O(2N)
 *
 *
 *
 * Approch-2 --> We can Also use the 1 stack and Recursive, but again we are using the auxilary space and quadratic time
 *               Although it is Not Optimal One ..
 *
 *          TC - O(N^2) FOR poping N elements.
 *          SC - O(N + ??)
 *
 *
 * **/



class MyQueue{

    Stack<Integer>input;
    Stack<Integer>output;
    MyQueue(Stack<Integer>i, Stack<Integer>o){

        this.input=i;
        this.output=o;
    }


    void push(int x){
       input.push(x);
    }

    boolean isEmpty(){
        return input.size() + output.size() ==0 ? true : false;
    }

    int peek(){

        if(output.size()==0 && input.size()==0)return -1;
        if(output.size()==0){

            while(input.size()!=0){

                output.push(input.pop());
            }
        }
        return output.peek();
    }

    int pop(){

        if(output.size()==0 && input.size()==0)return -1;
        if(output.size()==0){

            while(input.size()!=0){

                output.push(input.pop());
            }
        }
        return output.pop();

    }

}
public class Implement_Queue_using_Stack{

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        Stack<Integer>stk1=new Stack<>();
        Stack<Integer>stk2=new Stack<>();

        MyQueue q = new MyQueue(stk1, stk2);
        System.out.println("size : "+q.isEmpty());
        q.push(10);
        q.push(20);
        q.push(30);
        q.push(40);

        System.out.println(q.pop());
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.pop());


        q.push(50);
        q.push(60);
        q.push(70);

        System.out.println(q.pop());
        System.out.println(q.pop());




    }
}
