package DSA.LinkedList;

/***
 *
 * TC - O(N)
 * SC - O(1)
 * */
public class I_Reverse_Linked_List_Interatively{

    public static ListNode ReverseLL(ListNode head){

        ListNode prev = null;
        ListNode curr = head;

        while (curr!=null){

            curr=curr.next;
            head.next=prev;
            prev=head;
            head=curr;

        }
        return prev;
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
        Display(list);
        ListNode rlist = ReverseLL(list);
        Display(rlist);

    }
}
