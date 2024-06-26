package SortingIK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BCD {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> customerPages = new ArrayList<ArrayList<String>>();

        ArrayList arr1 = new ArrayList(Arrays.asList("T0","C1","A"));
        customerPages.add(arr1);
        ArrayList arr2 = new ArrayList(Arrays.asList("T0","C2","E"));
        customerPages.add(arr2);
        ArrayList arr25 = new ArrayList(Arrays.asList("T1","C1","B"));
        customerPages.add(arr25);
        ArrayList arr3 = new ArrayList(Arrays.asList("T1","C2","B"));
        customerPages.add(arr3);
        ArrayList arr4 = new ArrayList(Arrays.asList("T2","C1","C"));
        customerPages.add(arr4);
        ArrayList arr5 = new ArrayList(Arrays.asList("T2","C2","C"));
        customerPages.add(arr5);
        ArrayList arr6 = new ArrayList(Arrays.asList("T3","C1","D"));
        customerPages.add(arr6);
        ArrayList arr7 = new ArrayList(Arrays.asList("T3","C2","D"));
        customerPages.add(arr7);
        ArrayList arr8 = new ArrayList(Arrays.asList("T4","C1","E"));
        customerPages.add(arr8);
        ArrayList arr9 = new ArrayList(Arrays.asList("T4","C2","A"));
        customerPages.add(arr9);
        System.out.print(mostVistedSeq(customerPages));
    }

    public static String mostVistedSeq( ArrayList<ArrayList<String>> customerPages){

        HashMap<String,ArrayList<String>> customerTopageMap = new HashMap<>();
        for(ArrayList<String> custPage: customerPages){
            if(customerTopageMap.containsKey(custPage.get(1))) {
                ArrayList<String> seq = customerTopageMap.get(custPage.get(1));
                seq.add(custPage.get(2));
                customerTopageMap.put(custPage.get(1),seq);
            }
            else
            {
                ArrayList<String> newSeq = new ArrayList<>();
                newSeq.add(custPage.get(2));
                customerTopageMap.put(custPage.get(1),newSeq);
            }
        }

        HashMap<String,Integer> seqCoutn = new HashMap<>();

        for(Map.Entry<String,ArrayList<String>> customer : customerTopageMap.entrySet()){
           ArrayList<String> listOfPages =  customer.getValue();
           create3PageSeq(listOfPages,seqCoutn);
        }

        int maxCount = 0;
        String maxStringSequence = "";
        for(Map.Entry<String,Integer> seqCount : seqCoutn.entrySet()){
            if(seqCount.getValue() > maxCount){
                maxCount = seqCount.getValue();
                maxStringSequence = seqCount.getKey();
            }
        }
        return maxStringSequence;
    }

    public static void create3PageSeq(ArrayList<String> listOfPages,HashMap<String,Integer> seqCount)
    {
        String seq3String = "";
        for(int i=0,k=0,j=0;i<listOfPages.size();){
            if(k < 3 && j < listOfPages.size()) {
                seq3String = seq3String + " " + listOfPages.get(j);
                k++;
                j++;
            }else{
                k=0;
                i++;
                j=i;
                if(seqCount.containsKey(seq3String))
                {
                    int coutn = seqCount.get(seq3String);
                    coutn++;
                    seqCount.put(seq3String,coutn);
                }
                else {
                    seqCount.put(seq3String, 1);
                }
                seq3String = "";

            }
        }
    }
}
