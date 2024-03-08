package DSA.Stack_and_Queue;

/**
 *
 * Concept :- LinkedList, Nodes, Queue Operations.
 * Approch :- Simple LL Make.
 *
 * TC - O(1)
 * SC - O(1) Per operation.
 *
 *
 * **/

class ImplementQueue_ByLL{
    LinkedListNode head;
    LinkedListNode tail;
    int count;

   ImplementQueue_ByLL(){
       head = null;
       count=0;
   }

   void push(int data){
       LinkedListNode newNode = new LinkedListNode(data);
       if(head==null){
           head=newNode;
           tail=newNode;
       }
       else {
           tail.next=newNode;
           tail=tail.next;
       }
       count++;
   }

   int peek(){
       if(head == null){
           System.out.println("Queue is Already Empty , and in UnderFlow Condition.");
           return -1;
       }
       return head.data;
   }

    int pop(){
        if(head == null){
            System.out.println("Queue is Already Empty , and in UnderFlow Condition.");
            return -1;
        }

        int ans = head.data;
        head=head.next;
        count--;
        return ans;
    }

   int size(){
       return count;
   }

    boolean isEmpty(){
       return count==0;
    }

}
public class F_Implement_Queue_using_LinkedList{
    public static void main(String[] args) {

        ImplementQueue_ByLL q = new ImplementQueue_ByLL();
        System.out.println(q.isEmpty());
        q.push(10);
        q.push(20);
        q.push(30);
        q.push(40);
        q.push(50);
        System.out.println(q.size());
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.size());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());

    }
}
