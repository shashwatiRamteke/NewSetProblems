import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {

    public static void main(String[] args) {


        ArrayList<Integer> A = new ArrayList<>();
        A.add(13);
        A.add(34);
        A.add(5);
        A.add(42);
        A.add(2);
        A.add(3);


        int n = A.size();
        for(int i=0; i < n; i++){
            for(int j=n-1;j>=i+1;j--){
                if(A.get(j-1) > A.get(j))
                {
                    Collections.swap(A, j-1, j);
                }
            }
            
        }
        
        for(int i =0;i<n;i++){
            System.out.println(A.get(i));
        }

    }

}
