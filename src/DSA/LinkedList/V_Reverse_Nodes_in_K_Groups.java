package DSA.LinkedList;


import java.util.Scanner;

public class V_Reverse_Nodes_in_K_Groups {

    public static ListNode ReverseLL(ListNode head){

        ListNode prev = null;
        ListNode curr = head;

        while (curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }

        return prev;
    }
    public static ListNode ReverseKgroups(ListNode head, int k){

        ListNode dummy = new ListNode(-100);
        ListNode tail = dummy;
        ListNode temp = head;


        int count = 0;
        ListNode tempHead = head;
        while (temp!=null){

            count++;
            if(count==k){
                tempHead=temp.next;
                temp.next=null;
                tail.next=ReverseLL(head);
                tail=head;
//                System.out.println("tt "+tail.data);
                head=tempHead;
                count=0;
                temp = tempHead;
            }

            else temp=temp.next;
        }

        if(count >0){
            tail.next=head;
        }

        return dummy.next;
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
        System.out.println("Enter the Size of Groups : ");
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        Display(list);
        ListNode newList = ReverseKgroups(list, k);
        Display(newList);

    }
}
