import java.util.ArrayList;
import java.util.HashSet;

public class subsetrecursion {
    public static void main(String[] args) {
        ArrayList<String> empty = new ArrayList<>();
        HashSet<String> resultset = new HashSet<>();

        HashSet<String> resultstr = gen_subset("a,b,",2,empty,resultset);
        ArrayList finalresult = new ArrayList<>();
        resultstr.stream().forEach(a -> finalresult.add(a));
        finalresult.stream().forEach(System.out::println);

    }

    public static HashSet<String> gen_subset(String str, Integer n, ArrayList<String> strset, HashSet<String> resultset){
        if(str.length() == 1){
            strset.add("");
            strset.add(str);
            resultset.add("");

            resultset.add(str);
            return resultset;
        }
        else
        {
            HashSet<String> newSet=  gen_subset(str.substring(1,str.length()),n, strset,resultset);
            String firchar = "" + str.charAt(0);
            strset.add(firchar);
            for(String subStr : resultset){
                String tempstr = firchar + subStr;
                strset.add(tempstr);
            }

            for(String subStr1 : strset){
                if(!resultset.contains(subStr1))
                    resultset.add(subStr1);
            }
            return resultset;
        }
    }
}
