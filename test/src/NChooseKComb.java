import java.util.ArrayList;
import java.util.Arrays;

public class NChooseKComb {

    public static void main(String[] args) {
        find_combinations(5,2);
    }

    static ArrayList<ArrayList<Integer>> find_combinations(Integer n, Integer k) {
        // Write your code here.
        //findComb(n,k,idx);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        findComb(n,k,1,arr);
      return arr;
    }

    static void findComb(Integer n,Integer k,Integer idx , ArrayList<ArrayList<Integer>> arr){
        if(idx == n){
            arr.add(new ArrayList<>(Arrays.asList(idx,n)));
            System.out.println(" "+ idx + " " + n );
            return;
        }
        else
        {
            arr.add(new ArrayList<>(Arrays.asList(idx,n)));
            System.out.println(" "+ idx + " " + n );
            findComb(n-1, k, idx, arr);
            idx++;
            findComb(n-1,k,idx,arr);
        }

    }

}
