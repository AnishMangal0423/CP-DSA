package CodeForces.Contests.Div_4_918__01012024;

import java.util.*;

public class q4 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        sc.nextLine();

        while (tc-- >0){

            int n = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();

            HashMap<Character, Character>map = new HashMap<>();
            map.put('a', 'V');
            map.put('e', 'V');
            map.put('c', 'C');
            map.put('b', 'C');
            map.put('d', 'C');

            StringBuilder sb = new StringBuilder();


          int j =1;
          int[]arr = new int[n];

          while(j < s.length()){

              if(map.get(s.charAt(j-1))!=map.get(s.charAt(j))){
                  j++;
              }
              else {

                  arr[j-3]++;

                  j++;
              }
          }

//            System.out.println(Arrays.toString(arr));
   int i=0;

         while(i < n){

             if(i==n-3 || i==n-2){
                 sb.append(s.substring(i));
                 sb.append('.');
                 break;
             }
             else if(arr[i]==1){
                  sb.append(s.charAt(i));
                  sb.append(s.charAt(i+1));
                  sb.append(s.charAt(i+2));
                  sb.append('.');
                  i+=3;
              }

              else{
                  sb.append(s.charAt(i));
                  sb.append(s.charAt(i+1));
                  sb.append('.');
                  i+=2;
              }
          }
          sb.deleteCharAt(sb.length()-1);
         System.out.println(sb.toString());

        }


    }
}
