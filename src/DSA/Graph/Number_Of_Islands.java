package DSA.Graph;
import java.util.*;


public class Number_Of_Islands{


    public static void islands(char[][]matrix, boolean[][]visited, int i, int j, int row, int col){

        visited[i][j] = true;

        int[][]Coor = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

        for(int[]childs : Coor){

            int x = i + childs[0];
            int y = j + childs[1];

            if(x>=0 && x<row && y>=0 && y<col && visited[x][y]==false && matrix[i][j]=='1'){

                islands(matrix, visited , x , y, row, col);
            }
        }

    }

    public static void main(String[]args){



        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        char[][]matrix = new char[m][n];
        for(int i=0; i<m; i++){
            String temp = sc.next();
           for(int j=0; j<n; j++){
               matrix[i][j]=temp.charAt(j);
           }
        }

        boolean[][]visited = new boolean[m][n];
        int k =0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                if(matrix[i][j]=='1' && visited[i][j]== false){
                    k++;
                    islands(matrix, visited, i,j, m , n);
                }

            }
        }
        System.out.println(k);

    }

}