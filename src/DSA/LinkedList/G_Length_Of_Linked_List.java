package DSA.LinkedList;

public class G_Length_Of_Linked_List {

    public static int length(ListNode list){

        ListNode temp = list;

        int len = 0;
        while (temp!=null){
            temp=temp.next;
            len++;
        }
        return len;
    }
    public static void main(String[] args) {

        ListNode list = LinkedList.CreateLinkedList();

        System.out.println("Length of LinkedList is : "+ length(list));
    }
}
