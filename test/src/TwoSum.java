import java.lang.annotation.Target;
import java.util.HashSet;

public class TwoSum {
    public static void main(String[] args) {
        int[] Arr = {1,2,4,5,6};
        int target = 12;
        System.out.println(TwoSumBruteForce(Arr,target));
        System.out.println(TwoSumHashSet(Arr,target));

    }

    public static boolean TwoSumBruteForce(int[] Arr, int target)
    {
        for(int i=0;i<Arr.length;i++)
        {
            for(int j=0;j<Arr.length-1;j++){
                if(target - Arr[i]==Arr[j]){
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    public static boolean TwoSumHashSet(int[] Arr, int target){
        HashSet<Integer> h1 = new HashSet<>();
        for(int i=0;i<Arr.length;i++){
            h1.add(Arr[i]);
        }
        for(int i=0;i<Arr.length;i++){
            if(h1.contains(target-Arr[i]) && Arr[i] != target-Arr[i])
            {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public static boolean TwoSumSortedArray(int[] Arr, int target){
        for(int i =0;i<Arr.length;i++) {
            if (binarySearch(Arr, target, 0, Arr.length))
                return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static boolean binarySearch(int[] Arr, int target, int low, int high){
        while(low<high){
            int mid = (low + high) /2;
            if(Arr[mid] == target)
            {
                return Boolean.TRUE;
            }
            else if(Arr[mid] > target){
                high = mid - 1;
            }
            else
            {
                low= mid +1;
            }
        }
        return false;
    }

    public static boolean TwoSumTwoPointer(int[] Arr, int target){

        int i = 0;
        int j = Arr.length;

        while(i<j){
            if(Arr[i]+Arr[j] == target){
                return Boolean.TRUE;
            }
            if(Arr[i]+Arr[j]>target)
            {
                j--;
            }
            else if(Arr[i]+Arr[j]<target)
            {
                i++;
            }
        }
        return false;
    }
}
