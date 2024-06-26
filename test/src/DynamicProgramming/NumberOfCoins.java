package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class NumberOfCoins {
    public static void main(String[] args) {
        List<Integer> coins = new ArrayList<>(Arrays.asList(1,3,5));
        int suma = 14;
        System.out.println(minNumberOfCoins(suma,coins));
    }

    public static Integer minNumberOfCoins(Integer suma, List<Integer> coins){
        int[] table = new int[suma+1];
        table[0] = 0;
        for(int i=1;i<(suma+1);i++)
        {
            table[i] = Integer.MAX_VALUE;
        }

        for(int i=1;i<=suma;i++){
            for(Integer coin:coins){
                if(i-coin >= 0){
                    table[i] = Math.min(table[i],table[i-coin]);
                }
            }
            table[i]++;
        }
        return table[suma];
    }
}
