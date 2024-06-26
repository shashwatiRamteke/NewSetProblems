package SortingIK;

import java.util.*;

public class FindTopKElements {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 3, 1));
        System.out.println(find_top_k_frequent_elements(arr,2));
    }


    static ArrayList<Integer> find_top_k_frequent_elements(ArrayList<Integer> arr, Integer k) {
        // Write your code here.
        HashMap<Integer,Integer> freqInt = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> freqVisited = new PriorityQueue<Map.Entry<Integer,Integer>>(k, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(o1.getValue() > o2.getValue()) {
                    return -1;
                } else if(o1.getValue() < o2.getValue()) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        });
        for(int i=0;i<arr.size();i++){
            if(freqInt.containsKey(arr.get(i))) {
                int value = freqInt.get(arr.get(i));
                value++;
                freqInt.put(arr.get(i), value);
            }
            else {
                freqInt.put(arr.get(i),1);
            }
        }

        for(Map.Entry<Integer,Integer> keyentry : freqInt.entrySet()) {
            freqVisited.add(keyentry);
        }

        ArrayList<Integer> newList = new ArrayList<>();
        while(!freqVisited.isEmpty() && k > 0){
            newList.add(freqVisited.remove().getKey());
            k--;
        }

        return newList;
    }

}
