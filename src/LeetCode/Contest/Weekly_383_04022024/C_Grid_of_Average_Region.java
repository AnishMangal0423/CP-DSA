package LeetCode.Contest.Weekly_383_04022024;


import java.util.*;
import java.lang.*;
public class C_Grid_of_Average_Region{

    static int[][]coord={{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public static boolean dfs(int[][]reg, int i, int j,int si, int sj, int k){

//        for(int b=0; b<reg.length; b++) System.out.println(Arrays.toString(reg[b]));

        for(int[]cord : coord){
            int x=i+ cord[0];
            int y=j+ cord[1];
//            System.out.println("i :"+ i+" j: "+j +" x: "+x+" y:"+y);

            if(x>=0 && x<=2 && y>=0 && y<=2){
//                System.out.println("reg "+reg[i][j] +" "+reg[x][y]);

                if(Math.abs(reg[i+si][j+sj] - reg[x+si][y+sj]) > k){
                    return false;
                }

            }
        }


        return true;
    }
    public static int check(int[][]reg, int si, int sj, int k){

        int m=reg.length;
        int n=reg[0].length;


        for(int i=0; i<=2; i++) {
            for (int j = 0; j <=2; j++) {
//                System.out.println("si"+si+"sj"+sj);
                if (dfs(reg, i, j,si, sj, k) == false) return -1;

            }
        }

        int val=0;
        for(int a=si; a<=si+2; a++){
            for(int b=sj; b<=sj+2; b++){

                val+=reg[a][b];
            }
        }


        return (int)Math.floor(val / 9);
    }





    public static void main(String[] args) {


 // ------------------------------------  Input start --------------------------------------------------------------
        Scanner sc = new Scanner(System.in);

        int m=sc.nextInt();
        int n=sc.nextInt();

        int[][]img=new int[m][n];
        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++)img[i][j]=sc.nextInt();
        }


        ArrayList<ArrayList<ArrayList<Integer>>>simg=new ArrayList<>();

        for(int i=0; i<m; i++)simg.add(new ArrayList<>());
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                simg.get(i).add(new ArrayList<>());
            }
        }

        int k=sc.nextInt();


// ------------------------------------ Input Ends ----------------------------------------------------------------

        for(int i=0;i<m-2; i++){
            for(int j=0; j<n-2; j++){
//                System.out.println(i+" "+j);
                int val = check(img, i, j, k);
//                System.out.println(val);
                if(val!=-1){

                    for(int p=i; p<=i+2; p++){
                        for(int q=j; q<=j+2; q++){

                            simg.get(p).get(q).add(Integer.valueOf(val));

                        }
                    }
                }
            }
        }

//        System.out.println(simg);
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                ArrayList<Integer>aa=simg.get(i).get(j);
                int sum=0;
                for(int val : aa)sum+=val;

                if(sum!=0) img[i][j]=((int)Math.floor(sum/(aa.size())));

            }
        }


        for(int i=0; i<m; i++) System.out.println(Arrays.toString(img[i]));
    }
}