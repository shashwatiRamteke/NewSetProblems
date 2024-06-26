package DynamicProgramming;

import java.util.ArrayList;

public class PascalTriangel {
    public static void main(String[] args) {
        int n = 1700;
        ArrayList<ArrayList<Integer>> finalResult = find_pascal_triangle(n);
        for(int i=0;i<n;i++){
            ArrayList<Integer> currRow = finalResult.get(i);
            for(int j=0;j<n;j++)
                System.out.print(currRow.get(j) + " ");
            System.out.println();
        }
    }

    static ArrayList<ArrayList<Integer>> find_pascal_triangle(Integer n) {
        int[][] pascalTriangle = new int[n][n];
        for (int i = 0; i < n; i++) {
            pascalTriangle[i][0] = 1;
        }

        for (int i = 0; i < n; i++)
            for (int j = 1; j <= i; j++) {
                pascalTriangle[i][j] = (pascalTriangle[i - 1][j] + pascalTriangle[i - 1][j - 1])%1000000007;
            }

        ArrayList<ArrayList<Integer>> finalPascalTriangle = new ArrayList<ArrayList<Integer>>();
         for (int i = 0; i < n ; i++){
             ArrayList<Integer> currRow = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                currRow.add(pascalTriangle[i][j]);
            }
             finalPascalTriangle.add(currRow);
        }

        return finalPascalTriangle;
    }
}

