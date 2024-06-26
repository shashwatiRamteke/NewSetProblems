package DynamicProgramming;

public class ClimbingStairs {
    public static void main(String[] args) {
        int noOfStairs = 10;

        System.out.println(numberOfWaysToClimb(noOfStairs));
    }

    public static int numberOfWaysToClimb(int noOfStairs){
        int[] table = new int[noOfStairs+1];
        table[1] = 1;
        table[2] = 2;

        for(int i=3;i<=noOfStairs;i++){
            table[i] = table[i-1]  + table[i-2];
        }
        return table[noOfStairs];
    }
}
