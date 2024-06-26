package LeetCode;

import java.util.HashSet;

public class LongestString {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }


    //abcabcbb //dvdf
    //Output: 3
    //Explanation: The answer is "abc", with the length of 3.
    public static int lengthOfLongestSubstring(String s) {
        char[] charArr = s.toCharArray();
        int leftptr =0, rghtptr =1;
        int i = 0, max =0;
        HashSet<Character> letterinStr = new HashSet<>();
        letterinStr.add(charArr[leftptr]);
        while( rghtptr < s.length()){
            if(!letterinStr.contains(charArr[rghtptr])){
                letterinStr.add(charArr[rghtptr]);
                rghtptr++;
            }
            else{
                if(max < letterinStr.size())
                {
                    max = letterinStr.size();
                }
                letterinStr.remove(charArr[leftptr]);
                leftptr++;
                letterinStr.add(charArr[rghtptr]);
                rghtptr++;

            }
        }

        if(max < letterinStr.size())
        {
            max = letterinStr.size();
        }

        return max;
    }

}
