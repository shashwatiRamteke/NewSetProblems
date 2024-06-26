package ArrayFloater;

public class SecondGreatest {
    public static void main(String[] args) {
        int[] arr = {2,4,6,7,3,1,6,9};
        System.out.println(secondGreated(arr, 0, 0, 0));
    }

    public static int secondGreated(int[] arr, int maxIndex, int secondindex, int currindex){
        if (currindex >= arr.length)
            return secondindex;

        if(arr[maxIndex] < arr[currindex])
        {
            secondindex = maxIndex;
            maxIndex = currindex;

        }
        else if(arr[currindex] < arr[maxIndex] && arr[currindex] > arr[secondindex])
        {
            secondindex = currindex;
        }
        return secondGreated(arr, maxIndex, secondindex,  currindex+1);
    }
}
