package SortingIK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Ksmalldistance {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(5,7,2,3,4,6,1,0,9));
       // int k = 4;
        kSmalldistance(arr, 0, 0, arr.size()-1);
        System.out.print(arr);
    }

    public static void kSmalldistance(ArrayList<Integer> arr, int k, int start, int end){
        if(start>=end){
             return;
        }
        /*if(end <= k){
            for(int i=0;i<k;i++){
                System.out.print(" ");
                System.out.print(arr.get(i));
                System.out.print(" ");
            }
            return;
        }*/

        int pivot = arr.get(start);

        int smallerptr = start;
        int biggerpt = start+1;

        for(biggerpt = start+1;biggerpt<=end; biggerpt++){
            if(arr.get(biggerpt) < pivot){
                smallerptr++;
                Collections.swap(arr,smallerptr,biggerpt);
            }
        }
        Collections.swap(arr,start,smallerptr);
        kSmalldistance( arr, k, start, smallerptr-1);
        kSmalldistance( arr, k, smallerptr+1, end);
    }
}
