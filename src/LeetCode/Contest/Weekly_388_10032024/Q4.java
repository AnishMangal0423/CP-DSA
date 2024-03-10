package LeetCode.Contest.Weekly_388_10032024;

public class Q4 {

    public static void main(String[] args) {

        // Gyan of Lexicographiclly smallest finding

        // TC - O(N*M)
    String[]arr= {"aah", "ah", "anish", "aaah", "aaaaoz"};

      String smallest = arr[0];

      for(int i=1; i<arr.length; i++){

          if(arr[i].compareTo(smallest) < 0){
              smallest=arr[i];
          }
      }

        System.out.println(smallest);
    }
}
