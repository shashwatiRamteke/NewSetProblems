package SortingIK;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeKSortedLinkedList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>(Arrays.asList(1, 3, 5)));
        lists.add(new ArrayList<>(Arrays.asList(3, 4)));
        lists.add(new ArrayList<>(Arrays.asList(7)));
        System.out.println(merge_k_lists(lists));

    }

    static ArrayList merge_k_lists(ArrayList<ArrayList<Integer>> lists) {
        // Write your code here.
        ArrayList<Integer> resultList = new ArrayList<>();
        Integer min = Integer.MAX_VALUE;
        while(lists.size() != 1) {
            ArrayList<Integer> l1 = lists.get(0);
            ArrayList<Integer> l2 = lists.get(1);
            resultList = mergetwoLists(l1,l2);
            lists.remove(0);
            lists.remove(0);
            lists.add(resultList);
        }


        return resultList;
    }
    public static  ArrayList<Integer> mergetwoLists(ArrayList<Integer> l1,ArrayList<Integer> l2){

        ArrayList<Integer> mergedList = new ArrayList<>();
        int i=0;
        int j=0;
        while(i < l1.size() && j < l2.size() ){
            if(l1.get(i) < l2.get(j)){
                mergedList.add(l1.get(i));
                i++;
            }else if(l1.get(i) > l2.get(j)){
                mergedList.add(l2.get(j));
                j++;
            }else if(l2.get(j) == l1.get(i))
            {
                mergedList.add(l1.get(i));
                mergedList.add(l2.get(j));
                i++;
                j++;
            }
        }
        while(i < l1.size())
        {
            mergedList.add(l1.get(i));
            i++;
        }
        while(j < l2.size())
        {
            mergedList.add(l2.get(j));
            j++;
        }
        return mergedList;

    }
}
