public class test {
    public static void main(String[] args) {
        boolean nptpal = true;

        String inputString = "hlbeeykoqqqqokyeeblh";
        if (inputString.length() == 2){
            if(inputString.charAt(0) != inputString.charAt(1))
            {
                nptpal = false;
            }
        }
        if(inputString.length() > 2) {
            int midchar = inputString.length() / 2;
            char[] charArr = inputString.toCharArray();
            int left = midchar - 1;
            int right = 0;
            if(inputString.length() % 2 == 0)
             right = midchar;
            else
                right = midchar + 1;
            while (right < inputString.length()) {

                if (charArr[left] != charArr[right]) {
                    nptpal = false;
                }
                left--;
                right++;


            }
        }
    }
}
