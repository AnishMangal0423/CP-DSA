package DSA.Stack_and_Queue;


import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Approch -1 : Two Queues : Take Proper O(N) time to swap and push elemnts and O(1) time for pop and peek.
 *
 *               TC - O(N^2) for push but always tell for 1 elements so O(N) .
 *               SC - O(~2N)
 *
 *
 *
 *
 * Approch-2 : One Queue : Remove first size-1 elements and to last of queue.
 *
 *        TC - (SAME)
 *        SC - O(N)
 *
 *
 *        Means Every Pop and peek element will take O(n) time while push will take o(n) time.
 * **/



class MyStack{

    Queue<Integer> q;

    MyStack(){
        q=new LinkedList<>();
    }

    void push(int x){
        q.add(x);
    }

    boolean isEmpty(){
        return q.size()==0 ? true : false;
    }


    int peek(){

        int size = q.size();

        if(size==0)return -1;

        for(int i=0; i<size-1; i++){
            q.add(q.poll());
        }

        int ans = q.peek();
        q.add(q.poll());
        return ans;
    }



    int pop(){
        int size = q.size();

        if(size==0)return -1;

        for(int i=0; i<size-1; i++){
            q.add(q.poll());
        }

        return q.poll();

    }

}
public class Implement_Stack_using_Queues{

    public static void main(String[] args) {

        MyStack stk = new MyStack();

        System.out.println(stk.isEmpty());
        stk.push(10);
        stk.push(20);
        stk.push(30);
        stk.push(40);

        System.out.println(stk.peek());
        System.out.println(stk.pop());

        System.out.println(stk.isEmpty());


    }
}
