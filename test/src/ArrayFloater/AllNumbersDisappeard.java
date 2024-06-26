package ArrayFloater;

import java.util.Arrays;

public class AllNumbersDisappeard {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        disappeardNumbers(arr);
    }

    static void disappeardNumbers(int[] arr){
        for(int i=0,j=1;i<arr.length;i++,j++){
            while(arr[i] != j){
                int destination = arr[i];
                if(destination <= arr.length && arr[destination-1] != arr[i]){
                    swap(arr,i,destination-1);
                }
                else
                {
                    break;
                }
            }
        }

        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("Missing number");
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=i+1){
                System.out.println(arr[i]);
            }
        }
    }

    static void swap(int[] num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
