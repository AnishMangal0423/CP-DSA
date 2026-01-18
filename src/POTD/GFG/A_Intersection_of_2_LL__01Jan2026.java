package POTD.GFG;
import  java.util.*;
public class A_Intersection_of_2_LL__01Jan2026 {

        // ================= NODE CLASS =================
        static class Node {
            int data;
            Node next;

            Node(int d) {
                data = d;
                next = null;
            }
        }

        // ================= SOLUTION CLASS =================
        static class Solution {

            /*
             BRUTE FORCE USING HASHMAP
             Idea:
             - Store all nodes of list1 in HashMap
             - Traverse list2 and check first node present in map
             */
            public Node BruteForce(Node head1, Node head2) {

                HashMap<Node, Integer> map = new HashMap<>();

                Node temp = head1;
                while (temp != null) {
                    map.put(temp, 1);
                    temp = temp.next;
                }

                Node temp2 = head2;
                while (temp2 != null) {
                    if (map.containsKey(temp2)) {
                        return temp2;
                    }
                    temp2 = temp2.next;
                }

                return null;
            }

            /*
             Utility function to calculate length of linked list
             */
            public int length(Node head) {
                int count = 0;
                while (head != null) {
                    count++;
                    head = head.next;
                }
                return count;
            }

            /*
             BETTER APPROACH (Length Difference)
             Idea:
             - Find length of both lists
             - Move pointer of longer list by difference
             - Then move both pointers together
             */
            public Node BetterApproach(Node head1, Node head2) {

                int l1 = length(head1);
                int l2 = length(head2);

                // Ensure head2 is always longer
                if (l1 > l2) return BetterApproach(head2, head1);

                Node p1 = head1;
                Node p2 = head2;

                int diff = l2 - l1;

                while (diff > 0) {
                    p2 = p2.next;
                    diff--;
                }

                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }

                return p1;
            }

            /*
             OPTIMAL APPROACH (Two Pointer Switch)
             Idea:
             - Traverse both lists
             - When one pointer reaches null, redirect it to other list
             - They meet at intersection point

             Why it works -
             Because both pointers moved same distance and it is given that they will meet
             at some point of time , and also from above approch you can see that we are moving
             the long list to difference so , when you will feel the dry of this it is also a way
             to do the problem.
             */
            public Node OptimalSoln(Node head1, Node head2) {

                Node p1 = head1;
                Node p2 = head2;

                while (p1 != p2) {

                    p1 = (p1 == null) ? head2 : p1.next;
                    p2 = (p2 == null) ? head1 : p2.next;
                }

                return p1;
            }

            public Node intersectPoint(Node head1, Node head2) {

                // return BruteForce(head1, head2);
                // Time: O(N + M), Space: O(N)

                // return BetterApproach(head1, head2);
                // Time: O(N + M), Space: O(1)

                return OptimalSoln(head1, head2);
                // Time: O(N + M), Space: O(1)
            }
        }

        // ================= MAIN FUNCTION =================
        public static void main(String[] args) {

        /*
         Creating Y-shaped linked list:

         head1: 10 → 15 → 30
                         ↑
         head2: 3 → 6 → 9
         */

            Node common = new Node(15);
            common.next = new Node(30);

            Node head1 = new Node(10);
            head1.next = common;

            Node head2 = new Node(3);
            head2.next = new Node(6);
            head2.next.next = new Node(9);
            head2.next.next.next = common;

            Solution sol = new Solution();
            Node ans = sol.intersectPoint(head1, head2);

            if (ans != null) {
                System.out.println("Intersection Point: " + ans.data);
            } else {
                System.out.println("No Intersection");
            }
        }
    }

