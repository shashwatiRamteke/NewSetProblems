package SortingIK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Quicksort {
    public static void main(String[] args) {
        List<Integer> arrList = Arrays.asList(4,3,8,7,6,1,2);
        quicksort(arrList,0,arrList.size()-1);

        arrList.stream().forEach(System.out::println);
    }

    public static void quicksrot(List<Integer> arr, int start, int end){
        if(start >= end){
            return;
        }

        int pivot = arr.get(start);
        int smallerptr = start;
        int biggerptr = start + 1;
        for(biggerptr = start + 1; biggerptr < arr.size();biggerptr++)
        {
            if(arr.get(biggerptr) < pivot){
                smallerptr++;
                Collections.swap(arr,smallerptr,biggerptr);
            }
        }
        Collections.swap(arr,start,smallerptr);

        quicksrot(arr,start,smallerptr-1);
        quicksrot(arr,smallerptr+1,end);
    }

    public static void partition(List<Integer> arr){
        int pivot = arr.get(0);
        int smallerptr = 0;
        int biggerptr = 1;
        for(biggerptr = 1; biggerptr < arr.size();biggerptr++)
        {
            if(arr.get(biggerptr) < pivot){
                smallerptr++;
                Collections.swap(arr,smallerptr,biggerptr);
            }
        }
        Collections.swap(arr,0,smallerptr);
    }

    public static void quicksort(List<Integer> arr, int start, int end){
        if(start >= end){
            return;
        }

        int pivot = arr.get(start);

       int smallerptr = start;
       int biggerpt = start+1;
       for(biggerpt=start+1;biggerpt<=end;biggerpt++){
          if(arr.get(biggerpt) < pivot){
              smallerptr++;
              Collections.swap(arr,smallerptr,biggerpt);
          }
       }
       Collections.swap(arr,start,smallerptr);
        quicksort(arr,start,smallerptr-1);
        quicksrot(arr,smallerptr+1,end);
    }
}
