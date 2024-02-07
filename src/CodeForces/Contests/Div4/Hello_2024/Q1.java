package CodeForces.Contests.Div4.Hello_2024;

//import java.util.Scanner;
//
//public class Q1 {
//
//    public static void main(String[] args) {
//
//        Scanner sc=new Scanner(System.in);
//
//        int tc=sc.nextInt();
//        sc.nextInt();
//
//        while(tc-- > 0){
//
//            long a=sc.nextInt();
//            long b=sc.nextInt();
//            long c=a+b;
//            System.out.println(c);
//            if(c%2==0) System.out.println("Bob");
//            else{
//                System.out.println("Alice");
//            }
////            int[]arr=new int[n];
////            for(int i=0; i<n; i++)arr[i]=sc.nextInt();
////
////            String s=sc.next();
//
//
//        }
//
//    }
//}



import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc-- > 0) {
            long a = sc.nextInt();
            long b = sc.nextInt();
            long c = a + b;
//            System.out.println(c);

            if (c % 2 == 0) {
                System.out.println("Bob");
            } else {
                System.out.println("Alice");
            }
        }
    }
}
