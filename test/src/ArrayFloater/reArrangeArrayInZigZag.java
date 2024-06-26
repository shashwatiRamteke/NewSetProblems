package ArrayFloater;

import java.util.Arrays;

public class reArrangeArrayInZigZag {
    public static void main(String[] args) {
        int[] arr = {3,5,2,1,6,4};

        //output coudb be 3,5,2,6,1,4
        makeZigZag(arr);
    }
    static void makeZigZag(int[] arr){

        int currentState = arr[0];
        boolean nextStateless = false;
        for(int i =1;i<arr.length;i++){
            if(nextStateless && currentState > arr[i]){
                nextStateless = false;
                currentState = arr[i];
            }
            else if(!nextStateless && currentState < arr[i]){
                nextStateless = true;
                currentState = arr[i];
            }
            if(nextStateless && currentState < arr[i]){
                int j= i;
                while(arr[j] > currentState){
                    j++;
                }
                swap(arr,j,i);
                nextStateless = false;
                currentState = arr[i];
            } if(!nextStateless && currentState > arr[i]){
                int j= i;
                while(arr[j] < currentState){
                    j++;
                }
                swap(arr,j,i);
                nextStateless = true;
                currentState = arr[i];
            }

        }
        Arrays.stream(arr).forEach(System.out::print);


    }

    static void swap(int[] num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
