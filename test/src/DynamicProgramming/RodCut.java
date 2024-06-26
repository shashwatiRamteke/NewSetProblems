package DynamicProgramming;

import java.util.Map;

public class RodCut {
    public static void main(String[] args) {
        int lenghtOfROd = 4;
        int[] costOfInchOfRod = {0,2,5,7,8};
        System.out.println(maxProfitFromRod(lenghtOfROd, costOfInchOfRod));

    }

    public static int maxProfitFromRod(int width, int[] costOfInchOfRod)
    {
        int[] table = new int[width+1];
        table[0] = 0;
        for(int i=1;i <= width ; i++){

            table[i] = Integer.MIN_VALUE;
            for(int k=1;k<=i;k++){
                int sum = costOfInchOfRod[k] + table[i-k];
                table[i] = Math.max(table[i],sum);

            }
        }
        return table[width];
    }
}
