package SortingIK;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        lists.add(new ArrayList<Integer>(Arrays.asList(1,2,3)));
        lists.add(new ArrayList<Integer>(Arrays.asList(4,5,6)));
        lists.add(new ArrayList<Integer>(Arrays.asList(7,8,9)));
        lists.add(new ArrayList<Integer>(Arrays.asList(11,23,45)));
        lists.add(new ArrayList<Integer>(Arrays.asList(12,30,46)));
        lists.add(new ArrayList<Integer>(Arrays.asList(13,45,50)));
        lists.add(new ArrayList<Integer>(Arrays.asList(16,77,85)));


        //System.out.println(mergeKList(lists,4));
        System.out.print(mergeKListWithHeap(lists,7));
    }

    public static ArrayList<Integer> mergeKListWithHeap(ArrayList<ArrayList<Integer>> sortedList, int k)
    {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for(int i=0;i<k;i++){
            ArrayList<Integer> currentList = sortedList.get(i);
            for(int j=0;j<currentList.size();j++){
                heap.add(currentList.get(j));
            }
        }

        ArrayList<Integer> resultedSortedList = new ArrayList<Integer>();
        while(!heap.isEmpty())
        {
            resultedSortedList.add(heap.remove());
        }

        return resultedSortedList;
    }

    public static ArrayList<Integer> mergeKList(ArrayList<ArrayList<Integer>> lists, int k){
        if(k == 2){
            return merge2lists(lists.get(k-1), lists.get(k-2));
        }
        ArrayList<Integer> resultlist = mergeKList(lists, k-1);
        return merge2lists(resultlist,lists.get(k-1));
    }

    public static ArrayList<Integer> merge2lists(ArrayList<Integer> list1, ArrayList<Integer> list2){
        ArrayList<Integer> resultList = new ArrayList<>();

        int i =0;
        int j =0;
        while(i< list1.size() && j < list2.size()){
            if(list1.get(i) < list2.get(j)){
                resultList.add(list1.get(i));
                i++;
            }else if(list1.get(i) > list2.get(j)){
                resultList.add(list2.get(j));
                j++;
            }else {
                resultList.add(list1.get(i));
                resultList.add(list2.get(j));
                i++;
                j++;
            }
        }

        while(i < list1.size()){
            resultList.add(list1.get(i));
            i++;
        }

        while(j < list2.size()){
            resultList.add(list2.get(j));
            j++;
        }

        return resultList;
    }

    /*
     Priority queue solution if the list is likedlistnode lists
    * Asymptotic complexity in terms of total length of all given linked lists `n` and `k`:
    * Time: O(n * log(k)).
    * Auxiliary space: O(1).
    * Total space: O(n + k).


    static class pair implements Comparable<pair> {
        int value, index;

        public pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(pair o) {
            // TODO Auto-generated method stub
            return this.value - o.value;
        }
    }

    static LinkedListNode merge_k_lists(ArrayList<LinkedListNode> lists) {
        LinkedListNode head = null;
        LinkedListNode tail = null;

        PriorityQueue<pair> pq = new PriorityQueue<>();

        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                pq.add(new pair(lists.get(i).value, i));
            }
        }

        int min_index;
        while (pq.isEmpty() == false) {
            min_index = pq.peek().index;
            pq.poll();

            if (head == null) {
                head = lists.get(min_index);
                tail = lists.get(min_index);
            } else {
                tail.next = lists.get(min_index);
                tail = tail.next;
            }

            lists.set(min_index, lists.get(min_index).next);
            tail.next = null;

            if (lists.get(min_index) != null) {
                pq.add(new pair(lists.get(min_index).value, min_index));
            }
        }
        return head;
    }
     */
}
