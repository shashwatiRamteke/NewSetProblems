import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeArrayInplace {
    public static void main(String[] args) {
        //ArrayList<Integer> first = new ArrayList<>();
        //ArrayList<Integer> second = new ArrayList<>();
        ArrayList first = new ArrayList<>(Arrays.asList(2));
        ArrayList second = new ArrayList(Arrays.asList(1,0));

        ArrayList mergedAray = MergeArrayInPlc(first,second);
        mergedAray.stream().forEach(System.out::println);
    }

    public static ArrayList MergeArrayInPlc(ArrayList<Integer> first, ArrayList<Integer> second){
        int i=0,j=0;
        for(;i<second.size()&& j<first.size();i++){
            if(first.get(j) <= second.get(i)){
                int shiftindex = second.size()-1;
                while(shiftindex>i){
                    second.set(shiftindex,second.get(shiftindex-1));
                    shiftindex--;
                }
                second.set(i,first.get(j));
                j++;
            }

        }

        i = second.size() - (first.size()-j);

        while(j < first.size()){
            second.set(i,first.get(j));
            i++;
            j++;
        }
        return second;
    }

}
