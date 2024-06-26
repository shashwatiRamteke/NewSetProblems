import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;

public class Nofqueen {
    public static void main(String[] args) {

        // in initiL CALL i = n-4
        //find_all_arrangements(16,12, 16); // send values as n and n minus 4
        find_all_arrangements2(8).stream().forEach(System.out::println);

    }

    public static  void find_all_arrangements(Integer n, int i, int lenghofboard) {
        if (n < 4) {
            System.out.println(" " + " ");
        } else {
            find_all_arrangements(n - 4, i - 4, lenghofboard);
            int j = 2;
            for (int k = 0; k < i + j; k++)
                System.out.print("_ ");
            System.out.print("q ");
            for (int k = i + j + 1; k < lenghofboard; k++)
                System.out.print("_ ");
            System.out.println("");


            j = 0;
            for (int k = 0; k < i + j; k++)
                System.out.print("_ ");
            System.out.print("q ");
            for (int k = i + j + 1; k < lenghofboard; k++)
                System.out.print("_ ");
            System.out.println("");

            j = 3;
            for (int k = 0; k < i + j; k++)
                System.out.print("_ ");
            System.out.print("q ");
            for (int k = i + j + 1; k < lenghofboard; k++)
                System.out.print("_ ");
            System.out.println("");

            j = 1;
            for (int k = 0; k < i + j; k++)
                System.out.print("_ ");
            System.out.print("q ");
            for (int k = i + j + 1; k < lenghofboard; k++)
                System.out.print("_ ");
            System.out.println("");


        }
    }

    public static ArrayList<ArrayList<String>> find_all_arrangements2(Integer n){

        if(n==2){
            ArrayList<String> empty = new ArrayList<String>();
            empty.add("_" + "_");
            empty.add("_" + "_");
            ArrayList<ArrayList<String>> prevarr = new ArrayList<ArrayList<String>>();
            prevarr.add(empty);
            return prevarr;
        }
        else
        {
           ArrayList<ArrayList<String>> allqincol = getAllCombinationsn(n,n);

           return allqincol;


        }
    }

    public static ArrayList<ArrayList<String>> getAllCombinationsn(Integer n, Integer len) {
        if(n==1) {
            ArrayList<String> endString = new ArrayList<>(Arrays.asList("q","_"));
            ArrayList<ArrayList<String>> returnlst = new ArrayList<ArrayList<String>>();
            returnlst.add(endString);
            return  returnlst;

        }
        else {
            ArrayList<ArrayList<String>> prevList = getAllCombinationsn(n-1,n);
            ArrayList<String> subset = prevList.get(0);
            ArrayList<String> newArrayStr = new ArrayList<>();
            for(String str : subset) {

                if(str.contains("q")) {
                    newArrayStr.add("_".concat(str));
                }
                else {
                    newArrayStr.add("q".concat(str));

                    if(n!=len)
                        newArrayStr.add("_".concat(str));
                }
            }
            ArrayList<ArrayList<String>> qineachcol = new ArrayList<ArrayList<String>>();
            qineachcol.add(newArrayStr);
            return qineachcol;
        }

    }





}

