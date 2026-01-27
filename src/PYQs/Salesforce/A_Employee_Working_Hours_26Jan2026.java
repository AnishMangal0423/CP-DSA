package PYQs.Salesforce;
import java.util.*;


public class A_Employee_Working_Hours_26Jan2026 {

    public static void backtracking(String s, ArrayList<String> ans,StringBuilder sb, int index, int sum) {
        if(sb.length()==s.length() && sum==0) {
            ans.add(sb.toString());
            return;
        }
        if(index==s.length())return;
        char c = s.charAt(index);
        if(sum <0)return;
        if(c!='#'){
            sb.append(c);
            backtracking(s, ans, sb, index+1, sum);
            sb.deleteCharAt(sb.length()-1);
        }
        else {
            for (char cc = '0'; cc <= '9'; cc++) {
                sb.append(cc);
                backtracking(s, ans, sb, index + 1, sum - (cc - '0'));
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String s = sc.nextLine();
        System.out.println("Enter the n");
        int n = sc.nextInt();
        int tsum =0;
        for(char c : s.toCharArray()){
            if(c=='#')continue;
            tsum+=c-'0';
        }

        ArrayList<String>ans = new ArrayList<>();
        backtracking(s, ans, new StringBuilder(), 0, n-tsum);
        System.out.println("The exact strings can be : " + ans);
    }
}
