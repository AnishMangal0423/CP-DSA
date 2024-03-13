package DSA.LinkedList;

public class J_Reverse_Linked_List_Recursivly{

    public static void Display(ListNode head){

        ListNode temp = head;
        while (temp!=null){
            System.out.print(temp.data+", ");
            temp=temp.next;
        }
        System.out.print("null");
        System.out.println(" ");

    }

    public static ListNode Recursive(ListNode head){

        if(head.next==null){
            ListNode ans = head;
            return head;
        }

        ListNode newNode = Recursive(head.next);
        newNode.next=head;
        return head;
    }
    public static void main(String[] args) {

        ListNode list = LinkedList.CreateLinkedList();
        Display(list);
        ListNode newList = Recursive(list);
        Display(newList);

    }
}
