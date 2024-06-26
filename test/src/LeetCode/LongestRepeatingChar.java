package LeetCode;

import javax.swing.text.html.HTMLDocument;
import java.util.LinkedList;
import java.util.Queue;
public class LongestRepeatingChar {
/*    public static void main(String[] args) {

    }

    static void LongestRepeatingCharReplacement(String str, int k){
        Queue<Character> queueseq = new LinkedList<>(); //ABAB // AABABBAA (MAxfreq + K  < lengthOfstr)
        String currentSubstr = "";

        for(int i =0;i<str.length();i++){
            if(!queueseq.contains(str.charAt(i))) {
                queueseq.add(str.charAt(i));
            }else{
                if(maxstring.contains(str.charAt(i)))
                {
                    maxstring = maxstring + str.charAt(i);
                }

                while (queueseq.peek() == str.charAt(i)) {
                        char topchar  = queueseq.remove(); //AA
                        if(topchar==str.charAt(i)) {
                            localstring = localstring + queueseq.remove();
                        }
                        else {
                            if(k > 0) {
                                queueseq.remove();
                                k--;

                                localstring = localstring + str.charAt(i); //AA
                            }
                        }

                    }
                }
                if(maxstring.length() < localstring.length) {
                    maxstring = localstring; // BBB
                }
            }
        }




    }

    static void LongestCHarRepeat(Strign str) {
        Queue<Character> queueseq = new LinkedList<>();
        String currentSubstr = "";
        while(i < str.length()) {
            if (!queueseq.contains(str.charAt(i))) {
                queueseq.add(str.charAt(i));
            } else {

                while (queueseq.peek() == str.charAt(i)) {
                    localstring = localstring + queueseq.remove();
                }
                if (maxString.length() < localstring.length) {
                    maxstrign = localstring;
                }
                queueseq.add(str.charAt[i]);
            }
        }

        while (queueseq.peek() == str.charAt(i)) {
            localstring = localstring + queueseq.remove();
        }
        if (maxString.length() < localstring.length) {
            maxstrign = localstring;
        }

    }
    }*/
}
