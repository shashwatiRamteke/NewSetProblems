package LeetCode;

import java.security.Key;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharacterReplacement {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        int k = 1;

        String t = "ABC";
        System.out.println(minWindow2(s,t));
    }

    //Input: s = "AABABBA", k = 1
    //Output: 4
    //Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
    //The substring "BBBB" has the longest repeating letters, which is 4.
    //There may exists other ways to achieve this answer too.

    public static int characterReplacement(String s, int k) {
        char[] sCharArr = s.toCharArray();
        int leftptr = 0, rightptr = 1, max =0;
        int count = 1;
        HashMap<Character,Integer> charMap = new HashMap<>();
        charMap.put(sCharArr[leftptr],0);

        int currk = k;
        while(rightptr < s.length()){
            if(sCharArr[leftptr] == sCharArr[rightptr])
            {
                rightptr++;
                count++;
            }
            else if(sCharArr[leftptr] != sCharArr[rightptr]){
                if(currk == 0) {

                    if(max < count){
                        max = count;
                    }
                    count =1;
                    currk = k;
                    for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
                        Character key = entry.getKey();
                        Integer value = entry.getValue();
                        if(value > leftptr && key != sCharArr[leftptr]){
                            leftptr = value;
                            break;
                        }
                    }
                }
                else {
                    currk--;
                    count++;
                    charMap.put(sCharArr[rightptr],rightptr);
                    rightptr++;
                }

            }
        }
        if(max < count){
            max = count;
        }
        return max;
    }

    public static int characterReplacement2(String s, int k){
        HashMap<Character,Integer> charCount = new HashMap<>();
        char[] sArr =  s.toCharArray();
        int left =0;
        int maxlength = 1, res = 1;
        int charWithMax = 0;
        for(int right=0;right<s.length();right++){
            if(charCount.containsKey(sArr[right])){
                int value = charCount.get(sArr[right]);
                value++;
                charCount.put(sArr[right],value);
                charWithMax = Math.max(charWithMax, value);
            }
            else
            {
                charCount.put(sArr[right],1);
                charWithMax = Math.max(charWithMax, 1);
            }

            if ((right - left + 1) - charWithMax <= k){
               maxlength = Math.max(maxlength,right-left+1);
            }

            if(right - left + 1 -charWithMax > k){
                int value = charCount.get(sArr[left]);
                value--;
                charCount.put(sArr[left],value);
                left++;
            }
        }
        return maxlength;
    }

    public static String minWindow(String s, String t) {

        HashMap<Character,Integer> alltChar = new HashMap<>();
        HashMap<Character,Integer> original = new HashMap<>();

        char[] tArr = t.toCharArray();
        int minwindow = Integer.MAX_VALUE;
        for(int i =0;i<t.length();i++)
        {
            if(alltChar.containsKey(tArr[i])){
                int value = alltChar.get(tArr[i]);
                value++;
                alltChar.put(tArr[i],value);
                original.put(tArr[i],value);
            }else{
                alltChar.put(tArr[i],1);
                original.put(tArr[i],1);
            }
        }
        char[] sArr = s.toCharArray();
        int left=0,right =0;
        boolean foundfirstCahr = false;
        String minString = "";
        for(;right < s.length();){
            if(!alltChar.isEmpty()) {
                if (alltChar.containsKey(sArr[right])) {
                    int value = alltChar.get(sArr[right]);
                    value--;
                    if (value == 0) {
                        alltChar.remove(sArr[right]);
                    } else {
                        alltChar.put(sArr[right], value);
                    }
                    foundfirstCahr = true;
                }else if(!foundfirstCahr){
                    left++;
                }
                right++;
            }else{
                if(minwindow > (right-left)) {
                    minwindow = right - left;
                    minString = s.substring(left,right);
                }
                alltChar.put(sArr[left],1);
                left++;
                while(!original.containsKey(sArr[left])){
                    left++;
                }
                //foundfirstCahr = false;
                /*for (Map.Entry<Character, Integer> entry : original.entrySet()) {
                    Character k = entry.getKey();
                    Integer v = entry.getValue();
                    alltChar.put(k, v);
                }*/
            }
        }

        if(alltChar.isEmpty()){
            if(minwindow > (right-left)) {
                minwindow = right - left;
                minString = s.substring(left,right);
            }
        }
        return minString;
    }

    public static String minWindow2(String s, String t) {

        int l=0,r=0,minLen=Integer.MAX_VALUE,c=0,si=-1;
        Map<Character,Integer> hm = new HashMap();
        while(r<t.length())
        {
            hm.put(t.charAt(r),hm.getOrDefault(t.charAt(r),0)+1);r++;
        }r=0;

        while(r<s.length())
        {
            if(hm.getOrDefault(s.charAt(r),0) > 0) c++;
            hm.put(s.charAt(r),hm.getOrDefault(s.charAt(r),0)-1);

            while(c==t.length())
            {
                if(r-l+1 <minLen)
                {
                    minLen = r-l+1;si=l;
                }
                hm.put(s.charAt(l),hm.get(s.charAt(l))+1);
                if(hm.get(s.charAt(l))>0) c--;
                l++;
            }
            r++;
        }

        return si==-1? "" : s.substring(si,si+minLen);
    }

}
