package SortingIK;

import java.util.ArrayList;

public class AttendMeeting {
    public static void main(String[] args) {

    }
    static boolean can_attend_all_meetings(ArrayList<ArrayList<Integer>> intervals) {
        // Write your code here.

        //[1, 5],
        //[5, 8],
        //[3, 13]
        boolean attendAllMeetngf = true;
        for(int i=0;i<intervals.size()-1;i++){
            ArrayList<Integer> currInterval = intervals.get(i);
            ArrayList<Integer> nextInyerval = intervals.get(i+1);
            if(currInterval.get(1) > nextInyerval.get(0)){
                attendAllMeetngf = false;
            }

        }
        return attendAllMeetngf;

    }

    public static ArrayList<ArrayList<Integer>> insertAandMerge(ArrayList<ArrayList<Integer>> intervals, ArrayList<Integer> newMeeting){
        ArrayList<ArrayList<Integer>> finalList = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<intervals.size()-1;i++){
            ArrayList<Integer> currInterval = intervals.get(i);
            ArrayList<Integer> nextInyerval = intervals.get(i+1);
            if(currInterval.get(1) < newMeeting.get(0) && newMeeting.get(0) > nextInyerval.get(0)){
                if(newMeeting.get(1) > nextInyerval.get(0) && newMeeting.get(1) < nextInyerval.get(1)){
                    ArrayList newNode = new ArrayList<>();
                    newNode.add(newMeeting.get(0));
                    newNode.add(nextInyerval.get(1));
                    finalList.add(newNode);
                }
                else if(newMeeting.get(1) < nextInyerval.get(0)){
                    ArrayList newNode = new ArrayList<>();
                    newNode.add(newMeeting.get(0));
                    newNode.add(newMeeting.get(1));
                    finalList.add(newNode);
                }
            }

        }
        return finalList;
    }
}
