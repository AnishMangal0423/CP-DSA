package GFG.POTD;
import java.util.Scanner;
/**
 *
 * Concept :- Question of Compbiantions and Recursion
 *
 * Approches :- 1. Brute force Solution - Go via Recursion and Explore all possibilties.
 *              TC - O(2^n)
 *              SC - O(n) stack space
 *
 *
 *       Approch-2 :- Mamoization- Use dp array to store the range of Indexes
 *              TC - O(n*n) --> maximum n^2 substring can be only made.
 *              SC - O(n*n) ---> dp array size
 *
 * **/
public class D_KRemoval_Palindrome__23052024{

    public static int Removals(String s, int i, int j, int[][]dp){

        if(i>=j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        char left = s.charAt(i);
        char right = s.charAt(j);

        if(left==right) return dp[i][j] =  Removals(s, i+1, j-1, dp);
        int leftRemoval = 1 + Removals(s, i+1, j, dp);
        int rightRemoval = 1 + Removals(s, i, j-1, dp);
        return dp[i][j] = Math.min(leftRemoval, rightRemoval);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();

        int[][]dp=new int[s.length()][s.length()];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp.length; j++){
                if(i!=j)dp[i][j]=-1;
            }
        }

        System.out.println("Minimum Removals to Make String Palindrome ?: " + Removals(s, 0, s.length()-1, dp));
    }
}
