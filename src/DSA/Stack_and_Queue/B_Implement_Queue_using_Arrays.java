package DSA.Stack_and_Queue;

/**
 * Statement :- Main thing in it isthe Declaration of Variables (What will be the Structure of class)
 *              People do not Able to choose which thing should Put or not.. Here having the count variable is Important.
 *              Without it we cannot Do this Question.
 *              * Whenever we cannot able to Manupulate Count from variables (Indexes) always put Explicit variables *
 *
 *              Here -
 *              si   ==  for returning peek , pop fns.
 *              ei   ==  for adding the new element.
 *             count ==  for keep track of no elements , so that Edge cases can be handled.
 *             arr   == Implementation Data structure.
 *             maxSize == For declaration of Array and maintaing Edge Cases.
 *
 *
 *
 *   Base case Conditions.
 *                       1. Overflow --> Push condn.
 *                       2. Underflow --> Peek, pop oprn.
 *
 *
 *     TC - O(1)
 *     SC - O(1)   --> for 1 operation.
 *
 *
 * **/

class QueueArray{

    int si;

    int ei;

    int count;
    int[] arr;
    int maxSize;

    QueueArray(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        count=0;
        si = 0;
        ei = 0;
    }

    public void push(int val){

        if(count == maxSize) System.out.println("Queue is Already Filled , and Now in Overflow State.. and You are trying to push "+ val + " also .");
        else{
            arr[(ei % maxSize)]=val;
            count++;
            ei++;
        }
    }

    public int peek(){
        if(count == 0){
            System.out.println("Queue is Empty, and You are trying to Access the Elements .. ");
            return -1;
        }

        else  return arr[(si) % maxSize];

    }

    public int pop(){
        if(count == 0){
            System.out.println("Queue is Empty, and You are trying to Deleting the Element.. ");
            return -1;
        }

        else{
            int val = arr[si];
            si = (si+1)% maxSize;
            count--;
            return val;
        }
    }

   public int size(){
       return count;
   }

   public boolean isEmpty(){
        return count == 0;
   }

}

public class Implement_Queue_using_Arrays {

    public static void main(String[] args) {

        QueueArray qA = new QueueArray(5);
        qA.push(10);
        qA.push(20);
        qA.push(30);
        qA.push(40);
        qA.push(50);
        qA.push(60);
        System.out.println("Size is : "+qA.size());
        System.out.println(qA.pop());
        System.out.println(qA.pop());
        System.out.println(qA.pop());
        qA.push(100);
        qA.push(20);
        qA.push(30);
        System.out.println("Size is : "+qA.size());
        System.out.println(qA.pop());
        System.out.println(qA.pop());
        System.out.println(qA.pop());
        System.out.println(qA.pop());
        System.out.println(qA.pop());
        System.out.println("Is Queue Empty : "+qA.isEmpty());


    }
}
