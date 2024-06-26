package HackerRank;

import java.io.*;
import java.util.*;


class Result1 {
    public static int degreeOfArray(List<Integer> arr) {
        HashMap<Integer,Integer> mostfrequentlyused  = new HashMap();
        for(int i=0; i< arr.size();i++){
            if(mostfrequentlyused.containsKey(arr.get(i))) {
                int value = mostfrequentlyused.get(arr.get(i)) + 1;
                mostfrequentlyused.put(arr.get(i), value);
            }
            else
            {
                mostfrequentlyused.put(arr.get(i), 1);
            }
        }

        int Maxuntilnow = 0;
        int MazEntryInt = 0;

        for (Map.Entry<Integer, Integer> currentry : mostfrequentlyused.entrySet()){
            if(Maxuntilnow < currentry.getValue()) {
                Maxuntilnow = currentry.getValue();
                MazEntryInt = currentry.getKey();
            }
        }

        boolean maxEntryAlreadyfound = false;
        int[] shortestsubarr = new int[arr.size()];
        int j = 0;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i) == MazEntryInt || maxEntryAlreadyfound ){
                if(maxEntryAlreadyfound && arr.get(i) == MazEntryInt){
                    shortestsubarr[j] = arr.get(i);
                    maxEntryAlreadyfound = false;
                }
                shortestsubarr[j] = arr.get(i);
                j++;
                if(!maxEntryAlreadyfound){
                    maxEntryAlreadyfound = true;
                }
            }
        }

        return Maxuntilnow;


    }

    public static int degreeofShortestArray(List<Integer> arr) {
        HashMap<Integer,Integer> numberoFShortArr  = new HashMap();
        int minlengthofShortArr = Integer.MAX_VALUE;
        int theminvalue =0;
        for(int i=0; i< arr.size();i++){
            if(numberoFShortArr.containsKey(arr.get(i))) {
                int startindex = numberoFShortArr.get(arr.get(i));
                int currlength = (i - startindex)+1;
                if (theminvalue == arr.get(i)) {
                    minlengthofShortArr = currlength;
                    for(int j=i-1;j>=0;j--){
                        if(numberoFShortArr.containsKey(arr.get(j))){
                            int templength= j - numberoFShortArr.get(arr.get(j));
                            if(templength > 0 && templength < minlengthofShortArr && arr.get(j) != theminvalue){
                                minlengthofShortArr = currlength;
                                theminvalue = arr.get(i);
                            }
                        }
                    }

                }
                else {
                    if (currlength < minlengthofShortArr) {
                        minlengthofShortArr = currlength;
                        theminvalue = arr.get(i);
                    }
                }
            }
            else
            {
                numberoFShortArr.put(arr.get(i), i);
            }
        }
        if(numberoFShortArr.keySet().size() == arr.size())
            minlengthofShortArr = 1;

        return minlengthofShortArr;
    }


}

public class DegreeOfShortestArray {
    public static void main(String[] args) throws IOException {
       // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = 6;

        List<Integer> arr = new ArrayList<>(Arrays.asList(1,1,2,1,2,2));

        int result = Result1.degreeofShortestArray(arr);

        System.out.println(result);
       // bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedReader.close();
        //bufferedWriter.close();
    }
}
