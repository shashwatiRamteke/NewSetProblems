import java.util.ArrayList;
import java.util.HashSet;

public class findBrackets {

   /* [
            "((()))",
            "(()())",
            "(())()",
            "()(())",
            "()()()"
            ]*/

    public static void main(String[] args) {
        find_all_well_formed_brackets(3); // 3
        ArrayList<String> n = new ArrayList<>();
    }

    static ArrayList<String> find_all_well_formed_brackets(Integer n) {
        HashSet<String> partialset = new HashSet<String>();
        HashSet<String> resultset = new HashSet<String>();
        Integer.parseInt(String.valueOf(n));
        find_all_brackets(n,partialset,resultset);
        ArrayList<String> newStrlst = new ArrayList<>();
        for(String e:resultset) {
            newStrlst.add(e);
        }
        return newStrlst;
    }

    static void find_all_brackets(Integer n, HashSet<String> partialset, HashSet<String> resultset){
        if(n==0)
        {
            partialset.add("()");
            resultset.add("()");
            return;
        }

        find_all_brackets(n-1,  partialset, resultset);

        for(String rescurr : resultset){
            partialset.add(rescurr.concat("()"));
            String tempstr = "(".concat(rescurr).concat(")");
            partialset.add(tempstr);
        }

        for(String strcurr :partialset){
            if(!resultset.contains(strcurr)){
                resultset.add(strcurr);
            }
        }

    }



}
