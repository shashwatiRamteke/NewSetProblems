import java.util.Scanner;

public class SelectionSort {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        int[] arr = new int[10];
        for(int i =0; i < 10; i++) {
            System.out.println("Enter next number");
            int n = myObj.nextInt();
            arr[i] = n;
        }

        System.out.println("Printing existing number list");
        for(int i =0;i<10;i++){
            System.out.println(arr[i]);
        }

        for(int i=0;i<10;i++){
            int maxNumberIteration = 0;
            int swapIndex = 0;
            for(int j=0;j<10-i;j++){
                if(arr[j] > maxNumberIteration){
                    maxNumberIteration = arr[j];
                    swapIndex = j;
                }
            }

            int len = arr.length;
            if(swapIndex != (len-1-i)){
                int temp = arr[swapIndex];
                arr[swapIndex] = arr[len-1-i];
                arr[10-i] = temp;
            }
        }

        System.out.println("Printing sorted number list");
        for(int i =0;i<10;i++){
            System.out.println(arr[i]);
        }


    }


}
