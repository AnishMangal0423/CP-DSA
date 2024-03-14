package DSA.LinkedList;

import java.util.Scanner;

/**
 * Concept :- Just detecting the Loop in LinkedList.
 * Approch :- Just use slow and fast Pointer . to meet .
 *
 *
 *
 *    tc - o(n)
 *    sc - o(1)
 * **/
public class K_Detect_Loop_in_LinkedList{

    public static ListNode FindNode(ListNode head, int pos){

        int count = 1;
        while (count!=pos){
            count++;
            head=head.next;
        }
        return head;
    }
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

    public static boolean isLoop(ListNode head){

        if(head==null)return false;  // This situation that  gave me Penalty.
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow!=fast && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        if(slow==fast)return true;
        else return false;

    }
    public static void main(String[] args) {

        ListNode list = LinkedList.CreateLinkedList();

        System.out.println("Enter the pos you want to connect : ");
        Scanner sc = new Scanner(System.in);
        int pos = sc.nextInt();
        if(pos!=-1) ConnectTail(list , pos);

        System.out.println("Is Loop Present in Linked List : " + isLoop(list));

    }
}
