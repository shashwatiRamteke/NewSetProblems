package LeetCode;

public class PermutationOFString {
    public static void main(String[] args) {
       // System.out.println(givenTwoString(str,  str1));
    }

    static boolean givenTwoString(String str, String str1,int i){
        if(i == str.length()){
            if(!str1.contains(str)) {
                return false;
            }
        }
        if(str1.contains(str1))
            return true;
        else
        {
         //   givenTwoString(str.substring(i,str.length()-1)+ str.substring(0,i), str1);
        }
        return true;
    }

}
