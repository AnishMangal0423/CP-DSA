package DSA.LinkedList;

/**
 *
 *Concept :- Sorting the Linked List containing the elements as 0, 1, 2.
 * Approch :- Just count and change the data of Original LinkedList.
 *
 * Approch-2 :-   Mainatin the 3 linkedLists and and connect them accordingly.
 *           Edges Cases --> 0 ho , 1  ho , 2 na ho.
 *                           0 ho , 1 ho , 2 ho
 *                           0 ho  1 na ho , 2 ho.
 *                           0 ho, 1 na ho, 2 na ho..
 *                           ... and all cases and i have Make the function MakeLLEdgeCases function to handle all cases.
 *
 *
 *
 *                  TC - O(N)
 *                  SC - O(1)
 * **/
public class S_Sort_012_LL{
    public static void Display(ListNode head){

        ListNode temp = head;
        while (temp!=null){
            System.out.print(temp.data+", ");
            temp=temp.next;
        }
        System.out.print("null");
        System.out.println(" ");

    }
    public static ListNode MakeLLEdgeCases(ListNode dummy0, ListNode tail0, ListNode dummy1, ListNode tail1, ListNode dummy2, ListNode tail2){

        tail0.next = (dummy1.next != null) ? dummy1.next : dummy2.next;

        tail1.next = dummy2.next;

        tail2.next = null;

        return dummy0.next;
    }

    public static ListNode Sort012(ListNode head){

        if(head==null || head.next==null)return head;

        ListNode dummy0=new ListNode(-100), tail0= dummy0;
        ListNode dummy1=new ListNode(-100) , tail1= dummy1;
        ListNode dummy2=new ListNode(-100) , tail2 = dummy2;
        ListNode temp = head;

        while (temp!=null){

            int val = temp.data;

            if(val==0){
                tail0.next=temp;
                tail0=tail0.next;
            }

            else if(val==1){
                tail1.next=temp;
                tail1=tail1.next;
            }

            else{
                tail2.next=temp;
                tail2=tail2.next;
            }

            temp=temp.next;
        }

        return MakeLLEdgeCases(dummy0 , tail0 , dummy1 , tail1,  dummy2, tail2);
    }
    public static void main(String[] args) {

         ListNode list = LinkedList.CreateLinkedList();
         Display(list);
         ListNode newList = Sort012(list);
         Display(newList);
    }
}
