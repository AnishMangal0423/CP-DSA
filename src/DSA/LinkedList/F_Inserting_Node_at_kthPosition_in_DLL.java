package DSA.LinkedList;

import java.util.Scanner;

public class F_Inserting_Node_at_kthPosition_in_DLL {

    public static void DisplayDLL(DoublyListNode list){

        DoublyListNode temp = list;
        while (temp!=null){
            System.out.print(temp.data +", ");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static DoublyListNode Insert(DoublyListNode list, int k){

        System.out.println("Enter the Data of the New Node");
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        DoublyListNode newNode = new DoublyListNode(data);
        DoublyListNode temp = list;
        DoublyListNode prev = null;

        while (k-->0){
            prev=temp;
            temp=temp.next;
        }

        newNode.next=temp;
        temp.prev=newNode;

        if(prev==null)return newNode;
        prev.next=newNode;
        newNode.prev=prev;

        return list;


    }
    public static void main(String[] args) {

        DoublyListNode list = DoublyLinkedList.CreateDLL();
        System.out.println("Enter the position where we want to Insert the Node..");

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        DoublyListNode NewList = Insert(list, k);
        DisplayDLL(NewList);

    }
}
