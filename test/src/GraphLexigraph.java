import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class GraphLexigraph {

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList("baa", "abcd", "abca", "cab", "cad","cefg","cefk","kom"));
        System.out.println(find_order(words));
    }

    static String find_order(ArrayList<String> words) {
        String finalchar = "";
        HashMap<Character,String> wordMap = new HashMap<>();
        for(int i =0;i < words.size()-1;i++)
        {
            char[] currword = words.get(i).toCharArray();
            char[] nextword = words.get(i+1).toCharArray();
            int j =0,k=0;
            while(currword[j] == nextword[k] && j < currword.length && k < nextword.length ) {
                j++;
                k++;
            }
            if(j < currword.length && k < nextword.length) {
                if(!finalchar.contains(String.valueOf(currword[j]))) {
                    finalchar = finalchar + String.valueOf(currword[j]);
                }
            }
        }

        char[] currword = words.get(words.size()-1).toCharArray();
        int j =0;
        while(j < currword.length){
            if(!finalchar.contains(String.valueOf(currword[j]))) {
                finalchar = finalchar + String.valueOf(currword[j]);
            }
            j++;
        }

        return finalchar;
    }

}
