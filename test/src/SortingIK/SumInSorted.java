package SortingIK;

import java.util.ArrayList;
import java.util.Arrays;

public class SumInSorted {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 10));
        Integer target = 7;

        pair_sum_sorted_array(numbers,target);
    }


    static ArrayList<Integer> pair_sum_sorted_array(ArrayList<Integer> numbers, Integer target) {

        ArrayList<Integer> result = new ArrayList<>();
        int start=0; int end=numbers.size()-1;
        while( start < end) {
            if(numbers.get(start) + numbers.get(end) > target) {
                end--;
            } else if(numbers.get(start) + numbers.get(end) < target) {
                start++;
            } else {
                result.add(start);
                result.add(end);
                return result;
            }
        }

        result.add(-1);
        result.add(-1);

        return new ArrayList();
    }
}
