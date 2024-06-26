package Recursion;

import java.util.ArrayList;

public class AddOrSubtractNumberToSum {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        int sum = 3;
        ArrayList<Integer> allPossiblrValue = new ArrayList<>();

        int numberofpossibility =  countAllPossibleSum(arr, sum,0,0, allPossiblrValue);
       System.out.println(numberofpossibility);
       System.out.println("Printing actual values");
       System.out.println(allPossiblrValue);
    }

    public static int countAllPossibleSum(int[] arr, int sum, int i, int sumuntilnow, ArrayList<Integer> allPossiblrValue){
        if(i==arr.length){
            allPossiblrValue.add(sumuntilnow);
            if(sumuntilnow == sum){
                return 1;
            }
            else
            {
                return 0;
            }
        }
        else
        {
            int count = 0;
            count += countAllPossibleSum(arr, sum, i + 1, sumuntilnow + arr[i], allPossiblrValue);
            count +=  countAllPossibleSum(arr, sum,  i + 1, sumuntilnow - arr[i], allPossiblrValue);
            return count;
        }
    }
}
