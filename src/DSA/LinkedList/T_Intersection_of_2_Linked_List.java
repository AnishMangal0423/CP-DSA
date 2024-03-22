package DSA.LinkedList;

/**
 *
 * Approch1 :- Use the HashMap
 *          TC - O(N1 + N2) , SC - O(N1 OR N2)
 *
 * APPROCH-2 :- Hame ek chizz dikhai de rhi h ki , dono ll jab bhi milegi fir last tak continue kregi, to jo badi linked
 *             list oske pointer ko otne hi aage bada do ki dono ki ll length same ho jaye and then comparision shuru krdo.
 *             agar khai bhi match krega , ans mil gya , nhi to last mai null to h hi.
 *
 *             TC - O(3N) , SC - O(1)

 * **/
public class T_Intersection_of_2_Linked_List {

    public static int Length(ListNode head){

        ListNode temp = head;
        int l=0;
        while (temp!=null){
            l++;
            temp=temp.next;
        }

        return l;
    }



    public static ListNode CommonNode(ListNode head1, ListNode head2){

        if(head1==head2)return head1;
        int l1 = Length(head1);
        int l2 = Length(head2);
        ListNode temp1= head1;
        ListNode temp2 = head2;

        // Hmm hamesh l1 ko chota maan ke hi chal rhe h.
        if(l1 > l2)return CommonNode(head2 , head1);
        int rem = l2-l1;

        while (rem-->0) temp2= temp2.next;

        // Check for similar nodes -

        while (temp2!=null && temp1!=null){
            if(temp2==temp1)return temp2;
            temp2=temp2.next;
            temp1=temp1.next;
        }

        return null;
    }
    public static void main(String[] args) {

        System.out.println("Enter the 1st part of LL ");
        ListNode list1 = LinkedList.CreateLinkedList();
        System.out.println("Enter the Second part of LL ");
        ListNode list2 = LinkedList.CreateLinkedList();
        System.out.println("Enter the Third common part of LL ");
        ListNode list3 = LinkedList.CreateLinkedList();
        list1.next=list3;
        list2.next=list3;


        System.out.println("Common Node of Both LinkedList is ?: " + CommonNode(list1, list2).data);
    }
}
