package DSA.LinkedList;

/**
 *
 * Concept :- Breaking & Linking the Nodes in LL.
 * Approches :-
 *       BRUTE FORCE :- Just use 2 ArraYlIST which stores all even and odd addresses and after that connect them via
 *                      again iteration over arrayList.
 *
 *                      TC - O(3N) , SC - O(N)
 *
 *
 *      OPTMIZED APPROCH :- Make the 2 fake Nodes as Odd and even and use the current pointer to join according to the
 *                          Indexes.
 *                          Fake Pointer Aprooch makes the Codes more Clean &  Readable. and covers all Edge Case of becoming Pointers null in between.
 *
 *                     TC - O(N)  , SC - O(1)
 *
 *
 *    Learning :- Use Fake Pointer Approch.. It is used in many Cases when our head is not fixed ...
 *
 *
 * **/

public class O_Segregate_Odd_Even_LinkedList {

    public static void Display(ListNode head){

        ListNode temp = head;
        while (temp!=null){
            System.out.print(temp.data+", ");
            temp=temp.next;
        }
        System.out.print("null");
        System.out.println(" ");

    }
    public static ListNode Segregate_Odd_Even(ListNode head){

        if(head==null || head.next==null)return head;

        ListNode o = new ListNode(-100);
        ListNode e = new ListNode(-100);
        ListNode tail1=o;
        ListNode tail2=e;
        ListNode curr=head;
        int index = 1;

        while (curr!=null){

            if(index%2!=0){
                tail1.next=curr;
                tail1=tail1.next;
            }

            else{
                tail2.next=curr;
                tail2=tail2.next;
            }
            curr=curr.next;
            index++;
        }
        tail2.next=null;
        tail1.next=e.next;

        return o.next;
    }
    public static void main(String[] args) {

        ListNode list = LinkedList.CreateLinkedList();

        Display(list);

        ListNode newList = Segregate_Odd_Even(list);

        Display(newList);
    }
}
