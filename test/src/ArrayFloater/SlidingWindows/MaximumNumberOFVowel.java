package ArrayFloater.SlidingWindows;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumNumberOFVowel {
    public static void main(String[] args) {
        System.out.println(maximumNumberOfVowelInAnySubstring("shashwati", 3));
    }

    public static int maximumNumberOfVowelInAnySubstring(String str, int k){
        int max = 0;
        ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a','e','i','o','u','s'));
        char[] strArray = str.toCharArray();
        int vowelsInCurrString = 0;
        int maxVowelsInKlengthString = 0;
        char[] strUntilNow = new char[strArray.length];

        for(int i=0;i<k;i++){
            if(vowels.contains(strArray[i])){
                vowelsInCurrString++;
            }
        }

        if(maxVowelsInKlengthString < vowelsInCurrString){
            maxVowelsInKlengthString = vowelsInCurrString;
        }

        for(int i=k;i<strArray.length;i++){
            if(vowels.contains(strArray[i])) {
                vowelsInCurrString++;
            }
            if(vowels.contains(strArray[i-k])) {
                vowelsInCurrString--;
            }
            strUntilNow[i] = strArray[i];
            if(maxVowelsInKlengthString < vowelsInCurrString){
                maxVowelsInKlengthString = vowelsInCurrString;
            }
        }
        return maxVowelsInKlengthString;
    }
}
