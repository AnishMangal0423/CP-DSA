package DSA.LinkedList;

import java.util.Scanner;

class DoublyListNode{

    int data;
    DoublyListNode prev;
    DoublyListNode next;

    DoublyListNode(int data){
        this.data = data;
        prev = null;
        next = null;
    }
}

public class DoublyLinkedList{

    public static DoublyListNode CreateDLL(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Head Data of Doubly Linked List : ");
        int headData = sc.nextInt();
        DoublyListNode head = new DoublyListNode(headData);
        DoublyListNode temp = head;

        while (temp!=null) {

            System.out.println("Enter the Data of Node next to "+ temp.data +" Node");
            int data = sc.nextInt();

            if(data!=-1) {
                DoublyListNode newNode = new DoublyListNode(data);
                 temp.next = newNode;
                 newNode.prev = temp;
                 temp = temp.next;
            }

            else temp = null;
        }
        return head;
    }

    public static void DisplayDLL(DoublyListNode list){

        DoublyListNode temp = list;
        while (temp!=null){
            System.out.print(temp.data +", ");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {

        DoublyListNode DLLlist = CreateDLL();
        DisplayDLL(DLLlist);

    }
}
