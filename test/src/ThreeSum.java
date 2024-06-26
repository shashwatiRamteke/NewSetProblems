import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ThreeSum {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(11,3,-6,-5,7));

        ArrayList arr = threesum(numbers);
        arr.stream().forEach(System.out::println);
    }

    public static ArrayList<String> threesum(ArrayList<Integer> numbers){
        ArrayList<String> newsTriplet = new ArrayList<>();

        for(int i =0;i<numbers.size();i++){
            for(int j=i+1;j<numbers.size();j++){
                for(int k=j+1;k<numbers.size();k++){
                    int sum = numbers.get(i) + numbers.get(j) + numbers.get(k);
                    if(sum == 0){
                        newsTriplet.add(numbers.get(i).toString() + "" + numbers.get(j).toString()  + "" + numbers.get(k).toString());

                    }
                }
            }
        }
        return newsTriplet;
    }
}