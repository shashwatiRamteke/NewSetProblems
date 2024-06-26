import java.util.ArrayList;

public class NumberOPathsInMatrix {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>>  matrix = new ArrayList<>();
        int n=2,m=2;
        for(int i =0;i<n-1;i++) {
            ArrayList<Integer> rowList = new ArrayList<Integer>();
            for (int j = 0; j < m; j++) {
                rowList.add(1);
            }
            matrix.add(rowList);
        }

        ArrayList<Integer> rowList = new ArrayList<Integer>();

        for (int j = 0; j < m-1; j++) {
            rowList.add(1);
        }
        rowList.add(0);
        matrix.add(rowList);


        System.out.println(number_of_paths(matrix));
    }
    static Integer number_of_paths(ArrayList<ArrayList<Integer>> matrix) {

        int n = matrix.size();
        int m = matrix.get(0).size();

        int[][] table = new int[n][m];

        for(int k=0;k<n;k++){
            if(matrix.get(k).get(0) == 0)
                break;

            table[k][0] = 1;
        }
        for(int k=0;k<m;k++){
            if(matrix.get(0).get(k) == 0)
                break;
            table[0][k] = 1;
        }

        for(int i=1;i<n;i++){
            ArrayList<Integer> prevlist = matrix.get(i-1);
            ArrayList<Integer> rowlist = matrix.get(i);
            for(int j=1;j<m;j++){
                int left =  rowlist.get(j-1);
                int top = prevlist.get(n-1);
                if(left == 1 && rowlist.get(j) != 0 ){
                    table[i][j] += table[i][j-1];
                }
                if(top == 1 && rowlist.get(j) != 0){
                    table[i][j] += table[i-1][j];
                }
            }
        }

        return table[n-1][m-1];
    }

}
