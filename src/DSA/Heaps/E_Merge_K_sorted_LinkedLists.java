package DSA.Heaps;
import DSA.LinkedList.LinkedList;
import DSA.LinkedList.ListNode;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * Concepts :-  LinkedList + Arrays,toStoreHandle + PriorityQueue.
 *
 * Learnings :- 1. Making the Array of LinkedLists.
 *              2. Handling the Classes in Different Packages.
 *              3. Simple LL evaluation.
 *
 *   Approches :- 1. Brute Force --> Merge 2 LL, then other 2LL, Then other 2LL and so on..
 *                  TC - O(N.k.K) because (N.k + N.(k-1) + N.(K-2) + N.(K-3)+....) k times.
 *                  SC - O(1)
 *
 *                 2. Optimized --> Priority Queue Approch --> Isme hmm whai same first starting elemnt daal do pair wise node
 *                                                             Ka and then jo sabse chota hoga wo oper aa jayega and then ose dummy
 *                                                             List mai add krdo aur sabko aage bda do and get the ans.
 *
 *                   TC - O(N.K.log(K))
 *                   SC - O(K)  --> Priority queue ki storage.
 *
 *
 * **/
class LLPair{
    int val;
    ListNode node;

    LLPair(int v, ListNode node){
        val=v;
        this.node = node;
    }
}
public class E_Merge_K_sorted_LinkedLists{

    public static void Display(ListNode head){

        ListNode temp = head;
        while (temp!=null){
            System.out.print(temp.data+", ");
            temp=temp.next;
        }
        System.out.print("null");
        System.out.println(" ");

    }

    public static ListNode MergeAllLL(ListNode[]arr){

        int n = arr.length;
        ListNode dummy = new ListNode(-1000);
        ListNode tail = dummy;
        PriorityQueue<LLPair>pq=new PriorityQueue<>((a, b)->
            a.val-b.val
        );
        for(int i=0; i<n; i++) if(arr[i]!=null) pq.add(new LLPair(arr[i].data , arr[i]));

        while (!pq.isEmpty()){

            LLPair front = pq.poll();
            int vaal = front.val;
            ListNode node = front.node;

            tail.next =  node;
            node=node.next;
            tail=tail.next;

            if(node!=null) pq.add(new LLPair(node.data , node));
        }

     return dummy.next;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode[]arr = new ListNode[n];

        for(int i=0; i<n; i++){
            ListNode head = LinkedList.CreateLinkedList();
            arr[i]=head;
        }

        Display(MergeAllLL(arr));

    }
}
