import java.util.ArrayList;

public class InsertionSort {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(13);
        arr.add(34);
        arr.add(5);
        arr.add(42);
        arr.add(2);
        arr.add(3);

        for(int i=0;i<arr.size();i++) {
            int temp = arr.get(i);
            int redIndex = i-1;
            while (redIndex >= 0 && arr.get(redIndex) > temp) {
                arr.set(redIndex+1, arr.get(redIndex));
                redIndex--;
            }
            arr.set(redIndex+1,temp);
        }

        for (int i =0;i <arr.size() ;i++){
            System.out.println(arr.get(i));
        }
    }
}
