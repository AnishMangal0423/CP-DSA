package LeetCode.Contest.Weekly_388_10032024;

import java.util.*;

/***
 *
 *
 * Question :- Ek Strings ki array given h , aur abb hme kya karna h ki string[]ans hi return krna h .. ki ans[i] = "" ya to
 *             Null hogi ya fir lexcicographically smallest substring hogi arr[i] ki ho bakki kisi bhi strings ke substring
 *             mai mentioned nhi h.
 *
 *
 *
 *  Approch :- Simple But lengthy-
 *             1. Har string pe jao , bakki ka map bna lo.
 *             2. aab is string har substring ko check krlo h ya nhi.
 *             3. agar nhi h , to lexicographically smallest ka loop laga do.
 *             4. Ans aa jayega.
 *
 *
 *
 *             TC - O(N* M^2 * log(M^2))  ~~ 10^5 becausse n <= 100 && m<=20
 *             SC - O(N * M * M ) of hashmap at worst casse.
 *
 *
 *
 * Larning :- It was an easy question, but a lengthy one.
 *            1. Understand question properly.
 *            2. Make map in mind ( becuase it is lengthy so it will be worse if you change in between )
 *            3. Implement with calm mind and fast hands, not opoosite.
 *
 * **/


public class Q3{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[]arr=new String[n];
        for(int i=0; i<n; i++)arr[i]=sc.next();

        String[]ans = new String[n];

        for(int i=0; i<n; i++){


            // For every String Making the Map of all other strings :- TC - O(N * M^2 log(M^2)) , SC - O(N*M^2)
            HashMap<String , Integer>mm = new HashMap<>();
            for(int j=0; j<n; j++){

                if(i==j)continue;
                else{

                    String ss = arr[j];

                    // Calcultaing all the Substrings of a string -
                    for(int l=0; l<ss.length(); l++){

                        String str = "" + ss.charAt(l);
                        for(int m=l; m<ss.length(); m++){
                           if(l!=m)str+=ss.charAt(m);
                           mm.put(str, 1);
                        }

                    }

                }
            }

            String temp = arr[i];

            // TC - O(M^3)

            String smallest = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";  // Longest string of length > 20

            for(int b=0; b<temp.length(); b++){
                for(int c=b+1; c<=temp.length(); c++){


                    String timp = temp.substring(b,c);
                    if(mm.containsKey(timp)==false){

                        if(timp.compareTo(smallest) < 0){
                            smallest=timp;
                        }
                    }
                }
            }

            // System.out.println(aans+ " "+ len);
            if(smallest.length() <= 20) {

                 ans[i]= smallest;

            }
            else ans[i]="";
        }

        System.out.println(Arrays.toString(ans));

    }
}
