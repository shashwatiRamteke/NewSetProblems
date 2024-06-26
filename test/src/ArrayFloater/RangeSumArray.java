package ArrayFloater;

import java.util.Arrays;

public class RangeSumArray {
    public static void main(String[] args) {
        int[] arr = {-2,0,3,-5,2,-1};
        int[] subrange = {0,2};
        int currsum = 0;
        int[] resultArr = new int[arr.length];

        for(int i=0,k=0;i<arr.length;i++){
            int startindex = subrange[0];
            int endindex = subrange[1];
            if(i >= startindex && i<=endindex){
                currsum = arr[i] + currsum;
            }
            if(i == endindex){
                resultArr[k] = currsum;
                k++;

            }
        }
        System.out.println(resultArr[0]);

        System.out.println("With o(1)");
        System.out.println(caluculateRangeSum(arr,subrange));
    }

    static int[] makePrefixsSum(int[] arr){
        int currsum = 0;
        int[] prefixSum = new int[arr.length];
        for(int i =0;i<arr.length;i++){
            currsum = arr[i] + currsum;
            prefixSum[i] = currsum;
        }
        return prefixSum;
    }

    static int caluculateRangeSum(int[] arr, int[] range){
        int[] prefixSum = makePrefixsSum(arr);
        int startidex = range[0];
        int endidex = range[1];

        if(startidex == 0){
            return prefixSum[endidex];
        }
        else
        {
            return prefixSum[endidex] - prefixSum[startidex];
        }

    }


}
