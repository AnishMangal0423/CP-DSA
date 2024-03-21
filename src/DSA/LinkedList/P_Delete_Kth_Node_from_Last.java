package DSA.LinkedList;
import java.util.Scanner;

/**
 *
 * Concept :- We have to delete the kth Node from the end in LinkedList.
 * Approch :-
 *      Approch-1 :- Brute force Approch.
 *              Phle length of the LinkedList nikal lenge and then from begineeing se n-k distance chal lenge.
 *
 *              1. TC - O(n + (n-k))
 *              2. SC - O(1)
 *              3. 2 pass solution h , 2 baar alag alag chalna pad rha h.
 *              4. Isme follow up bnta h , ki 1pass mai krke dihaoo.
 *
 *
 *       Approch-2 :- Tortoise and hare solution (slow/fast pointer)
 *            fast ko phle hi k distance chalwa do and then dono ko 1 -1 distance se aage badaoo.
 *
 *            1. TC - O(N + (N-K))
 *            2. SC - O(1)
 *            3. One pass solution.
 *            4. Edge Case --> Jab head node delete hogi , jab list null hogi.
 *
 *
 *   Learning :- Koi jab bhi one pass solution mannge in LL, think on Fast/slow pointer approch.
 * **/
public class P_Delete_Kth_Node_from_Last {
    public static void Display(ListNode head){

        ListNode temp = head;
        while (temp!=null){
            System.out.print(temp.data+", ");
            temp=temp.next;
        }
        System.out.print("null");
        System.out.println(" ");

    }
    public static ListNode Delete(ListNode head, int pos){

        // Step-1 :- Maintain the fast and slow pointer at Correct Position.

        ListNode dummy = new ListNode(-100000);
        dummy.next=head;
        ListNode slow = head;
        ListNode fast=head;
        ListNode prev = dummy;

        for(int i=0; i<pos; i++)fast=fast.next;

        // Step-2 ;- Dono ko aab 1-1 ddistnace aage badaa te rho

        while (fast!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next;

        }

        // Step-3:- Delete krdo slow pointer ko ll se.
       prev.next=slow.next;

        return dummy.next;
    }
    public static void main(String[] args) {

        ListNode list = LinkedList.CreateLinkedList();

        System.out.println("Enter the position which you want to delete from Last : ");

        Scanner sc = new Scanner(System.in);
        int pos = sc.nextInt();

        Display(list);
        ListNode newList = Delete(list, pos);
        Display(newList);
    }
}
