package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EdgeListgraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edgeToList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arrL1 = new ArrayList<>(Arrays.asList(0,1));
        edgeToList.add(arrL1);
        ArrayList<Integer> arrL2 = new ArrayList<>(Arrays.asList(1,2));
        edgeToList.add(arrL2);

        ArrayList<Integer> arrL3 = new ArrayList<>(Arrays.asList(1,4));
        edgeToList.add(arrL3);

        ArrayList<Integer> arrL4 = new ArrayList<>(Arrays.asList(1,3));
        edgeToList.add(arrL4);

        ArrayList<Integer> arrL5 = new ArrayList<>(Arrays.asList(1,2));
        edgeToList.add(arrL5);

        ArrayList<Integer> arrL6 = new ArrayList<>(Arrays.asList(3,4));
        edgeToList.add(arrL6);



        ArrayList<ArrayList<Integer>> resultstr = convertEdgeToList(edgeToList,6);

        System.out.println(resultstr);
    }

    public static ArrayList<ArrayList<Integer>> convertEdgeToList(ArrayList<ArrayList<Integer>> edgeToList, int n){

        HashMap<Integer,ArrayList<Integer>> newList = new HashMap<>();
        for(ArrayList<Integer> list : edgeToList){
            if(newList.containsKey(list.get(0))){
                ArrayList valuesList =  newList.get(list.get(0));
                valuesList.add(list.get(1));
            }
            else {
                newList.put(list.get(0), new ArrayList<Integer>(Arrays.asList(list.get(1))));
            }
            if(newList.containsKey(list.get(1))){
                ArrayList valuesList =  newList.get(list.get(1));
                valuesList.add(list.get(0));
            } else {
                newList.put(list.get(1), new ArrayList<Integer>(Arrays.asList(list.get(0))));
            }
        }

        ArrayList<ArrayList<Integer>> resultarr = new ArrayList<ArrayList<Integer>>();

        for(int i =0;i<n;i++){
            if(newList.containsKey(i)) {
                resultarr.add(newList.get(i));
            }
        }

        return resultarr;


    }
}
