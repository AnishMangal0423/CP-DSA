package DSA.Heaps;

import DSA.Tree.Burning_Tree;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/***
 * In java by default Min heap Implement hota h.
 * Hmm ise tree ki trah samaj sakte h , complete Binary tree.
 *
 * Hamne is Class mai purri Priority Queue ko implement kiya h ..
 * we have made -
 *  Insertion fn   --->    O(nLogn) time to insert n elements in heap.
 *  Deletion fn    --->    O(nLogn) time to completley delete the n elements of heap. deletion fn mai first elemnet haat jata h and last elements
 *                         phle add ho jata h , & then firse tree rearrange(heapify) ho jata h means Heapify function takes logN time.
 *                         Heapify function phle se bne hue fn par lagta h.
 *
 * Heap Sort fn   --->    Hmm har baar elements ko delete krte jaate h and store krke rkhte jaate and then heapify.
 *                         Deletion + store element hota h ek tarike se.
 *
 *                         Tc - o(nLogn) in all 3 cases best, avg, worst.
 *
 * Build Heap fn  --->     Isme hmm kya karte h piche se shuru krte h and then leaf nodes to khud se hi min heap mai h and hmm leaf nodes se phle
 *                         wali yani n/2-1 se shuru krte h and then wha se haar node par min heap bnane ki koshish krte h tab ye total tc jab
 *                         prove bagera kroga to you will find ki it is O(n)
 *
 *                         Condition --> Phle se nodes data ki array hmare pass honi chaoye tabhi to n/2-1 se gaadi shuru hogi.
 *                                       Thoda exclusive case .
 *
 *                         TC - O(N)

 * **/

public class Priority_Queue {
    ArrayList<Integer>arr;
    Priority_Queue(){
        arr=new ArrayList<>();
    }

    void swap(ArrayList<Integer>arr, int ind1, int ind2){
        int a = arr.get(ind1);
        arr.set(ind1, arr.get(ind2));
        arr.set(ind2 , a);
    }

    void Insertion(int data){

        arr.add(data);
        int size = arr.size();
        int index = size-1;

        while (index > 0) {

            int parentIndex = ((index+1) / 2)-1;

            if (arr.get(parentIndex) > data) {
                swap(arr, parentIndex, index);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    int Deletion(){

        int size = arr.size();
        if(size ==0 ){
            System.out.println("Priority Queue is Already Empty ?; ");
            return -1;
        }

        int result = arr.get(0);

        arr.set(0, arr.get(size-1));
        arr.remove(arr.size()-1);
        size=arr.size();

        int parentIndex = 0;

        while (size > 0) {
            int leftValue = Integer.MAX_VALUE;
            int rightValue = Integer.MAX_VALUE;

            if((2 * parentIndex) + 1 < size){
                 leftValue = arr.get((2 * parentIndex) + 1);
            }

            if((2 * parentIndex) + 2 < size){
                rightValue = arr.get((2 * parentIndex) + 2);
            }

            if (arr.get(parentIndex) <= leftValue && arr.get(parentIndex) <= rightValue) return result;
            else {

                if (leftValue <= rightValue) {
                    swap(arr, parentIndex, (2 * parentIndex) + 1);
                    parentIndex = (2 * parentIndex) + 1;
                } else {
                    swap(arr, parentIndex, (2 * parentIndex) + 2);
                    parentIndex = (2 * parentIndex) + 2;
                }
            }
        }

        return result;

    }   // Heapify fn

    void BuildHeap(ArrayList<Integer>data, int i){

             int n = data.size();

              int smallest = i;
              int leftIndex = (2*i)+1;  int leftValue = Integer.MAX_VALUE;
              int rightIndex = leftIndex+1;  int rightValue = Integer.MAX_VALUE;

              if(leftIndex < n) leftValue = data.get(leftIndex);
              if(rightIndex < n)rightValue = data.get(rightIndex);

              if(data.get(smallest) > leftValue){
                      smallest = leftIndex;
                  }

              if(data.get(smallest) > rightValue){
                      smallest = rightIndex;
                  }



              if(smallest!=i) {
                  swap(data , i, smallest);
                  BuildHeap(data , smallest);
              }
    }  // Exclusive

    ArrayList<Integer> HeapSort(Priority_Queue pq){

        ArrayList<Integer>result = new ArrayList<>();

        int size = pq.arr.size();
        for(int i=0; i<size; i++){
            result.add(pq.Deletion());
        }

       return result;
    }

    public static void main(String[] args) {

         Priority_Queue pq = new Priority_Queue();
         pq.Insertion(10);
         pq.Insertion(20);
         pq.Insertion(30);
         pq.Insertion(40);
         pq.Insertion(1);
        pq.Insertion(2);
//         System.out.println(pq.arr.get(0));
        System.out.println(pq.Deletion());
        System.out.println(pq.Deletion());
        System.out.println(pq.Deletion());
        System.out.println(pq.Deletion());
        System.out.println(pq.Deletion());
        System.out.println(pq.Deletion());
        System.out.println(pq.Deletion());
        System.out.println(pq.HeapSort(pq));

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>data = new ArrayList<>();

        for(int i=0; i<n; i++)data.add(sc.nextInt());

        for(int i=(n/2)-1; i>=0; i--){
            pq.BuildHeap(data , i);
        }

        System.out.println("Builded Heap from Data Array ?: " + data);

    }
}
