package SortingIK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class AttendAllMeetings {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> intervals = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> interval = new ArrayList<>(Arrays.asList(1, 5));
        intervals.add(interval);
        interval = new ArrayList<>(Arrays.asList(10, 15));
        intervals.add(interval);
        interval = new ArrayList<>(Arrays.asList(5, 8));
        intervals.add(interval);
        /*interval = new ArrayList<>(Arrays.asList(2, 4));
        intervals.add(interval);
        interval = new ArrayList<>(Arrays.asList(6, 7));
        intervals.add(interval);
        System.out.println(intervals);*/

        System.out.print(can_attend_all_meetings(intervals));
    }

    static Integer can_attend_all_meetings(ArrayList<ArrayList<Integer>> intervals) {
        Collections.sort(intervals, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
        System.out.println(intervals);
        boolean overlap = false;
        for(int i=0;i<intervals.size()-1;i++){
            if(intervals.get(i).get(1) > intervals.get(i+1).get(0)){
                overlap = true;
            }
        }
        if(overlap)
            return 1;
        else
            return 0;
    }


}
