package DSA.LinkedList;

public class U_Add_2_Numbers_in_LL_1{

    public static void Display(ListNode head){

        ListNode temp = head;
        while (temp!=null){
            System.out.print(temp.data+", ");
            temp=temp.next;
        }
        System.out.print("null");
        System.out.println(" ");

    }
    public static ListNode AddTwoNumbers(ListNode l1, ListNode l2){

        int carry = 0;
        ListNode dummy = new ListNode(-1000);
        ListNode tail = dummy;
        ListNode temp1 = l1;
        ListNode temp2 = l2;



        while (temp1!=null || temp2!=null || carry > 0){

            int val = 0;

            if(temp1!=null){
                val+=temp1.data;
                temp1=temp1.next;
            }

            if(temp2!=null){
                val+= temp2.data;
                temp2=temp2.next;
            }

            if(carry > 0){
                val+=carry;
            }

            carry = (val / 10);
            int newval= (val % 10);
            ListNode newNode = new ListNode(newval);
            tail.next=newNode;
            tail=tail.next;
        }

        return dummy.next;
    }
    public static void main(String[] args) {

        System.out.println("Enter the First List :: ");
        ListNode list1 = LinkedList.CreateLinkedList();
        Display(list1);
        System.out.println("Enter the second List :: ");
        ListNode list2 = LinkedList.CreateLinkedList();
        Display(list2);
        ListNode sumList = AddTwoNumbers(list1, list2);
        Display(sumList);
    }
}
