package HackerRank;

public class MinMaxCalculated {
     public static void main(String[] args) {
        int[] arr = {1,3,5,7,9};
        int min = 0;
        int max = Integer.MAX_VALUE;

        int sumOfAll = 0;
        for(int i=0;i<arr.length;i++){
            sumOfAll +=  arr[i];
        }
        for(int i=0;i<arr.length;i++){
            int temp = sumOfAll - arr[i];
            if(max < temp){
                max=temp;
            }
            if(min > temp)
            {
                min = temp;
            }
        }
        System.out.println(min  + " " + max);
    }
}
