package GFG.POTD;
import java.util.ArrayList;
import java.util.Scanner;

/**

 Topic - Prefix and Suufix Maximum and Minimum.

 Intution - Thoda sa prospective change krna hoga qn ko dkhne ka hme leftmin chaiye , then element khud and rightmax chaiye.
 use prefex concept.

 Time - O(N)
 Space - O(N)

 **/
public class L_SortedSubsequence_ofSize3__31082024 {

    public static ArrayList<Integer> GetSubsequence(int[]arr){

        int n = arr.length;
        int[]leftmin = new int[n];
        int[]rightmax = new int[n];
        leftmin[0]=arr[0];
        for(int i=1; i<n; i++)leftmin[i]=Math.min(leftmin[i-1] , arr[i]);
        rightmax[n-1]=arr[n-1];
        for(int i=n-2; i>=0; i--)rightmax[i]= Math.max(rightmax[i+1] , arr[i]);

        ArrayList<Integer>ans = new ArrayList<>();

        for(int i=1; i<n-1; i++){

            if(leftmin[i] < arr[i] && rightmax[i]> arr[i]){
                ans.add(leftmin[i]);
                ans.add(arr[i]);
                ans.add(rightmax[i]);
                return ans;
            }
        }
        return ans;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[]arr = new int[n];

        for(int i=0; i<n; i++)arr[i]=sc.nextInt();

        System.out.println(GetSubsequence(arr));
    }
}
