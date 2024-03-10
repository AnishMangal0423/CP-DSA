package LeetCode.Contest.Weekly_388_10032024;

public class Q2 {

    public static void main(String[] args) {

        Arrays.sort(h);

        int ans = 0;
        int n = h.length;
        itn sum = 0;
        for(i=0; i<n; i++){
            sum+=h[i];
        }

        int var =1;
        int ss=0;
        if(k==1)return (sum - (n-1));
        int minus=0;
        for(int i=n-1; i>=0; i--){

            if(k>var){
                ss+=minus;
                minus--;
            }
            else{
                ss+=Math.max(0, h[i]+minus);
            }
            var++;

        }



    }
}
