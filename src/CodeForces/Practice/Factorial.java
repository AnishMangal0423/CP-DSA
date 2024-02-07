package CodeForces.Practice;
import java.util.*;

public class Factorial{

    public static boolean Palindrome(String s){
        int n= s.length();
        int i=0, j=n-1;

        while(i < j){

            if(s.charAt(i)!=s.charAt(j)) return false;

            i++;
            j--;
        }

        return  true;

    }
    public static void Partition(String s, List<List<String>> helper, int i, int n, ArrayList<String>arr){


        if(i==n){
            helper.add(new ArrayList<>(arr));
            return;
        }

        for(int j=i; j<n; j++){

            String temp = s.substring(i, j+1);
            if(Palindrome(temp)){
                arr.add(temp);
                Partition(s, helper, j+1, n, arr);
                arr.remove(arr.size()-1);
            }

        }

    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n= s.length();

        ArrayList<String>arr=new ArrayList<>();
        List<List<String>>helper=new ArrayList<>();
        Partition(s,helper, 0, n,arr);

        for(List<String>h : helper){
            System.out.println(h);
        }

    }

}