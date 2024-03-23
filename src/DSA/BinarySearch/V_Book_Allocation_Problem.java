package DSA.BinarySearch;

import java.util.Scanner;
/***
 *
 * Concept :- Binary Search on Answers.
 *
 * key-Point :- First of all thinking of Brute force on Answers.
 *
 * Approch :- ans hamesha max element se bada hoga so i=maxElement ..
 *            is se thode jada groups generate ho jayenge, kyuki val choti h na..
 *            value ko aage badate jaynge aur jo phli value no of groups fulfilled satisfy kr jaynge wahi ans hoga.
 *
 *            TC - O((sum-max) * N)
 *            SC - O(1)
 *
 *
 *         Approch-2 :- Binary Search-
 *         Now s=max, e= sum se minimum value nikal lo ans ki ,..
 *
 *         TC - O( N * log(Sum-max))
 *         SC - O(1)

 * **/


public class V_Book_Allocation_Problem{

    public static int NumberOfStudents(int[]arr, int val){

             int students = 0;

             int sum = 0;
             for(int i=0; i<arr.length; i++){
                 sum+=arr[i];

                 if(sum > val){
                     students++;
                     sum = arr[i];
                 }
             }

             return students+1;
    }
    public static int BinarySearch(int[]arr, int students){

        int n = arr.length;
        int maxi = -1;
        int sum = 0;
        for(int i=0; i<n; i++){
            maxi=Math.max(maxi, arr[i]);
            sum+=arr[i];
        }


        int s = maxi;
        int e = sum;
        int ans = sum;

        while (s <= e){

           int mid = (s + e)/2;

           int Number_of_Students_on_Mid = NumberOfStudents(arr, mid);

            System.out.println(s + " "+mid+" "+e+" "+ Number_of_Students_on_Mid);
           if(Number_of_Students_on_Mid <= students){
               ans = Math.min(ans, mid);
               e=mid-1;
           }


           else s = mid+1;
        }

   return ans;
    }

    public static int LinearSearch(int[]arr, int students){

        int n = arr.length;
        int maxi = -1;
        int sum = 0;
        for(int i=0; i<n; i++){
            maxi=Math.max(maxi, arr[i]);
            sum+=arr[i];
        }

        for(int i=maxi; i<=sum; i++){

            int Number_of_Students = NumberOfStudents(arr, i);

            if(Number_of_Students == students)return i;
        }
    return -1;
    }
    public static void main(String[] args) {

        System.out.println("Enter the size of Array : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr=new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();
        int students = sc.nextInt();

        System.out.println("Minimum of Maximum Pages Assigned to Students are ?: " + LinearSearch(arr, students));
//        System.out.println("Minimum of Maximum Pages Assigned to Students are ?: " + BinarySearch(arr, students));
    }
}
