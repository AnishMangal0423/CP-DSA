package LeetCode.POTD;
//
//Example 3:
//
//        Input: formula = "K4(ON(SO3)2)2"
//        Output: "K4N2O14S4"
//        Explanation: The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
//

import DSA.Tree.Tree;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class U_Numberof_Atoms {

    public static String Dissociate(String formula){

        int n = formula.length();
        TreeMap<String, Integer>map = new TreeMap<>();

        Stack<Integer>stk = new Stack<>();
        int[]freq = new int[n]; Arrays.fill(freq, 1);
        for(int i=0; i<n; i++){
            char c = formula.charAt(i);
            System.out.println(Arrays.toString(freq));
            if(c=='('){
                stk.add(i);
            }

            else if(c==')'){

                String tempstr = "";
                for(int j=i+1; j<n; j++){
                    char cj = formula.charAt(j);
                    if(cj-'0'<=9 && cj-'0'>=0)tempstr+=cj;
                    else break;
                }
//                freq[stk.pop()] = Integer.parseInt(tempstr);

                int startingIndex = stk.pop();
                for(int k=startingIndex; k<=i; k++){
                    freq[k]= freq[k] * (Integer.parseInt((tempstr=="")?"1":tempstr));
                }
            }
        }
        System.out.println(Arrays.toString(freq));

        // Part - 2

        int i=0;

        while (i<n){
            char c = formula.charAt(i);

            if(c=='('){
                i++;
            }

            else if(c==')'){
                String tempstr = "";
                int j;
                for(j=i+1; j<n; j++){
                    char cj = formula.charAt(j);
                    if(cj-'0'<=9 && cj-'0'>=0)tempstr+=cj;
                    else break;
                }
                i=j;
            }

            else{
                // In this Process I am Making the Key -

                String Kii = ""+c;
                int l;
                for(l=i+1; l<n; l++){
                    char cc = formula.charAt(l);
                    if(cc-'0' <= 74 && cc-'0'>=49)Kii+=(""+cc);
                    else break;
                }
                i=l-1;
                int freqq = freq[i];
               if(map.containsKey(Kii)==false)map.put(Kii, 0);

                     // In this process I am Making the Key.
                 String tempstr = "";
                int j;
                for(j=i+1; j<n; j++){
                    char cj = formula.charAt(j);
                    if(cj-'0'<=9 && cj-'0'>=0)tempstr+=cj;
                    else break;
                }
                i=j;

                int val = map.get(Kii);
                map.put(Kii, val + Integer.parseInt(tempstr==""?"1":tempstr)*freqq);
            }
        }



        System.out.println(Arrays.toString(freq));
        System.out.println(map);


        StringBuilder ans = new StringBuilder();
        for(String Kii : map.keySet()){
            int val = map.get(Kii);

            ans.append(Kii);
            if(val!=1)ans.append(val);
        }
        return ans.toString();
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Atomic Formula ?: ");
        String formula = sc.nextLine();
        System.out.println("The Dissociated Formula is ?: "+ Dissociate(formula));

    }
}
