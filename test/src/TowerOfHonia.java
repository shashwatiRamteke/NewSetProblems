import java.util.ArrayList;
import java.util.Arrays;

public class TowerOfHonia {

    public static void main(String[] args) {
        int numOfDisks = 3;
        ArrayList<ArrayList<Integer>> sets = new ArrayList<>();
        numOfHonia(3,1,2,3,sets);
        sets.stream().forEach(System.out::println);

    }

    public static void numOfHonia(int numOfDisks, int src, int dest, int aux, ArrayList<ArrayList<Integer>> sets){
        if(numOfDisks == 0){
            return;
        }
        if(numOfDisks == 1){
            System.out.format("Moved from %d to %d \n", src ,dest);
            sets.add(new ArrayList(Arrays.asList(src,dest)));
        }
        else{
            numOfHonia(numOfDisks-1,src,aux,dest,sets); // remember to never put direct numbers in recursion.
            System.out.format("Moved from %d to %d \n", src ,dest);
            sets.add(new ArrayList(Arrays.asList(src,dest)));
            numOfHonia(numOfDisks-1,aux,dest,src,sets);
        }

    }

}


