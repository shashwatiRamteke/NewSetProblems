package HackerRank;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        char[][] matRowCol = new char[grid.size()][grid.size()];
        int j=0;
        for(int i=0;i<grid.size();i++) {
            char[] currString = grid.get(i).toCharArray();
            Arrays.sort(currString);
            matRowCol[j] = currString;
            j++;
        }

        String sortedFlag = "Yes";

        for(int i=0;i<grid.size();i++){
            for(j=0;j<grid.size()-1;j++){
                if(matRowCol[j][i] > matRowCol[j+1][i])
                {
                    sortedFlag = "No";
                }
            }
        }

        return sortedFlag;
    }

}

public class GridSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        int t = Integer.parseInt(bufferedReader.readLine().trim());
        System.out.println(t);

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                            try {
                                return bufferedReader.readLine();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        })
                        .collect(toList());

                String result = Result.gridChallenge(grid);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });*/

        List<String> grid = new ArrayList<String>();
        grid.add("fghij");
        grid.add("ebacd");
        grid.add("olmkn");
        grid.add("trpqs");
        grid.add("xywuv");



        String result = Result.gridChallenge(grid);
        System.out.println(result);

        bufferedReader.close();
        bufferedWriter.close();
    }
}
