package PatternsDSA.SlidingWindow.Practice_Problems;
import java.util.Scanner;

/**
 * Notes - This is the problem that Anish in starting was looking like a dp problem, but please think off it is
 *         very easy problem like of fixed window size of length k.
 *
 * Time - O(2k) ~= O(k)
 * Space - O(1)
 *
 * yeah we can say that it somehow belongs to pattern 1
 * **/
public class A_Maximum_Points_Obtained_from_Cards__LeetCode_1423 {

    public static int maxScore(int[]cardPoints, int k){

        int n = cardPoints.length;
        int maxsum = 0;
        int leftsum = 0;
        int rightsum = 0;

        for(int i=0; i<k; i++)leftsum+=cardPoints[i];
        maxsum = Math.max(maxsum, leftsum);

        int rightindex = n-1;
        for(int i=k-1; i>=0; i--){
            leftsum -= cardPoints[i];
            rightsum += cardPoints[rightindex];
            rightindex--;
            maxsum = Math.max(maxsum, leftsum+rightsum);
        }

        return maxsum;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of cardpoints array : ");
        int n = sc.nextInt();
        System.out.println("Enter the cardpoints array : ");
        int[]cardPoints = new int[n];
        for(int i=0; i<n; i++)cardPoints[i]=sc.nextInt();
        System.out.println("Enter the Number of cards Boy can pick : ");
        int k = sc.nextInt();
        System.out.println("The maximum sum that can be picked is : " + maxScore(cardPoints,k));
    }
}
