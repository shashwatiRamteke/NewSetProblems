public class Fibonnaci {
    public static void main(String[] args) {
        Integer n = 6;
        System.out.println(find_fibonacci(n));
    }


    static Integer find_fibonacci(Integer n) {

        Integer[] arr = new Integer[n+1];
        arr[0] =0;
        arr[1] = 1;
        for(int i=2;i<=n;i++){
            arr[i] = arr[i-1] + arr[i -2];
        }
        return arr[n];
    }

}
