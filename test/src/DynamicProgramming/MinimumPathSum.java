package DynamicProgramming;

import java.util.ArrayList;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] mat = {
                {2},
                {-4, -3},
                {8, 3, 9},
                {4, 2, 1, 6},
        };

        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();

        for(int i =0; i < 4;i++) {
            ArrayList<Integer> currRow = new ArrayList<>();
            for (int j = 0; j < 4; j++){
                currRow.add(mat[i][j]);
            }
            triangle.add(currRow);
        }

        //get_minimum_path_sum(triangle);
    }

    static Integer get_minimum_path_sum(ArrayList<ArrayList<Integer>> triangle) {
        // Write your code here.
        int n = triangle.size();
        int finalminpathsum = 0;
        for(int i=0;i<n-1;i++) {
            ArrayList<Integer> currRow = triangle.get(i);
            int m  =currRow.size();
            int min = 0;
            for (int j=0;j<m-1;j++){
                if(min > currRow.get(j))
                {
                    min = currRow.get(j);
                }
                System.out.print(min);
            }
            finalminpathsum += min;

        }

        return finalminpathsum;
    }

}
