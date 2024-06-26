package ArrayFloater;

import java.util.Arrays;
import java.util.Collections;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {3,0,1};

        missingNumber(arr);

        /*for(int i=0;i<arr.length;i++){
            if(arr[i] != i){
                int destination = arr[i];
                if(destination < arr.length) {
                    swap(arr, i, destination);
                }
                else {
                    swap(arr,i, arr.length-1);
                }
            }
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i] != i){
                System.out.println(i);
            }
        }*/
    }

    static void swap(int[] num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void missingNumber(int[] arr){
        for(int i=0;i<arr.length;i++){
            while(arr[i] != i){
                int destination = arr[i];
                if(destination < arr.length){
                    swap(arr,i,destination);
                }
                else
                {
                    break;
                }
            }
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i]!=i){
                System.out.println(i);
            }
        }

    }
}
