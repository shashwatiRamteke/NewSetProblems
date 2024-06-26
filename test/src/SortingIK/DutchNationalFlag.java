package SortingIK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Given some balls of three colors arranged in a line, rearrange them such that all the red balls go first, then green and then blue ones.

Do rearrange the balls in place. A solution that simply counts colors and overwrites the array is not the one we are looking for.

This is an important problem in search algorithms theory proposed by Dutch computer scientist Edsger Dijkstra. Dutch national flag has three colors (albeit different from ones used in this problem).
 {
"balls": ["G", "B", "G", "G", "R", "B", "R", "G"]
}

["R", "R", "G", "G", "G", "G", "B", "B"]
 */
public class DutchNationalFlag {

    public static void main(String[] args) {
       // ArrayList<String> balls = new ArrayList<String>(Arrays.asList("R", "G"));
        //arrangeColorfulBalls(balls);
        ArrayList<Character> balls = new ArrayList<Character>(Arrays.asList('G', 'B', 'G', 'G', 'R', 'B', 'R', 'G'));

        ArrayList<Character> result = dutchflagmine(balls);
        System.out.println(result);
    }
    public static void arrangeColorfulBalls(ArrayList<String> balls){

        int redballpointer =0 ;
        int greenbapointer =0;
        int blueballpointer =0;
        for(int i=0;blueballpointer<balls.size();i++){
            if(balls.get(blueballpointer) == "R"){
                Collections.swap(balls,redballpointer,blueballpointer);
                redballpointer++;
            }
            if(balls.get(blueballpointer) == "G"){
                Collections.swap(balls,greenbapointer,blueballpointer);
                greenbapointer++;
            }
            blueballpointer++;
        }
    }

    static ArrayList<Character> dutch_flag_sort(ArrayList<Character> balls) {
        int red = 0;
        int blue = balls.size() - 1;
        int p = 0;
        while(p <= blue) {
            if(balls.get(p) == 'R') {
                Collections.swap(balls, p, red);
                red++;
            }
            if (balls.get(p) == 'B') {
                Collections.swap(balls, p, blue);
                blue--;
            } else {
                p++;
            }

        }
        return balls;
    }

    static ArrayList<Character> dutchflagmine(ArrayList<Character>balls){
        int r = 0;
        int b = balls.size()-1;
        int g = 0;
        int currentPOtint =0 ;

        while(currentPOtint <= b){
            if(balls.get(currentPOtint) == 'R'){
                Collections.swap(balls,r,currentPOtint);
                r++;
            }
            if(balls.get(currentPOtint) == 'B'){
                Collections.swap(balls,currentPOtint,b);
                b--;
            }
            else {
                currentPOtint++;
            }

        }
        return balls;

    }

}
