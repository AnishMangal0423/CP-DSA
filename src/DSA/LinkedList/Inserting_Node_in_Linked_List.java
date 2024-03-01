package DSA.LinkedList;

import java.awt.*;
import java.util.Scanner;

public class Inserting_Node_in_Linked_List{

    public static ListNode Insert_Beginneing(ListNode l){

        ListNode head = l;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the data of Node for Front Insertion : ");
        int d = sc.nextInt();
        ListNode newNode = new ListNode(d);
        newNode.next = l;
        l=newNode;
        return l;
    }

    public static ListNode Insert_End(ListNode l){

        ListNode temp = l;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the data of Node for End Insertion : ");
        int d = sc.nextInt();
        ListNode newNode = new ListNode(d);

        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;

        return l;
    }
    public static void main(String[] args) {

        ListNode l = LinkedList.CreateLinkedList();
        ListNode lNew1 = Insert_Beginneing(l);
        LinkedList.Display(lNew1);
        ListNode lNew2 = Insert_End(l);
        LinkedList.Display(lNew2);

    }
}
