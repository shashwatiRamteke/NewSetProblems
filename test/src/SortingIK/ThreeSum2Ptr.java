package SortingIK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class ThreeSum2Ptr {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(10, 3, -4, 1, -6, 9));
        int sum = 0;
        /*ArrayList<ArrayList<Integer>> result = ThreeSum(arr,sum);
        for (ArrayList<Integer> item : result) {
            System.out.println(item);
        }*/
        System.out.print(find_zero_sum(arr));
    }

    // two pointer approach to increment from both side
    public static ArrayList<ArrayList<Integer>> ThreeSum(ArrayList<Integer> arr, Integer sum){
        int left = 1;
        int right = arr.size()-1;
        int currentElement =0;
        ArrayList<ArrayList<Integer>> arrResult = new ArrayList<ArrayList<Integer>>();
        Collections.sort(arr);
        while(left < right){
            if(arr.get(left) + arr.get(right)  + arr.get(currentElement) < sum){
                left++;
                currentElement++;
            }else if(arr.get(left) + arr.get(right)+ arr.get(currentElement) > sum){
                right--;
            }else if(arr.get(left) + arr.get(right) + arr.get(currentElement) == sum){
                ArrayList<Integer> temparr = new ArrayList<>();
                temparr.add(arr.get(left));
                temparr.add(arr.get(right));
                temparr.add(arr.get(currentElement));
                arrResult.add(temparr);
                left++;
                currentElement++;
            }
        }
        String temp = arr.get(left).toString() + " "   + " " +  arr.get(currentElement).toString() + arr.get(right).toString();

        return arrResult;
    }


    static ArrayList<String> find_zero_sum(ArrayList<Integer> numbers) {
        // Write your code here.
        int left = 1;
        int right = numbers.size()-1;
        int currentElement =0;
        int sum = 0;
        HashSet<String> arrResult = new HashSet<String>();
        Collections.sort(numbers);
        for(currentElement=0;currentElement<numbers.size();currentElement++){
            left = currentElement + 1;
            right = numbers.size() - 1;

            while(left < right){
                if(numbers.get(left) + numbers.get(right)  + numbers.get(currentElement) < sum){
                    left++;
                }else if(numbers.get(left) + numbers.get(right)+ numbers.get(currentElement) > sum){
                    right--;
                }else if(numbers.get(left) + numbers.get(right) + numbers.get(currentElement) == sum){
                /*ArrayList<Integer> temparr = new ArrayList<>();
                temparr.add(numbers.get(left));
                temparr.add(numbers.get(right));
                temparr.add(numbers.get(currentElement));*/
                    String temp = numbers.get(currentElement).toString() + "," + numbers.get(left).toString() + ","  + numbers.get(right).toString();
                    arrResult.add(temp);
                    left++;
                }
            }
        }

        return new ArrayList<>(arrResult);

    }

}
