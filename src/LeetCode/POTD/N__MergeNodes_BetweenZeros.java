package LeetCode.POTD;

import DSA.LinkedList.LinkedList;
import DSA.LinkedList.ListNode;

public class N__MergeNodes_BetweenZeros {

    public static ListNode MergeLL(ListNode head){

        ListNode dummy = new ListNode(-1000);
        ListNode tail = dummy;

        ListNode temp = head.next;

        while (temp!=null) {
            ListNode mainNode = temp;
            int sum = 0;
            while (temp.data != 0) {
                sum += temp.data;
                temp = temp.next;
            }

            tail.next=mainNode;
            tail=tail.next;
            tail.data=sum;
            temp=temp.next;
        }

        return dummy.next;
    }
    public static void main(String[] args) {

        ListNode list = LinkedList.CreateLinkedList();
        ListNode ans = MergeLL(list);

    }
}
