import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class noEmptySet {
    public static void main(String[] args) {
        ArrayList<Long> inout = new ArrayList<Long>(Arrays.asList(2L,4L,8L));


        Long k = 6L;
        String.valueOf(k);
        check_if_sum_possible(inout,k);

        //check_if_sum_possible2(inout,k,idx,cursum);
    }

    static void check_if_sum_possible2(ArrayList<String> inout,int k,int idx,Long cursum){

    }


    static Boolean check_if_sum_possible(ArrayList<Long> arr, Long k) {
        HashSet<Long> resultset = new HashSet<Long>();
        HashSet<Long> partialset = new HashSet<Long>();
        findallSubset(arr,arr.size()-1,0,partialset,resultset);
        for(Long currset : resultset){
            if(currset == k){
                return true;
            }
        }
        return false;
    }

    static void findallSubset(ArrayList<Long> arr, int n,int i, HashSet<Long> newSet, HashSet<Long> resultset ) {
        if (i == n) {
            newSet.add(arr.get(i));
        } else {
            findallSubset(arr, n, i + 1, newSet,resultset);
            Long curri = arr.get(i);
            newSet.add(curri);
            for (Long tempvalue : newSet) {
                if(!resultset.contains(tempvalue + curri)) {
                    resultset.add(tempvalue + curri);
                }
                if(!resultset.contains(tempvalue))
                {
                    resultset.add(tempvalue);
                }
            }

        }
    }



}
