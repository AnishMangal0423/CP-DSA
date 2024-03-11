package DSA.Stack_and_Queue;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * Simple-
 * Approch-1 :- Use o(N) time for every min Operation.
 * Approch-2 :- Make the pairs in stack according to min value.
 *
 * TC - O(1)
 * SC - O(2)   for every iterations.
 *
 *
 * Edge Case --> I have made the class Variable min , and use the minimim accoeding to our min.
 *               But think that if min will get become very negative and array becomes empty and now , you are adding some
 *               elements and if you will use that min, it will give more negative , so we have to use the top elements in stack
 *               and when arr.size=0, we will intilaize the min.
 *
 *
 * **/
class MinPairs{
    int vaal;
    int minimum;

    MinPairs(int val, int minimum){
        this.vaal=val;
        this.minimum=minimum;
    }
}
class MinStack{

    ArrayList<MinPairs>arr;

//    int min;
    MinStack(){
        arr=new ArrayList<>();
//        min=Integer.MAX_VALUE;
    }

    void push(int val){
//        arr.add(new MinPairs(val, min= Math.min(min, val)));

        int min = -1;
        if(arr.size()==0) min = val;
        else min = (int)arr.get(arr.size()-1).minimum;

        arr.add(new MinPairs(val , Math.min(min, val)));
    }

    void pop(){
        if(arr.size() == 0){
            System.out.println("Stack is Empty ! and in underflow Condition");
            return;
        }
        arr.remove(arr.size()-1);
    }

    int top(){
        if(arr.size() == 0){
            System.out.println("Stack is Empty ! and in underflow Condition");
            return -1;
        }
        return arr.get(arr.size()-1).vaal;
    }

    int getMin(){
        if(arr.size() == 0){
            System.out.println("Stack is Empty ! and in underflow Condition");
            return -1;
        }
        return arr.get(arr.size()-1).minimum;

    }

}
public class H_Min_Stack{
    public static void main(String[] args) {

        MinStack stk = new MinStack();

        stk.push(10);
        stk.push(20);
        System.out.println(stk.getMin());
        stk.push(30);
        System.out.println(stk.top());
        stk.pop();
        stk.push(40);
        stk.push(50);
        System.out.println(stk.getMin());
        stk.push(60);

    }
}
