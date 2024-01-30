package TLE_LVL_2.CS31_Sheet._900;

//import java.util.HashMap;
//import java.util.Scanner;
//
//public class Chemistry {
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        int tc = sc.nextInt();
//        sc.nextLine();
//
//        while (tc-- >0){
//
//            int n=sc.nextInt();
//            int k=sc.nextInt();
//
//            String s = sc.next();
//
//            HashMap<Character, Integer>m = new HashMap<>();
//
//            for(int i=0; i<s.length(); i++){
//                char c = s.charAt(i);
//
//                if(!m.containsKey(c)){
//                    m.put(c, 1);
//                }
//                else {
//                    int val = m.get(c);
//                    m.put(c, val+1);
//                }
//            }
//            int count=0;
//            for(int key : m.keySet()){
//                if(m.get(key)%2!=0)count++;
//            }
//
//            if(count==k) System.out.println("Yes");
//            else System.out.println("No");
//        }
//
//    }
//}


import java.util.HashMap;
import java.util.Scanner;

public class Chemistry {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        sc.nextLine();  // Consume the newline character after reading tc

        while (tc-- > 0) {

            int n = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();  // Consume the newline character after reading k

            String s = sc.next();

            HashMap<Character, Integer> m = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (!m.containsKey(c)) {
                    m.put(c, 1);
                } else {
                    int val = m.get(c);
                    m.put(c, val + 1);
                }
            }

            int count = 0;
            for (char key : m.keySet()) {  // Change the type of key to char
                if (m.get(key) % 2 != 0) count++;
            }

            if (count-1 <= k) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}

