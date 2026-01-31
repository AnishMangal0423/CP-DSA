package POTD.GFG;
import java.util.*;

public class K_Implement_k_Queues_in_a_Single_Array_31Jan2026 {

        int[] arr;     // Stores actual queue values
        int[] next;    // Acts like "next pointer" for both queues & free list
        int[] front;   // Front index of each queue
        int[] rear;    // Rear index of each queue
        int freeSpot;  // Start of free list

        int n, k;

        public K_Implement_k_Queues_in_a_Single_Array_31Jan2026(int n, int k) {
            this.n = n;
            this.k = k;

            arr = new int[n];
            next = new int[n];
            front = new int[k];
            rear = new int[k];

            // Initially all queues are empty
            Arrays.fill(front, -1);
            Arrays.fill(rear, -1);

            // Build free list linking all indices
            for (int i = 0; i < n - 1; i++) {
                next[i] = i + 1;
            }
            next[n - 1] = -1;

            freeSpot = 0;  // First free index available
        }

        // Insert element x into queue qi
        public void enqueue(int x, int qi) {
            if (freeSpot == -1) {
                System.out.println("Queue Overflow");
                return;
            }

            int index = freeSpot;       // Get free index
            freeSpot = next[index];     // Update free list

            if (front[qi] == -1) {
                front[qi] = index;      // First element in this queue
            } else {
                next[rear[qi]] = index; // Link new node at end
            }

            next[index] = -1;           // New rear has no next
            rear[qi] = index;           // Update rear pointer
            arr[index] = x;             // Store value
        }

        // Remove element from queue qi
        public int dequeue(int qi) {
            if (front[qi] == -1) {
                return -1; // Queue empty
            }

            int index = front[qi];       // Get front index
            front[qi] = next[index];     // Move front forward

            // Add this index back to free list
            next[index] = freeSpot;
            freeSpot = index;

            return arr[index];
        }

        public boolean isEmpty(int qi) {
            return front[qi] == -1;
        }

        public boolean isFull() {
            return freeSpot == -1;
        }

    public static void main(String[] args) {

        /*
         INTUITION TEST:
         n = 4, k = 2
         Both queues share same memory dynamically
        */

        K_Implement_k_Queues_in_a_Single_Array_31Jan2026 q = new K_Implement_k_Queues_in_a_Single_Array_31Jan2026(4, 2);

        q.enqueue(5, 0); // Queue 0: 5
        q.enqueue(3, 0); // Queue 0: 5, 3
        q.enqueue(1, 1); // Queue 1: 1

        System.out.println(q.dequeue(0)); // 5
        q.enqueue(4, 1); // Queue 1: 1, 4

        System.out.println(q.dequeue(1)); // 1
        System.out.println(q.dequeue(1)); // 4

        System.out.println(q.isEmpty(0)); // false
        System.out.println(q.isFull());   // false
    }
}



