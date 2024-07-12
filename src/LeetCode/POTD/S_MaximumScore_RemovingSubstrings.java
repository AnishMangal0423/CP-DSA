package LeetCode.POTD;
import java.util.Scanner;
import java.util.Stack;

/***

 Time - O(2N)  --> To Remove both Types of Patterns. (ab, ba).
 Space - O(N)  --> Stack Space , Lets suppose str = "cbgsfrwty" sab add ho jayenge.


 Intution --> First I did Not read the Question Properly and directly done dp in it.
 But it will be wrong Because , we can any substring at any index having (ba, ab)
 But in dp.. you have to be linear for making Pattern.
 Now come to actual thing or greedy, we want maximum Coins at the eod. so
 Remove the string which have maximum point .
 But here some people will say .. hey anish

 Ex-1  Let suppose x = 3, y=4 and you will try to remove ba first and there can be chances
 that you will destroy 2 ab in finding that ba and (2ab > 1ba)
 But it will not happen because
 Lets suppose str = abab --> 2ways (ab, ab) or (ba, ab) now difference between both is one
 ab, ba now if anyone will be bigger will become and add in my ans Go for that way.

 EX-2 : str = baba --> (ba, ba) or (ba, ab) same diff is of ab and ba only.

 Now I think You understood so first remove highest weighted substring using stack and then
 reove lower weighted string by traversing the stack and Get your Coins.



 ---- Good Question - Stack , Greedy, Strings.
 */
public class S_MaximumScore_RemovingSubstrings {

    // First I Thought It will be DP Question, But it is Not... ( Kyuki Hmm Khai se bhi remove kar sakte h )
    public static int MaximumScore(String s, int x, int y , int index){

        int n = s.length();
        if(index >= n-1) return 0;

        String sub = s.substring(index, index+2);

        int take, non_take =0;
        if(sub.equals("ab")==false && sub.equals("ba")==false) return MaximumScore(s, x, y, index+1);


        else if(sub.equals("ab")){

            take = x + MaximumScore(s, x, y, index+2);
        }

        else{
            take = y+ MaximumScore(s, x, y, index+2);
        }
        non_take = MaximumScore(s, x, y, index+1);

        return Math.max(take, non_take);
    }

    public static int MaximumScore_Achieved(String s, int x, int y){

        String[] GlobalMatchStrings = {"ab", "ba"};
        int[] values = {x, y};

        int index = 0;
        if(y > x) index++;
        String matchString = GlobalMatchStrings[index];
        int ans = 0;

        Stack<Character>stk = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(stk.isEmpty())stk.push(c);
            else if(c == matchString.charAt(matchString.length()-1) && stk.peek() == matchString.charAt(matchString.length()-2)){
                ans += values[index];
                stk.pop();
            }

            else{
                stk.push(c);
            }

        }

        System.out.println(ans+" ?");
        // STep-2-
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        sb.reverse(); // Reverse to maintain the original order of remaining characters

        String remainingString = sb.toString();

        // Switch to the other pattern and value
        index = (index + 1) % 2;
        matchString = GlobalMatchStrings[index];
        int value = values[index];

        // Process the remaining string for the other pattern
        stk = new Stack<>();
        for (int i = 0; i < remainingString.length(); i++) {
            char c = remainingString.charAt(i);

            if (!stk.isEmpty() && c == matchString.charAt(1) && stk.peek() == matchString.charAt(0)) {
                ans += value;
                stk.pop();
            } else {
                stk.push(c);
            }
        }

        return ans;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int x = sc.nextInt();
        int y = sc.nextInt();


        // This Problem Will Not be Solved By Dp. If You can Understand.  ---- wrong Method.
//        System.out.println("Maximum Score we Can Achieve is ?: " + MaximumScore(s, x, y, 0));


        // Stack correct Method -

        System.out.println("Maximum Score we can Acieve is ?: " + MaximumScore_Achieved(s, x, y));

    }
}
