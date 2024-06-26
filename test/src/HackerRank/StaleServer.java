package HackerRank;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

class Result4 {

        /*
         * Complete the 'getStaleServerCount' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts following parameters:
         *  1. INTEGER n
         *  2. 2D_INTEGER_ARRAY log_data
         *  3. INTEGER_ARRAY query
         *  4. INTEGER X
         */

        public static List<Integer> getStaleServerCount(int n, ArrayList<ArrayList<Integer>> log_data, List<Integer> query, int X) {
            // Write your code here
            int m = log_data.size();
            HashMap<Integer,HashSet<Integer>> noOFServerRec = new HashMap<Integer,HashSet<Integer>>();

            for(int i=0;i<query.size();i++){
                int[] newRange = new int[2];
                newRange[0] = query.get(i) - X;
                newRange[1] = query.get(i);

                HashSet<Integer> noOfServerLst = new HashSet<>();

                for(int k=0;k<m;k++){
                    List<Integer> currentServer = log_data.get(k);
                    if(currentServer.get(1) >= newRange[0] && currentServer.get(1) <= newRange[1]){
                        noOfServerLst.add(currentServer.get(0));
                    }
                }
                noOFServerRec.put(i,noOfServerLst);

            }

            ArrayList<Integer> finalList = new ArrayList<>();
            for(int i=0;i<query.size();i++){
                HashSet<Integer> noOFserverAdded = noOFServerRec.get(i);

                finalList.add(n - noOFserverAdded.size());
            }
            return finalList;
        }

    }

    public class StaleServer {
        public static void main(String[] args) throws IOException {
            //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = 4;

            int log_dataRows = 4; //m
            int log_dataColumns = 2; // logdata columne

            ArrayList<ArrayList<Integer>> tolist = new ArrayList<>();
            //ArrayList<Integer> integerArrayListst = new ArrayList<Integer>();

            for(int i=0;i<=3;i++) {
                ArrayList<Integer> integerArrayListst = new ArrayList<Integer>();
                if (i == 0){
                    integerArrayListst.add(1);
                    integerArrayListst.add(3);
                }
                if(i==1) {
                    integerArrayListst.add(2);
                    integerArrayListst.add(6);
                }
                if(i==2) {
                    integerArrayListst.add(1);
                    integerArrayListst.add(5);
                }
                if(i==3) {
                    integerArrayListst.add(3);
                    integerArrayListst.add(4);
                }
                tolist.add(integerArrayListst);
            }


            ArrayList<ArrayList<Integer>> log_data = tolist;



            int queryCount = 3;

            List<Integer> query = new ArrayList<Integer>(Arrays.asList(10,6));

            int X = 5;

            List<Integer> result = Result4.getStaleServerCount(n, log_data, query, X);

            System.out.println(result);

            /*bufferedWriter.write(
                    result.stream()
                            .map(Object::toString)
                            .collect(joining("\n"))
                            + "\n"
            );

            bufferedReader.close();
            bufferedWriter.close();*/
        }
    }


