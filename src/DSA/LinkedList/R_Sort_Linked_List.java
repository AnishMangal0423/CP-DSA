package DSA.LinkedList;


/***
 *Brute Force --> Just store the values in array sort them and replace the data in ll.
 *
 * Used the Merge Sort to sort the ll.
 *
 * TC - O( log(N) * (N + N/2(for finding the middle) )  ~ O(nlogN)
 * SC - O( log(N) as the auxilary stack space)  ~ O(1) as concrete space
 *
 *
 * **/
public class R_Sort_Linked_List {

    public static void Display(ListNode head){

        ListNode temp = head;
        while (temp!=null){
            System.out.print(temp.data+", ");
            temp=temp.next;
        }
        System.out.print("null");
        System.out.println(" ");

    }
    public static ListNode FindMiddle(ListNode head){

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }

    public static ListNode Merge2LL(ListNode head1 , ListNode head2){

        ListNode dummy = new ListNode(-10000);
        ListNode ansTail = dummy;
        ListNode temp1= head1;
        ListNode temp2=head2;

        while (temp1!=null && temp2!=null){

            int d1 = temp1.data;
            int d2 = temp2.data;

            if(d1 <= d2){
                ansTail.next=temp1;
                temp1=temp1.next;
            }

            else{
                ansTail.next=temp2;
                temp2=temp2.next;
            }

            ansTail=ansTail.next;
        }

        if(temp1!=null) ansTail.next=temp1;
        if(temp2!=null)ansTail.next=temp2;

        return dummy.next;

    }
    public static ListNode MergeSort(ListNode head){

        if(head==null || head.next==null)return head;

        ListNode middle = FindMiddle(head);

        ListNode first = head;
        ListNode second = middle.next;
        middle.next=null;

        ListNode left = MergeSort(first);
        ListNode right = MergeSort(second);

        return Merge2LL(left , right);

    }
    public static void main(String[] args) {

       ListNode list = LinkedList.CreateLinkedList();

       Display(list);
       ListNode newList = MergeSort(list);
       Display(newList);


    }
}
