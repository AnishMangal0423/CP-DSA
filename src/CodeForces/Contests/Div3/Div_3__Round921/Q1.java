package CodeForces.Contests.Div3.Div_3__Round921;
//
//import java.util.Scanner;
//
//public class Q1 {
//
//    public static double dis(int[]arr1, int[]arr2){
//
//        int a=arr1[0];
//        int b=arr1[1];
//        int c=arr2[0];
//        int d=arr2[1];
//        return Math.sqrt((a-c)*(a-c) + (b-d)*(b-d));
//    }
//    public static void main(String[] args) {
//
//        Scanner sc=new Scanner(System.in);
//
//        int tc=sc.nextInt();
//
//        while (tc-->0){
//
////            int n=sc.nextInt();
//
//            int[]arr1=new int[2];
//            int[]arr2=new int[2];
//            int[]arr3=new int[2];
//            int[]arr4=new int[2];
//
//
//            for (int i=0; i<2; i++)arr1[i]=sc.nextInt();
//
//            for (int i=0; i<2; i++)arr2[i]=sc.nextInt();
//
//            for (int i=0; i<2; i++)arr3[i]=sc.nextInt();
//
//            for (int i=0; i<2; i++)arr4[i]=sc.nextInt();
//
//
//            double x=dis(arr1, arr2);
//            double y=dis(arr1, arr3);
//            double z=dis(arr1, arr4);
//
//           double zz=(int)Math.min(x, Math.min(y, z));
//            System.out.println(z*z);
//        }
//    }
//}

import java.util.Scanner;

public class Q1 {

    public static double dis(int[] arr1, int[] arr2) {
        int a = arr1[0];
        int b = arr1[1];
        int c = arr2[0];
        int d = arr2[1];
        return Math.sqrt((a - c) * (a - c) + (b - d) * (b - d));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
//        sc.nextInt();

        while (tc-- > 0) {
            int[] arr1 = new int[2];
            int[] arr2 = new int[2];
            int[] arr3 = new int[2];
            int[] arr4 = new int[2];

            for (int i = 0; i < 2; i++) arr1[i] = sc.nextInt();
            for (int i = 0; i < 2; i++) arr2[i] = sc.nextInt();
            for (int i = 0; i < 2; i++) arr3[i] = sc.nextInt();
            for (int i = 0; i < 2; i++) arr4[i] = sc.nextInt();

            double x = dis(arr1, arr2);
            double y = dis(arr1, arr3);
            double z = dis(arr1, arr4);

            double minDistance = Math.min(x, Math.min(y, z));
            System.out.println((int) (minDistance * minDistance));
        }
    }
}
