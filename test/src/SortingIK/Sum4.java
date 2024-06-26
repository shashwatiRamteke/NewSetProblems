package SortingIK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*Given a list of numbers, find all the unique quadruples that sum up to a given target value.

Example
{
"arr": [0, 0, 1, 3, 2, -1],
"target": 3
}*/

public class Sum4 {
    public static void main(String[] args) {
        ArrayList<Integer>  numbers = new ArrayList<Integer>(Arrays.asList(0, 0, 1, 3, 2, -1));
        int sumnumber = 3;
        ArrayList<ArrayList<Integer>> result = four_sum(numbers, sumnumber);
    }
    public static ArrayList<Integer> sum4(ArrayList<Integer> numbers,int sumnumber){
        if(numbers.size() < 4){
            return new ArrayList<>();
        }
        for(int i=0;i<numbers.size();i++){
            int num = numbers.get(i);

        }
        return new ArrayList<>();
    }

        /*
    Asymptotic complexity in terms of the length of input list `n`:
    * Time: O(n^3).
    * Auxiliary space: O(n^3).
    * Total space: O(n^4).
    */

    // This function will return all the distinct pairs in arr[start ... arr.size() - 1]
    // with sum of the values equal to the current_target.
    static ArrayList<ArrayList<Integer>> two_sum(ArrayList<Integer> arr, Integer current_target, Integer start) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int low = start, high = arr.size() - 1;
        while (low < high) {
            if (arr.get(low) + arr.get(high) == current_target) {
                result.add(new ArrayList<>(Arrays.asList(arr.get(low), arr.get(high))));
                low++;
                high--;
            } else if (arr.get(low) + arr.get(high) < current_target) {
                low++;
            } else {
                high--;
            }

            if (low > start) {
                while (low <= high && arr.get(low).equals(arr.get(low - 1))) {
                    low++;
                }
            }

            if (high < arr.size() - 1) {
                while (low <= high && arr.get(high).equals(arr.get(high + 1))) {
                    high--;
                }
            }
        }

        return result;
    }

    // This function will return all the distinct sets of size `k` in `arr[start ... arr.size() - 1]`
    // with sum of the values equal to the `current_target`.
    static ArrayList<ArrayList<Integer>> k_sum(ArrayList<Integer> arr, Integer current_target, Integer start, Integer k) {
        if (start + k > arr.size() || arr.get(start) * k > current_target || arr.get(arr.size() - 1) * k < current_target) {
            return new ArrayList<>();
        }

        if (k == 2) {
            return two_sum(arr, current_target, start);
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = start; i < arr.size(); i++) {
            if (i == start || !arr.get(i).equals(arr.get(i - 1))) {
                ArrayList<ArrayList<Integer>> sub_result = k_sum(arr, current_target - arr.get(i), i + 1, k - 1);

                for (ArrayList<Integer> current : sub_result) {
                    current.add(arr.get(i));
                    result.add(current);
                }
            }
        }

        return result;
    }

    static ArrayList<ArrayList<Integer>> four_sum(ArrayList<Integer> arr, Integer target) {
        Collections.sort(arr);
        return k_sum(arr, target, 0, 4);
    }
}
