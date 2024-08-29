package CodeForces.Contests.Div3.Div_3__Round966__13082024;

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class Q3 {
//
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        int t = sc.nextInt();
//
//        while (t-->0){
//
//            int n = sc.nextInt();
//
//            HashMap<Integer , ArrayList<Integer>>map = new HashMap<>();
//            int[]arr = new int[n];
//            for(int i=0; i<n; i++){
//                arr[i]=sc.nextInt();
//
//                if(map.containsKey(arr[i])==false){
//                    ArrayList<Integer>arrr = new ArrayList<>();
//                    arrr.add(i);
//                    map.put(arr[i] , arrr);
//                }
//
//                else{
//                    ArrayList<Integer>temp = map.get(arr[i]);
//                    temp.add(i);
//                    map.put(arr[i] , temp);
//                }
//            }
//
//            int m = sc.nextInt();
//
//            String[]arr2 = new String[m];
//
//            for(int i=0; i<m; i++){
//                arr2[i] = sc.nextLine();
//            }
//
//
//            System.out.println(map);
//            boolean flag = true;
//            for(int i=0; i<m; i++){
//
//                String s1 = arr2[i];
//
//               for(int kii : map.keySet()){
//
//                   ArrayList<Integer>val = map.get(kii);
//
//                   char cc = s1.charAt(val.get(0));
//
//                   for(int j=1; j<val.size(); j++){
//
//                       int vaal = val.get(j);
//                       if(s1.charAt(vaal)!=cc){
//                           flag=false;
//                           break;
//                       }
//                   }
//
//                   if (flag==false)break;
//               }
//
//                if (flag==true) System.out.println("YES");
//                else System.out.println("NO");
//            }
//
//        }
//    }
//}

//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class Q3 {
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        int t = sc.nextInt();
//
//        while (t-- > 0) {
//
//            int n = sc.nextInt();
//
//            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
//            int[] arr = new int[n];
//            for (int i = 0; i < n; i++) {
//                arr[i] = sc.nextInt();
//            }
//
//            int m = sc.nextInt();
//            sc.nextLine();  // Consume the leftover newline character
//
//            String[] arr2 = new String[m];
//
//            for (int i = 0; i < m; i++) {
//                arr2[i] = sc.nextLine();
//            }
//
//
//
//            for (int i = 0; i < m; i++) {
//
//                String s1 = arr2[i];
//              boolean fl = true;
//
//              if(s1.length()!= n){
//                  fl=false;
//              }
//              else {
//                  HashMap<Character , Integer>map2= new HashMap<>();
//                  for (int j = 0; j < n; j++) {
//
//                      char c = s1.charAt(j);
//
//                      if(map2.containsKey(c)==false){
//                          map2.put(c , arr[j]);
//                      }
//
//                      else{
//                          int vaal = map2.get(c);
//
//                          if(vaal != arr[j]){
//                              fl=false;
//                              break;
//                          }
//                      }
//                  }
//
//              }
////                System.out.println(map2);
//              if (fl==true) System.out.println("YES");
//              else System.out.println("NO");
//            }
//
//        }
//    }
//}

import java.util.HashMap;
import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt();  // Number of elements in the array a
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int m = sc.nextInt();  // Number of strings to check

            for (int i = 0; i < m; i++) {
                String s = sc.next();  // Read each string

                if (s.length() != n) {
                    System.out.println("NO");
                    continue;
                }

                HashMap<Integer, Character> map1 = new HashMap<>();
                HashMap<Character, Integer> map2 = new HashMap<>();
                boolean isMatch = true;

                for (int j = 0; j < n; j++) {
                    int num = a[j];
                    char ch = s.charAt(j);

                    if (!map1.containsKey(num)) {
                        map1.put(num, ch);
                    } else if (map1.get(num) != ch) {
                        isMatch = false;
                        break;
                    }

                    if (!map2.containsKey(ch)) {
                        map2.put(ch, num);
                    } else if (map2.get(ch) != num) {
                        isMatch = false;
                        break;
                    }
                }

                if (isMatch) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        sc.close();
    }
}
