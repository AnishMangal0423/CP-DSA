package DSA.LinkedList;

public class H_Middle_Node_of_Linked_List{

    public static ListNode FindMiddleNode(ListNode list){

        ListNode slow = list;
        ListNode fast = list;

        while (fast!=null && fast.next!=null){

            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
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

        Display(FindMiddleNode(list));


    }
}
