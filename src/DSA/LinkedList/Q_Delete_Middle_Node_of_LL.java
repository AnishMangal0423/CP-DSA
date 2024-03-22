package DSA.LinkedList;

public class Q_Delete_Middle_Node_of_LL {
    public static void Display(ListNode head){

        ListNode temp = head;
        while (temp!=null){
            System.out.print(temp.data+", ");
            temp=temp.next;
        }
        System.out.print("null");
        System.out.println(" ");

    }

    public static ListNode deleteMiddle(ListNode head){

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        if(fast==null || fast.next==null)return null;

        while (fast != null && fast.next != null) {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        prev.next=slow.next;

        return head;
    }
    public static void main(String[] args) {

        ListNode list = LinkedList.CreateLinkedList();
        Display(list);
        ListNode newList = deleteMiddle(list);
        Display(newList);
    }
}
