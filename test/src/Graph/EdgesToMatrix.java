package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class EdgesToMatrix {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edgeToList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arrL1 = new ArrayList<>(Arrays.asList(0,1));
        edgeToList.add(arrL1);
        ArrayList<Integer> arrL2 = new ArrayList<>(Arrays.asList(1,2));
        edgeToList.add(arrL2);

        ArrayList<Integer> arrL3 = new ArrayList<>(Arrays.asList(1,4));
        edgeToList.add(arrL3);

        ArrayList<Integer> arrL4 = new ArrayList<>(Arrays.asList(1,3));
        edgeToList.add(arrL4);

        ArrayList<Integer> arrL5 = new ArrayList<>(Arrays.asList(1,2));
        edgeToList.add(arrL5);

        ArrayList<Integer> arrL6 = new ArrayList<>(Arrays.asList(3,4));
        edgeToList.add(arrL6);



        Integer[][] resultstr = convertEdgeTomatrix(edgeToList,5);

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){

                System.out.print(resultstr[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static Integer[][] convertEdgeTomatrix(ArrayList<ArrayList<Integer>> edges, int n){
        Integer[][] matrix = new Integer[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = 0;
            }
        }

        for(ArrayList<Integer> edge : edges){
            matrix[edge.get(0)][edge.get(1)] = 1;
            matrix[edge.get(1)][edge.get(0)] = 1;
        }

        return matrix;
    }
}
