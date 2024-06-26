import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SegregateEvenAndOdd {
    public static void main(String[] args) {
        List<Integer> arrList = Arrays.asList(4,3,8,7,6,1,2);
        segregate(arrList);

        arrList.stream().forEach(System.out::println);
    }
    public static void segregate(List<Integer> arr){
        int evenptr = 0;
        int oddptr = 1;
        for(oddptr = 1; oddptr < arr.size();oddptr++)
        {
            if(arr.get(oddptr)%2 == 0){
                evenptr++;
                Collections.swap(arr,evenptr,oddptr);
            }
        }
    }
}
