package DSA.LinkedList;

import java.util.Scanner;

/***
 *
 * Concept :- Finding the Starting Node of the loop in LL.
 * Approch- 1. Approch of hashmap and storage.
 *             TC - O(N) , SC - O(N).
 *
 * Approch- 2. Approch of Tortoise and Hare aka (Slow and fast Pointer Approch).
 *
 *             Intution - Lets consider -
 *               Distances A = Distance from head till loop start.
 *               Distance  B = Distance from Loop start till Collision point.
 *               Distance  C = Distance from Loop start till Loop end ( Loop length ).
 *
 *           Now ,
 *           for fast ( A + xC + B ) = (2A + 2yC + 2B) for slow
 *           A + B = (x - 2y ) C
 *           Now as we can colnculde that A + B distance will form loop total by some factor.
 *           now menas distance between collision point till loop start is A.
 *           means we will move A+B everytime according to count of loops and then Will move B distance and then finally A distance.
 *
 *         So now moved slow to head and fast as same and now move 1-1 both till not match.
 *
 *
 *
 *         TC - ~ O(N)
 *         SC - O(1)
 *
 * **/
public class L_Find_Starting_Point_of_Loop_in_LL{

    // Just the Helper fn to Make the Looped LL.
    public static ListNode FindNode(ListNode head, int pos){

        int count = 1;
        while (count!=pos){
            count++;
            head=head.next;
        }
        return head;
    }

    // Just the Helper fn to Make the Looped LL.
    public static void  ConnectTail(ListNode head, int pos){

        ListNode tail = head;
        ListNode temp = head;
        while (temp.next!=null){
            temp=temp.next;
            tail = temp;
        }

        ListNode LoopingNode = FindNode(head, pos);
        tail.next = LoopingNode;

    }

    // Important Function-
    public static ListNode StartingNode(ListNode head){

        // Step-1 :- Collision of Slow and fast to find collision Node-
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null){

            slow=slow.next;      // O(N approx)
            fast=fast.next.next;

            // Step-2 :- Now shift the slow to head and move fast and slow by only 1 distance , till they not match.
            if(slow==fast){
                slow=head;

                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;    // O(Linear ~ N)
                }

                return slow;
            }
        }

        // Step-3 :- When there id No Loop in LinkedList-
        return null;
    }
    public static void main(String[] args) {

        ListNode list = LinkedList.CreateLinkedList();

        System.out.println("Enter the pos you want to connect : ");
        Scanner sc = new Scanner(System.in);
        int pos = sc.nextInt();
        if(pos!=-1) ConnectTail(list , pos);

        System.out.println("Starting Node of Loop is :  "+ StartingNode(list).data);
    }
}
