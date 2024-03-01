package DSA.Stack_and_Queue;
import java.util.Stack;
class StackArray{

    int index = 0;
    int[]arr;

    int maxSize;

    StackArray(int MaxSize){

        this.maxSize = MaxSize;
        arr = new int[maxSize];
    }

    void push(int data){

        if(index >= maxSize){
            System.out.println("We cannot Insert the Element .. Index out of range ");
            return;
        }
        arr[index]=data;
        index++;
    }

    int pop(){

        if(index == 0){
            System.out.println("Stack is Empty Already and Now it will Be go in Underflow Condition : ");
            return Integer.MIN_VALUE;
        }
        index--;
        return arr[index];

    }

    int peek(){

        if(index == 0){
            System.out.println("Stack is Empty Already and we Can't Access First Element : ");
            return Integer.MIN_VALUE;
        }
        return arr[index-1];


    }
    int size(){
        return index;
    }


    boolean isEmpty(){
        return index == 0;
    }
}
public class Implement_Stack_Using_Array{

    public static void main(String[] args) {

     StackArray stk = new StackArray(100);
        stk.push(10);
        stk.push(20);
        stk.push(30);
        System.out.println(stk.isEmpty());
        System.out.println(stk.peek());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.peek());
        System.out.println(stk.size());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
    }
}
