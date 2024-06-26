import java.util.ArrayList;
import java.util.Arrays;

public class BinaryString {
    public static void main(String[] args) {
        int n = 4;
        /*ArrayList<ArrayList<String>> result = binaryStringSetOfN(n);
        result.stream().forEach(System.out::println);*/
        ArrayList<String> resultArr = new ArrayList<>();
        binarystr(resultArr,n);

    }

    public static ArrayList<ArrayList<String>> binaryStringSetOfN(Integer n){

        if(n==1){
            ArrayList<ArrayList<String>> es = new ArrayList<ArrayList<String>>();
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("0","1"));
            es.add(arrayList);
            return es;
        }
        else {
            ArrayList<ArrayList<String>> prev = binaryStringSetOfN(n-1);
            ArrayList<String> preArraylist = prev.get(0);
            ArrayList<String> newArraylist = new ArrayList<>();
            for(String subset : preArraylist){
                newArraylist.add("0".concat(subset));
                newArraylist.add("1".concat(subset));
            }
            ArrayList<ArrayList<String>> newSetList = new ArrayList<ArrayList<String>>();
            newSetList.add(newArraylist);
            return newSetList;
        }
    }

    public static void binarystr(ArrayList<String> strarr,int n){
        if(n==1){

            strarr.stream().forEach(System.out::println);
        }
        else
        {
            ArrayList<String> arrlist = new ArrayList<>();
            if(strarr.isEmpty())
            {
                arrlist.add("0");
            }
            else {
                for (String str : strarr) {
                    arrlist.add(str + '0');
                }
            }



            binarystr(arrlist,n-1);
            ArrayList<String> arrlist1 = new ArrayList<>();

            if(strarr.isEmpty())
            {
                arrlist1.add("1");
            }
            else {
                for (String str : strarr) {
                    arrlist1.add(str + '1');
                }
            }
            binarystr(arrlist1,n-1);

        }
    }
}
