package ArrayFloater;

public class RangeSumInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{3,0,1,4,2},
                          {5,6,3,2,1},
                          {1,2,0,1,5},
                          {4,1,0,1,7},
                          {1,0,3,0,5}};
        int[] subrange = {2,1,4,3};
        System.out.println(sumInRange(matrix,subrange));
    }

    static int[][] makeSomeStoreddForm(int[][] matrix){
        int currsum =0 ;
        int[][] resultmatrix = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                currsum = currsum + matrix[i][j];
                resultmatrix[i][j] = currsum;
            }
        }
        return resultmatrix;
    }

    static int sumInRange(int[][] matrix, int[] subrange){
        int row1 = subrange[0];
        int col1 = subrange[1];
        int row2 = subrange[2];
        int col2 = subrange[3];

        int[][] prefixSUM = makeSomeStoreddForm(matrix);

        if(row1 == 0 && col1 == 0){
            return prefixSUM[row2][col2];
        }
        else {
            return prefixSUM[row2][col2] - prefixSUM[row1-1][col2]  - prefixSUM[row2][col1-1] + prefixSUM[row1-1][col1-1];
        }
    }
}
