package Recursion;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PermuteArrayOfUniqueInt {
    public static void main(String[] args) {
        get_permutations2(new ArrayList<>(Arrays.asList(1,2,3)));
    }

    static ArrayList<ArrayList<Integer>> get_permutations(ArrayList<Integer> arr) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> result1 = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        // permuteArrayOfUnique(arr, arr.size(), result);
        permuteArrayOfUniqueBossNoWork2(new ArrayList<Integer>(),arr.size(),arr,result);
        //System.out.println(result1);
        result.stream().forEach(System.out::println);
        return result1;


    }

    static ArrayList<ArrayList<Integer>> permuteArrayOfUnique(ArrayList<Integer> arr, int idx, ArrayList<ArrayList<Integer>>result){
        if(idx == 1){
            ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<arr.size();i++)
            {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(arr.get(i));
                prev.add(temp);
            }
            return prev;
        }
        else {

            ArrayList<ArrayList<Integer>> prev = permuteArrayOfUnique(arr, idx -1, result);
            result = new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<arr.size();i++) {
                for (ArrayList<Integer> temp : prev) {
                    ArrayList<Integer> temp1 = new ArrayList<Integer>();
                    temp1.addAll(temp);
                    temp1.add(arr.get(i));
                    result.add(temp1);
                }
            }
            return result;
        }
    }

    static void permuteArrayOfUniqueBossNoWork(String partial_sol, int n, ArrayList<Integer> arr, ArrayList<String> result){
        if(n == 0){
            result.add(partial_sol);
        }
        else
        {
            for(int i=0;i<=n-1;i++){
                partial_sol = partial_sol + " " + arr.get(i);
                permuteArrayOfUniqueBossNoWork(partial_sol, n-1,arr, result);
                partial_sol = partial_sol;
            }
        }

    }

    static void permuteArrayOfUniqueBossNoWork2(ArrayList<Integer> partial_sol, int n, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> result){
        if(n == 0){
            ArrayList<Integer> partial_sol1 = new ArrayList<>();
            partial_sol1.addAll(partial_sol);
            result.add(partial_sol1);
        }
        else
        {
            for(int i=0;i<n;i++){
                partial_sol.add(arr.get(i));
                permuteArrayOfUniqueBossNoWork2(partial_sol, n-1,arr, result);
                partial_sol.remove(arr.get(i));
            }
        }

    }

    static ArrayList<ArrayList<Integer>> get_permutations2(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        backtrack(arr, 0, ans);
        ans.stream().forEach(System.out::println);
        return ans;
    }

    static void backtrack(ArrayList<Integer> arr, int fixed_index, ArrayList<ArrayList<Integer>> ans) {
        // Base case
        if (fixed_index >= arr.size()) {
            // Create a new copy of arr and add to ans
            ans.add(new ArrayList<>(arr));
            return;
        }

        for (int i = fixed_index; i < arr.size(); i++) { // understant the approach here.
            swap(arr, fixed_index, i);
            // Swap so that you can fix one element and swap rest e.g. fix 0th element swap 1st and 2nd.
            // In subsequent call fix 1st element and call for remaining element 2nd
            // while returning swap elements call 2nd fixed and 1 stable
            // iterate all over again for sencond elem
            backtrack(arr, fixed_index + 1, ans);
            // Re-swap to restore the original arr state
            swap(arr, fixed_index, i);
        }
    }

    static void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }



}