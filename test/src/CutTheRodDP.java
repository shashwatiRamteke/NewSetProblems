import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Collections.max;

public class CutTheRodDP
{
    public static void main(String[] args) {
        ArrayList<Integer> price = new ArrayList<>(Arrays.asList(2, 5, 6, 9));
        //System.out.println("Print " + get_maximum_profit(price));
        System.out.println(max_product_from_cut_pieces(4));
    }

    static Integer get_maximum_profit(ArrayList<Integer> price) {
        // Write your code here.

        int n = price.size();

        int[] table = new int[price.size()+1];

        for (int i = 1; i <= n; i++) {
            table[i] = price.get(i - 1);
        }

        for(int j=1;j<=n;j++){
            for(int i=0;i<=j;i++){

                System.out.println(table[j-i]);
                int tempValue =  table[j] + table[j-i];
                table[j] = Math.max(table[j], tempValue);
            }

        }
        return table[n];
    }

    static Integer get_maximum_profit2(ArrayList<Integer> price) {

        int n = price.size();
        // dp[i] means the max value you can get from cutting a rod of length i
        int[] dp = new int[n + 1];

        // initialize to sell as a whole
        for (int i = 1; i <= n; i++) {
            dp[i] = price.get(i - 1);
        }

        for (int i = 1; i <=n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + dp[i - j]);
            }
        }
        return dp[n];
    }

    static Integer max_product_from_cut_pieces(Integer n) {
        // dp[i] means the max value you can get from cutting a rod of length i
        int[] dp = new int[n + 1];

        // initialize to sell as a whole
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
        }
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;



        for (int i = 2; i <=n; i++) {
            for (int j = 1; j <= i; j++) {
                int product = dp[i-j] * j;
                dp[i] = Math.max(dp[i], product);
            }
        }

        return dp[n];
    }



}


