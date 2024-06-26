package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberSubSetIinSet {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1,2,3));
        System.out.println(numberofSubset(arr,arr.size()));
    }
    static int numberofSubset(ArrayList arr, int idx){
        if(idx == 1){
            return 2;
        }
        idx = idx - 1;
        return 2 * numberofSubset(arr, idx);
    }
}
