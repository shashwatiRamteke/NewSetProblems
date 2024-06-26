package DynamicProgramming;

public class LongestCommonSubsequent {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "adc";
        char[] chartext1 = text1.toCharArray();
        char[] chartext2 = text2.toCharArray();
        System.out.println(longestCommonSubsequence(chartext1, chartext2,  0,  0));
    }

    public static int longestCommonSubsequence(char[] chartext1, char[] chartext2, int i, int j){
        if(i == chartext1.length || j == chartext2.length){
            return 0;
        }
        else
        {
            if(chartext1[i] == chartext2[j]) {
                return 1 + longestCommonSubsequence(chartext1, chartext2, i+1, j+1);
            }
            else{
                return Math.max(longestCommonSubsequence(chartext1,chartext2,i+1,j), longestCommonSubsequence(chartext1,chartext2,i,j+1));
            }
        }
    }
}
