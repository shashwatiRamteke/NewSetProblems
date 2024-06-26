package SortingIK;

import java.util.*;

public class KthLargestInStream {
    public static void main(String[] args) {

        ArrayList<Integer> initial_stream = new ArrayList<>(Arrays.asList(4,7));
        ArrayList<Integer> append_stream = new ArrayList<>(Arrays.asList(6, 5, 2, 20));
        int k = 2;
        System.out.println(kth_largest(k, initial_stream, append_stream));
    }

    static ArrayList<Integer> kth_largest(Integer k, ArrayList<Integer> initial_stream, ArrayList<Integer> append_stream) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int j =0;
        for(int i=0;i<initial_stream.size();i++){
            if(j != k){
                minheap.add(initial_stream.get(i));
                j++;
            }
            else
            {
                if(minheap.peek() < initial_stream.get(i)){
                    minheap.remove();
                    j--;
                    minheap.add(initial_stream.get(i));
                    j++;
                }
            }
        }

        ArrayList<Integer> returnlist = new ArrayList<>();
        for (Integer incomingint : append_stream) {
            if(j != k){
                minheap.add(incomingint);
            }
            else {
                if (minheap.peek() < incomingint) {
                    minheap.remove();
                    minheap.add(incomingint);
                }
            }
            if(j==k) {
                returnlist.add(minheap.peek());
            }
        }

        return returnlist;
    }
}
