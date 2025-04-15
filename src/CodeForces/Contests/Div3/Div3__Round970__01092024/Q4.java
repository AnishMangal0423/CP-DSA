package CodeForces.Contests.Div3.Div3__Round970__01092024;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class Q4 {
//    public static void main(String[] args) {
//
//        Scanner sc  = new Scanner(System.in);
//        int tc = sc.nextInt();
//
//        while (tc-->0){
//
//            int n = sc.nextInt();
//            int[]arr = new int[n];
//            for(int i=0; i<n; i++)arr[i]=sc.nextInt()-1;
//
//        String s = sc.next();
//
//        int[]ans = new int[n];
//        int[]vaal = new int[n];
//
//            Arrays.fill(vaal , -1);
//
//
//            for(int i=0; i<n; i++){
//
//                HashMap<Integer , Integer>m = new HashMap<>();
//               int ind =i;
//
//               int scr=0;
//               while (m.containsKey(ind)==false){
//
//                   if(s.charAt(ind)=='1')scr++;
//
//                   m.put(ind , 0);
//                   ind=arr[ind];
//               }
//
//               for(int kii : m.keySet()){
//                   ans[kii]=scr;
//               }
//
//
//
//            }
//            System.out.println(Arrays.toString(ans));
//        }
//        }
//}
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {

            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt() - 1;

            sc.nextLine();
            String s = sc.nextLine();

            int[] ans = new int[n];
            int[] val = new int[n];

            Arrays.fill(val, -1);

            for (int i = 0; i < n; i++) {

                if (val[i] != -1) continue;

                HashMap<Integer, Integer> m = new HashMap<>();
                int ind = i;
                int scr = 0;
                while (!m.containsKey(ind)) {

                    if (s.charAt(ind) == '0') scr++;

                    m.put(ind, 0);
                    ind = arr[ind];
                }

                for (int kii : m.keySet()) {
                    ans[kii] = scr;
                    val[kii] = scr;
                }
            }

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + (i == n - 1 ? "\n" : " "));
            }
        }
    }
}
