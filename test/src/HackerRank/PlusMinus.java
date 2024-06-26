package HackerRank;

import java.io.*;
import java.util.*;

class ResultPlusMinus {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        int size = arr.size();
        int positiveIntegers = 0;
        int negativeIntegers = 0;
        int zeroIntegers = 0;
        for(int i=0;i<arr.size();i++){
            int currint = arr.get(i);
            if(currint < 0){
                negativeIntegers++;
            }
            if(currint > 0){
                positiveIntegers++;

            }
            if(currint == 0){
                zeroIntegers++;
            }
        }
        double posti = (double) positiveIntegers/size;
        double net =  (double)negativeIntegers/size;
        double zer = (double) zeroIntegers/size;
        System.out.format("%.5f\n", posti);
        System.out.format("%.5f\n", net);
        System.out.format("%.5f\n", zer);

    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = 6;
                //Integer.parseInt(bufferedReader.readLine().trim());

        //
                //bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String[] arrTemp = {"4", "3", "-9", "0", "4", "1"};
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        ResultPlusMinus.plusMinus(arr);

        //fraction = (double) numerator / denominator;
        //fractionValue = (int) (fraction * 10);
        //decimal = fractionValue % 10;
       // value = decimal * 0.1;

        bufferedReader.close();
    }
}

