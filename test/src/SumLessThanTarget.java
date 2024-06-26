import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SumLessThanTarget {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(5, 0, -1, 3, 2));
        int target = 4;
        int countTriplets = count_triplets(4,numbers);
        System.out.println(countTriplets);
    }

    static Integer count_triplets(Integer target, ArrayList<Integer> numbers) {

        Collections.sort(numbers);

        int endpointer = numbers.size();
        int firstStartPtr = 0;
        int secondStartPtr = 1;

        int finalcount = 0;

        for(int i =numbers.size() ; i>=0 ; i--){
            if(numbers.get(i) < target){
                if(numbers.get(endpointer) + numbers.get(endpointer-1) + numbers.get(endpointer-2) < target){
                    finalcount++;
                    endpointer--;
                }
                else
                {
                }
            }else
            {
                endpointer--;
            }
        }
        return 0;
    }



}
