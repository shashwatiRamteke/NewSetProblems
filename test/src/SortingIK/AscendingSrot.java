package SortingIK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AscendingSrot {
    //"a", "s", "d", "f", "g", "*", "&", "!", "z", "y
    public static void main(String[] args) {
        ArrayList<Character> charList = new ArrayList<Character>(Arrays.asList('a', 's', 'd', 'f', 'g', '*', '&', '!', 'z', 'y'));
        ArrayList<Character> sortedlist = mergeSort(charList, 0,charList.size()-1);
        System.out.print(sortedlist);
    }

    public static ArrayList<Character> ascSort(ArrayList<Character> charList){

        Collections.sort(charList);
        System.out.print(charList);



        return new ArrayList<Character>();
    }

    public static ArrayList<Character> mergeSort(ArrayList<Character> charList, int start, int end){

        if(start >= end){
            return new ArrayList<>(
                    Arrays.asList(charList.get(start))
            );
        }
        if(Math.abs(start-end)==1) {
           return merge(new ArrayList<>(Arrays.asList(charList.get(start))), new ArrayList<>(Arrays.asList(charList.get(end))));
        }
            int middle = start + (end - start) / 2;
            ArrayList<Character> sortedlist1 = mergeSort(charList, start, middle-1);
            ArrayList<Character> sortedlist2 = mergeSort(charList, middle , end);

            ArrayList<Character> sortedList = merge(sortedlist1, sortedlist2);

            return sortedList;
    }
    public static ArrayList<Character> merge(ArrayList<Character> sortedlist1, ArrayList<Character> sortedlist2){
        ArrayList<Character> resultedlsit = new ArrayList<>();
        int i=0,j=0;
        for(;i<sortedlist1.size() && j<sortedlist2.size();){
            if(sortedlist1.get(i) < sortedlist2.get(j)){
                resultedlsit.add(sortedlist1.get(i));
                i++;
            } else if(sortedlist1.get(i) > sortedlist2.get(j)){
                resultedlsit.add(sortedlist2.get(j));
                j++;
            } else {
                resultedlsit.add(sortedlist1.get(i));
                resultedlsit.add(sortedlist2.get(j));
                i++;
                j++;

            }
        }

        while(i<sortedlist1.size()){
            resultedlsit.add(sortedlist1.get(i));
            i++;
        }
        while(j<sortedlist2.size()){
            resultedlsit.add(sortedlist2.get(j));
            j++;
        }

        return resultedlsit;

    }


}
