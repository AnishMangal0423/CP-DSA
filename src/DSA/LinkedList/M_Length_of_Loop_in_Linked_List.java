package DSA.LinkedList;

import java.util.Scanner;

/**
 *
 * Approch :-
 *      Approch1 :- Using HashMap to store the node and timer.
 *                  start timer from head node till they meet again so ans = (2nd time visit time - 1th time visit time)
 *
 *      Approch2 :- Hare & Tortoise -
 *      Learning - jab bhi slow and fast milenge to loop length t loop ki kisi bhi node se wapas aane ka hi time hota h.
 *                 Jaruri nhi h , Loop starting node se hi length nikalo.
 *
 *
 * TC - ~ O(N)
 * SC - ~ O(1)
 * **/
public class M_Length_of_Loop_in_Linked_List {

    // Just the Helper fn to Make the Looped LL.
    public static ListNode FindNode(ListNode head, int pos){

        int count = 1;
        while (count!=pos){
            count++;
            head=head.next;
        }
        return head;
    }

    // Just the Helper fn to Make the Looped LL.
    public static void  ConnectTail(ListNode head, int pos){

        ListNode tail = head;
        ListNode temp = head;
        while (temp.next!=null){
            temp=temp.next;
            tail = temp;
        }

        ListNode LoopingNode = FindNode(head, pos);
        tail.next = LoopingNode;

    }

    public static int LoopLength(ListNode head){

        // Step-1 : Sabse phle collision krwayenge slow and fast ka -

        ListNode slow=head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

        // Step-2 :- collision ke baad slow and fast to ek loop mai ghumyenge for getting length or count .
            if(slow==fast){
                int count =0;
                slow=fast.next;
                while (slow!=fast){
                    slow=slow.next;
                    count++;
                }
                return count+1;
            }
        }

        //Step3 :- It means Linked List has Not any Loop so length of loop is 0.
        return 0;
    }
    public static void main(String[] args) {

        ListNode list = LinkedList.CreateLinkedList();

        System.out.println("Enter the pos you want to connect : ");
        Scanner sc = new Scanner(System.in);
        int pos = sc.nextInt();
        if(pos!=-1) ConnectTail(list , pos);

        System.out.println("Length of Loop in Linked List is :  "+ LoopLength(list));
    }
}
