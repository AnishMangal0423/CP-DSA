package DSA.Stack_and_Queue;

/**
 *
 *
 * Conecpt :- LinkedList, Nodes, Operations.
 * Approch:-  Approch1 -  Just O(n) for pop, peek() because of removing the tail node again and again.
 *
 *            Approch2 - Done all Operations in O(1) of Time.
 *                       what you have to do is Join LinkedList in Opposite diren like n3(head), n2, n1 , null
 *
 *                  TC - O(1) per Operation.
 *                  SC - O(1) per Operation.
 *
 * Learning :- Concept of Reverse Joining of Nodes.
 *
 *
 * ***/

class LinkedListNode{

    int data;
    LinkedListNode next;

    LinkedListNode(int data){
        this.data = data;
        next=null;
    }
}
class ImplementStack_By_LL{
    LinkedListNode head;
    int count;

    ImplementStack_By_LL() {
        head = null;
        count=0;
    }


    void push(int data){     // O(1) time.

        LinkedListNode newNode = new LinkedListNode(data);
        newNode.next=head;
        head=newNode;
        count++;
    }

    int peek(){            // O(1) time.
        if(head == null){
            System.out.println("Stack is Already Empty , and in UnderFlow Condition.");
            return -1;
        }
        return head.data;
    }

    int pop(){          // O(1) time.
        if(head == null){
            System.out.println("Stack is Already Empty , and in UnderFlow Condition.");
            return -1;
        }

        int ans = head.data;
        head=head.next;
        count--;
        return ans;
    }

    boolean isEmpty(){     // O(1) time.
        return head==null;
    }


    int size(){          // O(1) time.
       return count;
    }
}

public class E_Implement_Stack_Using_LinkedList{
    public static void main(String[] args) {

        ImplementStack_By_LL stk = new ImplementStack_By_LL();
        System.out.println(stk.isEmpty());
        stk.push(10);
        stk.push(20);
        stk.push(30);
        stk.push(40);
        stk.push(50);
        System.out.println(stk.size());
        System.out.println(stk.peek());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.size());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
    }
}
