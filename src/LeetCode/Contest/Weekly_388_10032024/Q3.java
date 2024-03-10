package LeetCode.Contest.Weekly_388_10032024;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Q3{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[]arr=new String[n];

        HashMap<String, Integer>map = new HashMap<>();

        for(String s : arr){

            for(int i=0; i<s.length(); i++){

                String aa = "" + s.charAt(i);
                for(int j=i+1; j<s.length(); j++){

                      aa +=s.charAt(j);
                    if(map.containsKey(aa)==false){
                        map.put(aa, 1);
                    }
                }
            }
        }




        for(int i=0; i<n; i++){

            HashMap<String , Integer>mm = new HashMap<>();
            for(int j=0; j<n; j++){

                if(i==j)continue;
                else{

                    String ss = arr[j];

                    for(int l=0; l<ss.length(); l++){
//                        String aa = "" + ss.charAt(i);

                        for(int m=l+1; m<=ss.length(); m++){

                            String  aa = ss.substring(l, m);
                            mm.put(aa, 1);
                        }

                    }

                }
            }

            System.out.println(mm);


            ArrayList<String>aans = new ArrayList<>();

            String temp = arr[i];

            for(int b=0; b<temp.length(); b++){
                for(int c=b+1; c<=temp.length(); c++){

                    String timp = temp.substring(b,c);
                    if(map.containsKey(timp)==false){
                        aans .add(timp);
                    }
                }
            }

            Collections.sort(aans);
            if(aans.size()>0) arr[i]= aans.get(0);
            else arr[i]="";
        }

        String[]ans = new String[n];

        for(int i=0; i<n; i++){

           String ss = arr[i];



        }





    }
}
