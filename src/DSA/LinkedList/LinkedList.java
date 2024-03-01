package DSA.LinkedList;


import java.awt.*;
import java.util.List;
import java.util.Scanner;

class ListNode{

    int data;
    ListNode next;

    ListNode(int d){
        this.data=d;
        next = null;
    }

}

public class LinkedList {

     public static ListNode CreateLinkedList(){

         System.out.println("Enter the Head Node Data of the LinkedList : ");
         Scanner sc = new Scanner(System.in);
         int HeadData = sc.nextInt();

         ListNode head = new ListNode(HeadData);
         ListNode temp = head;

         while(temp!=null){

             System.out.println("Enter the NodeData next to "+ temp.data +" Data Node");
             int newNodeData = sc.nextInt();

             if(newNodeData != -1) {
                 ListNode newNode = new ListNode(newNodeData);
                 temp.next = newNode;
                 temp = temp.next;
             }
             else temp = null;
         }

         return head;
     }


     public static void Display(ListNode head){

         ListNode temp = head;
         while (temp!=null){
             System.out.print(temp.data+", ");
             temp=temp.next;
         }
         System.out.print("null");
         System.out.println(" ");

     }


    public static void main(String[] args) {

           ListNode l1 = CreateLinkedList();
           Display(l1);

    }

}
