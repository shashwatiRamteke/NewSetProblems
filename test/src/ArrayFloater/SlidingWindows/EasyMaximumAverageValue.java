package ArrayFloater.SlidingWindows;

import java.util.LinkedList;
import java.util.Queue;

public class EasyMaximumAverageValue {
    public static void main(String[] args) {
        int[] newInt = {1,10,3,5};
        System.out.println(maxAverageValue(newInt,3));
    }

    public static int maxAverageValue(int[] stream, int noOfelement)
    {
        int StartIndex = 0;
        int EndIndex = 1;
        int sumuptilnoow = 0;
        Queue<Integer> q1 = new LinkedList<>();
        int average = 0;
        int maxaverage = 0;
        for(int i=0;i<stream.length;i++){
            if((EndIndex - StartIndex) <= noOfelement) {
                sumuptilnoow += stream[i];
                average = sumuptilnoow / (EndIndex - StartIndex);
                if(maxaverage < average){
                    maxaverage = average;
                }
                //System.out.println(sumuptilnoow / (EndIndex - StartIndex));
                EndIndex++;
            }
            if((EndIndex - StartIndex) > noOfelement){
                sumuptilnoow -= stream[StartIndex];
                StartIndex++;
                average = sumuptilnoow/(EndIndex-StartIndex);
                if(maxaverage < average){
                    maxaverage = average;
                }
                //System.out.println(sumuptilnoow/(EndIndex-StartIndex));
                EndIndex++;

            }

        }
        return maxaverage;
    }
}
