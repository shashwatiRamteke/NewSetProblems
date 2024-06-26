package ArrayFloater.SlidingWindows;

import java.lang.reflect.GenericDeclaration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Given a stream of data find the moving averge of k size.
// MovingAverage m = MovingAverage(3)
//m.next(1) = 1
//m.next(10) = 1 + 10/2
// m.next(3) = 1+10+3 /2
//m.next (5) = 10+3+5/2
public class EasyFirstSLidingWindow {
    public static void main(String[] args) {
        int[] newInt = {1,10,3,5};
        movingAveragw(newInt,3);
    }

    public static void movingAveragw(int[] stream, int noOfelement)
    {
        int StartIndex = 0;
        int EndIndex = 1;
        int sumuptilnoow = 0;
        Queue<Integer> q1 = new LinkedList<>();
        int average = 0;
        for(int i=0;i<stream.length;i++){
            if((EndIndex - StartIndex) <= noOfelement) {
                sumuptilnoow += stream[i];
                if(EndIndex-StartIndex == 0){
                    System.out.println(sumuptilnoow);
                }
                else {
                    average = sumuptilnoow / (EndIndex - StartIndex);
                    System.out.println(sumuptilnoow / (EndIndex - StartIndex));
                }
                EndIndex++;
            }
            if((EndIndex - StartIndex) > noOfelement){
                sumuptilnoow -= stream[StartIndex];
                StartIndex++;
                average = sumuptilnoow/(EndIndex-StartIndex);
                System.out.println(sumuptilnoow/(EndIndex-StartIndex));
                EndIndex++;

            }

        }
    }
}
