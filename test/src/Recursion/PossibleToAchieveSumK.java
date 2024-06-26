package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class PossibleToAchieveSumK {
    public static void main(String[] args) {

        ArrayList<Long> test = new ArrayList<Long>(Arrays.asList(2L,4L,6L));
        System.out.println(check_if_sum_possible(test, 2L));
    }

    static Boolean check_if_sum_possible(ArrayList<Long> arr, Long k) {
        HashSet<Long> resultset = new HashSet<Long>();
        HashSet<Long> partialset = new HashSet<Long>();
        findallSubset(arr, arr.size() - 1, 0, partialset, resultset);

        for (Long s : resultset) {
            System.out.println(String.valueOf(s));
        }

        for (Long currset : resultset) {
            if (String.valueOf(currset).equals(String.valueOf(k))) {
                return true;
            }
        }
        return false;
    }

    static void findallSubset(ArrayList<Long> arr, int n, int i, HashSet<Long> newSet, HashSet<Long> resultset) {
        if (i == n) {
            newSet.add(arr.get(i));
        } else {
            findallSubset(arr, n, i + 1, newSet, resultset);
            Long curri = arr.get(i);
            newSet.add(curri);
            for (Long tempvalue : newSet) {
                if (!resultset.contains(tempvalue + curri)) {
                    resultset.add(tempvalue + curri);
                }
                if (!resultset.contains(tempvalue)) {
                    resultset.add(tempvalue);
                }
            }

        }
    }
}