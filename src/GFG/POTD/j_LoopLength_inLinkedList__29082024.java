package GFG.POTD;


import java.util.List;

public class j_LoopLength_inLinkedList__29082024 {

    public static int LengthofLoop(ListNode head){

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast!=null && fast.next!=null && fast!=slow){

            slow=slow.next;
            fast=fast.next.next;
        }

        // Case - It is a Case of Singly Linked List.
        if(fast==null || fast.next==null)return 0;

        // Case - Of Circular LinkedList.

        int count =0;
        slow=fast.next;
        while (slow!=fast){
            slow=slow.next;
            count++;
        }
        return count+1;
    }


    public static void main(String[] args) {

        ListNode l1 = LinkedList.CreateLinkedList();

        int LoopLen = LengthofLoop(l1);

        LinkedList.Display(l1);
    }
}
