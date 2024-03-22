package DSA.LinkedList;

import java.util.Scanner;

/**
 *
 * Concept :-  Deleting the Node at ith Index.
 *
 *             TC - O(N)
 *             SC - O(1)
 * **/
public class D_Deleting_Kth_Nodes_in_LinkedList {
    public static ListNode DeleteNode(ListNode list, int k){

        ListNode prev = null;
        ListNode curr = list;

        for(int i=0; i<k-1; i++){
            prev = curr;
            curr=curr.next;
        }
        if(prev==null) list = curr.next;
        else prev.next = curr.next;

     return list;
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

        ListNode list = LinkedList.CreateLinkedList();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Index of Node to be Deleted : ");
        int k = sc.nextInt();
        Display(list);

        ListNode newList = DeleteNode(list, k);

        Display(newList);

    }
}
