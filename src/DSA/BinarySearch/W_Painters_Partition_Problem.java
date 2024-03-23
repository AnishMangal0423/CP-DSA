package DSA.BinarySearch;

import java.util.Scanner;

public class W_Painters_Partition_Problem{

    public static int NumberOfPainters(int[]arr, int val){

        int painters = 0;

        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];

            if(sum > val){
                painters++;
                sum = arr[i];
            }
        }

        return painters+1;
    }

    public static int BinarySearch(int[]arr, int Painters){

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

            int Number_of_Painters_on_Mid = NumberOfPainters(arr, mid);

//            System.out.println(s + " "+mid+" "+e+" "+ Number_of_Students_on_Mid);
            if(Number_of_Painters_on_Mid <= Painters){
                ans = Math.min(ans, mid);
                e=mid-1;
            }

            else s = mid+1;
        }

        return ans;
    }
    public static int LinearSearch(int[]arr, int Painters){

        int n = arr.length;
        int maxi = -1;
        int sum = 0;
        for(int i=0; i<n; i++){
            maxi=Math.max(maxi, arr[i]);
            sum+=arr[i];
        }

        for(int i=maxi; i<=sum; i++){

            int Number_of_Painters = NumberOfPainters(arr, i);

            if(Number_of_Painters == Painters)return i;
        }
        return -1;
    }
    public static void main(String[] args) {

        System.out.println("Enter the size of Array : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr=new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();
        System.out.println("Enter the Number of Painters : ");
        int Painters = sc.nextInt();

        System.out.println("Minimum of Maximum Pages Assigned to Students are ?: " + LinearSearch(arr, Painters));
//      System.out.println("Minimum of Maximum Pages Assigned to Students are ?: " + BinarySearch(arr, Painters));


    }
}
