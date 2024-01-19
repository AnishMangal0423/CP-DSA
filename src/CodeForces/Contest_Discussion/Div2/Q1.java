package CodeForces.Contest_Discussion.Div2;

//import java.util.Scanner;
//
//public class Q1 {
//    public static void main(String[] args) {
//
//        Scanner sc=new Scanner(System.in);
//
//        int tc=sc.nextInt();
//
//        while (tc-- >0){
//
//          int n=sc.nextInt();
//
//        }
//    }
//}


import java.util.Scanner;

public class Q1 {
    public  static final int MOD = 1000000005;
    public static Scanner sc = new Scanner(System.in);
    private static void solve() {
        int n = sc.nextInt();

        String a = sc.next();
        String b = sc.next();
        String c = sc.next();

        int sum=0;
         for(int k=0; k<20000; k++) sum++;
        int j = 0;

        for(int i = 0; i < n; i++)
        {
            if(c.charAt(j) == a.charAt(i) || c.charAt(j) == b.charAt(i))
            {
                j++;
            }
        }

        if(j == n) System.out.println("NO");
        else System.out.println("YES");
    }
    public static void main(String[] args) {
        int T = 1;

        T = sc.nextInt();

        while(T --> 0) solve();
}
}