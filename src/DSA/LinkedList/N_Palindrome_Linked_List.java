package DSA.LinkedList;

/**
 *
 * Approches -->
 *
 *   Approch-1 ;- Use O(N) space to store and then check palindrome.
 *
 *         TC - O(2N) ,  SC - O(N)
 *
 *   Approch-2 ;- Use The concept of hare and Tortoise and Reverse the LinkedList in Between After the middle
 *                and then Do the comparisiona and again make same state.
 *
 *               STEP-1 :- Find the Middle position in the linked List.
 *               Step-2 ;- Now , head will be first and middle.next will be second ll. but they are still connected , no worries.
 *               Step-3 ;- Comparision of nodes values.
 *               Step-4 ;- Again Correct the state of LinkedList by revresing.
 *               Step-5 ;- Returning ans.
 *
 *
 *      TC - O(4N) , SC - O(1).    --> Hare And Tortoise Solution.
 *
 *
 * **/
public class N_Palindrome_Linked_List{

    public static ListNode FindMiddle(ListNode head){

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }

    public static ListNode ReverseLL(ListNode head){

        if(head==null)return null;
        ListNode prev = null;
        ListNode curr = head;
        ListNode future = curr.next;

        while (curr!=null){

            curr.next=prev;
            prev=curr;
            curr=future;
            if(future!=null) future=future.next;

        }

        return prev;
    }

    public static boolean CheckPalindrome(ListNode first, ListNode second){

        ListNode temp1=first;
        ListNode temp2=second;

        while (temp1!=null && temp2!=null){
            if(temp1.data==temp2.data){
                temp1=temp1.next;
                temp2=temp2.next;
            }

            else{
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome(ListNode head){

        if(head==null)return true;

        ListNode middle = FindMiddle(head);

        ListNode second = ReverseLL(middle.next);

        ListNode first = head;

        boolean ans = CheckPalindrome(first, second);

        ReverseLL(second);

        return ans;
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

        System.out.println("Is Given LinkedList Palindrome ?: " + isPalindrome(list));

        Display(list);

    }
}
