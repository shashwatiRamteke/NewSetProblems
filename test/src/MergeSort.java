import java.util.ArrayList;

public class MergeSort {
    public static void main(String[] args) {

        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(1);
        arrList.add(3);
        arrList.add(5);

        ArrayList<Integer> arrList2 = new ArrayList<>();
        arrList2.add(2);
        arrList2.add(4);
        arrList2.add(6);
        arrList2.add(0);

        ArrayList mergedArry = Merge(arrList,arrList2);
        mergedArry.stream().forEach(System.out::println);

    }

    static ArrayList<Integer> Merge(ArrayList<Integer> first,ArrayList<Integer> second){
        ArrayList<Integer> mergedArray = new ArrayList<Integer>();
        int i =0;
        int j =0;
        while(i < first.size() && j < second.size()){
            if(first.get(i) < second.get(j)){
                mergedArray.add(first.get(i));
                i++;
            }
            else if(second.get(j) < first.get(i)){
                mergedArray.add(first.get(j));
                j++;
            }
            else
            {
                mergedArray.add(first.get(i));
                mergedArray.add(second.get(j));
                i++;
                j++;
            }
        }
        while (i == first.size() && j < second.size() ){
            mergedArray.add(second.get(i));
            j++;
        }
        while (i < first.size() && j == second.size() ){
            mergedArray.add(second.get(j));
            j++;
        }
        return mergedArray;
    }
}
