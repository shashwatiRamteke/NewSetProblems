import java.util.ArrayList;
import java.util.Arrays;

public class MakeChangeCoin {
    public static void main(String[] args) {
        ArrayList<Integer> coins = new ArrayList<Integer>(Arrays.asList(9, 1, 8, 10, 3));
        int amount = 12;

        //System.out.println("Final number of ways : " + waysToMakeChange(coins,amount,0,coins.size()));
        System.out.println(number_of_ways(coins,amount));
        //System.out.println("Final number of ways : "+ waysToMakeChangeDP(coins,amount));

    }
    static Integer waysToMakeChange(ArrayList<Integer> coins, int amount, int startIndex, int endIndex){
        if(startIndex >= endIndex){
            if(amount%coins.get(startIndex) == 0 ){
                return 1 ;
            }
            else {
                return 0;
            }
        }

        Integer ways = waysToMakeChange(coins, amount, startIndex, endIndex-1);
        System.out.println("Subset");
        Integer tempamount =0;
        for(int i=0;i<endIndex;i++) {
            System.out.print(coins.get(i) + " ");
            tempamount += coins.get(i);
        }

        if(tempamount == amount){
           ways += 1;
       }
        return ways;
    }

    static Integer waysToMakeChangeDP(ArrayList<Integer> coins, int amount)
    {
        int ways = 0;
        ArrayList<Integer> tempamount = new ArrayList<>();
        for(int i=0;i<coins.size();i++){
            if(amount%coins.get(i) == 0){
                ways = ways + 1;
                tempamount.add(coins.get(i));
            }
            else {
                if(i-1>=0){
                    tempamount.add(tempamount.get(i-1) + coins.get(i));
                }
                else {
                    tempamount.add(coins.get(i));
                }
                if(tempamount.get(i) == amount){
                    ways = ways+1;
                }
            }
        }

        return ways;
    }


    static Integer number_of_waysDP(ArrayList<Integer> coins, Integer amount) {
        // Write your code here.
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int a = 1; a <= amount; a++) {
                if (coin <= a) {
                    dp[a] = dp[a]%1000000007+dp[a-32]%1000000007;
                }
            }
        }
        return dp[amount]%1000000007;
    }


    static Integer number_of_ways(ArrayList<Integer> coins, Integer amount) {
        int[] dpArray = new int[amount + 1];
        dpArray[0] = 1;
        for(int coin : coins){
            for(int i = 1; i < dpArray.length; i++){
                if(i - coin >= 0){
                    dpArray[i] = dpArray[i]% 1000000007+ dpArray[i-coin]%1000000007;
                }
            }
        }
        return dpArray[amount]%1000000007;
    }


}
