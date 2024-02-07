package CodeForces.Contests.Div3.Div_3__Round921;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Q3 {
//    public static void main(String[] args) {
//
//        Scanner sc=new Scanner(System.in);
//
//        int tc=sc.nextInt();
//
//        while (tc-->0){
//
//            int n=sc.nextInt();
//            long[]arr=new long[n];
//            long f=sc.nextLong();
//            long a=sc.nextLong();
//            long b=sc.nextLong();
//
//
//
//            for (int i=0; i<n; i++)arr[i]=sc.nextLong();
//
//            Arrays.sort(arr);
//
//            long mom=0;
//            boolean flag=false;
//           for(int i=0; i<n; i++){
//
//               if((arr[i]-mom)*a  <= b){
//                   f=f-(arr[i]-mom)*a;
//                   mom=arr[i];
//
//               }
//               else {
//
//                   f=f-b;
//                   mom=arr[i];
//               }
////               System.out.println("f: "+f);
//               if(f <= 0){
//                   System.out.println("NO");
//                   flag=true;
//                   break;
//               }
//
//           }
//
//           if(flag==true) System.out.println("YES");
//
//
//        }
//    }
//}
import java.util.Arrays;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc-- > 0) {

            int n = sc.nextInt();
            long[] arr = new long[n];
            long f = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();

            for (int i = 0; i < n; i++) arr[i] = sc.nextLong();

            Arrays.sort(arr);

            long mom = 0;
            boolean flag = false;

            for (int i = 0; i < n; i++) {
                if ((arr[i] - mom) * a <= b) {
                    f = f - (arr[i] - mom) * a;
                    mom = arr[i];
                } else {
                    f = f - b;
                    mom = arr[i];
                }

                if (f <= 0) {
                    System.out.println("NO");
                    flag = true;
                    break;
                }
            }

            if (!flag) System.out.println("YES");
        }
    }
}
