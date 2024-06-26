package SortingIK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class kMostfrequentWord {
    public static void main(String[] args) {

    }

    public static String[]  kmostfreqword(ArrayList<String> dict, int k){
        int[] kmaxcounts = new int[k];
        String [] kmaxvalues = new String[k];

        int currentcounter = 0;
        String currentword = "";
        for(int i=0;i<dict.size();i++){
            if(dict.get(i) != dict.get(i+1)){
                boolean foundmax = false;
                for(int j=0;j<k;j++){
                    if(kmaxcounts[j] < currentcounter && !foundmax){
                        kmaxcounts[j] = currentcounter;
                        kmaxvalues[j] = currentword;
                        foundmax = true;
                    }
                    if(foundmax){
                        if(j+1 < k) {
                            kmaxcounts[j + 1] = kmaxcounts[j];
                            kmaxvalues[j + 1] = kmaxvalues[j];
                        }
                    }
                }
                currentcounter = 0;
                currentword = dict.get(i);
            }else if(dict.get(i) == dict.get(i+1)){
                currentcounter++;
            }
        }
        return kmaxvalues;
    }
}
