package PatternsDSA.SlidingWindow.Practice_Problems;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 *
 * **/
public class D_Fruits_into_Baskets__LeetCode_904 {

    public static int totalFruit(int[] fruits) {
        int n = fruits.length;
        int l = 0, r = 0, maxlen = 0;   // Step-1
        HashMap<Integer, Integer> map = new HashMap<>();

        while (r < n) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);  // Step-2

            while (map.size() > 2) {   // Step-4
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) map.remove(fruits[l]);
                l++;
            }
            maxlen = Math.max(maxlen, (r - l + 1));   // Step-3
            r++;

        }
        return maxlen;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of trees : ");
        int n = sc.nextInt();
        int[] fruits = new int[n];
        System.out.println("Enter the fruit type in array : ");
        for (int i = 0; i < n; i++) fruits[i] = sc.nextInt();
        System.out.println("The number of trees from which we can pick the fruits are : " + totalFruit(fruits));

    }
}
