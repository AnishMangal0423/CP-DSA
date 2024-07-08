package LeetCode.POTD;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P__WnnerCircular_Game__08072024 {

    public static int winner(int n , int k){

        Queue<Integer>queue = new LinkedList<>();
        for(int i=1; i<=n; i++)queue.add(i);

        while (queue.size()!=1){

            for(int i=0; i<k-1; i++){
                queue.add(queue.poll());
            }
            queue.poll();
        }

        return queue.poll();
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Friends who wants to Play Game ?: ");
        int n = sc.nextInt();
        System.out.println("Enter the Number of Steps ?: ");
        int k = sc.nextInt();

        System.out.println("Winner of Game is ?: " + winner(n, k));
    }
}
