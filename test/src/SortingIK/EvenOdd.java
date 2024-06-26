package SortingIK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Given an array of numbers, rearrange them in-place so that even numbers appear before odd ones.
public class EvenOdd {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,2,5,6,7,8,9,3,4));
        evenOdd(numbers);
        System.out.println(numbers);
    }
    public static void evenOdd(ArrayList<Integer> numbers){
        int evenptr = 0;
        int offpointer = 0;
        for(int i=0;i<numbers.size();i++){
            if (numbers.get(offpointer) % 2 == 0){
                Collections.swap(numbers, evenptr, offpointer);
                evenptr++;
            }
            offpointer++;
        }
    }
}
