package HackerRank;
import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;


class Result2 {

    /*
     * Complete the 'minFolders' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER cssFiles
     *  2. INTEGER jsFiles
     *  3. INTEGER readMeFiles
     *  4. INTEGER capacity
     */

    public static int minFolders(int cssFiles, int jsFiles, int readMeFiles, int capacity) {
        // Write your code here
        if(readMeFiles > cssFiles + jsFiles + 1){
            System.out.println("Error total files are 2 many");
            return 0;
        }
        int numberOfFOlders = readMeFiles;

        HashMap<Integer,Integer> folders = new HashMap<>();
        for(int k =1;k<numberOfFOlders;k++)
        {
            folders.put(k,1);
        }

        for(int i =1;i<numberOfFOlders;i++){
            Integer numfilesInFolder = folders.get(i);
            if(numfilesInFolder != capacity) {
                for (int j = 1; j < capacity; j++) {
                    if(cssFiles > 0) {
                        cssFiles--;
                        numfilesInFolder++;
                    }
                    else if(jsFiles > 0){
                        jsFiles--;
                        numfilesInFolder++;
                    }
                }
                folders.put(i,numfilesInFolder);
            }
        }


        if((cssFiles+ jsFiles) > 0){
            int addedfolder = cssFiles + jsFiles/capacity;
            if(addedfolder == 0){
                addedfolder = 1;
            }
            numberOfFOlders = numberOfFOlders + addedfolder;
        }

        return numberOfFOlders;
    }

}

public class Minfolder {
    public static void main(String[] args) throws IOException {



        int cssFiles = 0;

        int jsFiles =13;

        int readMeFiles = 7;

        int capacity =5;

        int result = Result2.minFolders(cssFiles, jsFiles, readMeFiles, capacity);

       System.out.println(String.valueOf(result));

    }
}
