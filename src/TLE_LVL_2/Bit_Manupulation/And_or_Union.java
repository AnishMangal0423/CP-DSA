//package TLE_LVL_2.Bit_Manupulation;
//
//import java.util.Scanner;
//
//public class And_or_Union{
//
//    public static void main(String[] args) {
//
//        Scanner sc=new Scanner(System.in);
//
//        int tc=sc.nextInt();
//
//        while (tc-->0){
//
//            int n=sc.nextInt();
//            int[]arr=new int[n];
//
//            for(int i=0; i<n; i++)arr[i]=sc.nextInt();
//
//            int ans=0;
//            for(int i=30; i>=0; i--){
//
//                int count=0;
//
//                for(int j=0; j<n; j++){
//
//                    if(((arr[j] >> i) & 1)==1) count++;
//                    if(count > 1){
//                        ans |= (1<<i);
//                        break;
//                    }
//                }
//            }
//
//            System.out.println(ans);
//
//        }
//    }
//}


import java.util.Scanner;

public class And_or_Union {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();  // Number of test cases

        while (tc-- > 0) {

            int n = sc.nextInt();  // Size of the array
            int[] arr = new int[n];

            // Reading array elements
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int ans = 0;
            for (int i = 30; i >= 0; i--) {

                int count = 0;

                // Checking the i-th bit of each array element
                for (int j = 0; j < n; j++) {
                    if (((arr[j] >> i) & 1) == 1) {
                        count++;
                        if (count > 1) {
                            ans |= (1 << i);  // Setting the i-th bit in the answer
                            break;
                        }
                    }
                }
            }

            System.out.println(ans);  // Output the final result for each test case
        }
    }
}
