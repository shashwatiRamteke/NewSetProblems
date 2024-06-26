import java.util.*;

public class KtimesWords {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>(Arrays.asList("car", "bus", "taxi", "car", "driver", "candy", "race", "car", "driver", "fare", "taxi"));
        int k = 4;
        var newwords = k_most_frequent(k,words);
        newwords.stream().forEach(System.out::println);
    }

    public static ArrayList<String> k_most_frequent(Integer k, ArrayList<String> words) {

        HashMap<String,Integer> wordMap = new HashMap<String,Integer>();
        words.stream().forEach(a -> {
            if(wordMap.containsKey(a)) {
                int wordCount = wordMap.get(a);
                wordMap.put(a,wordCount+1);
            }
            else
            {
                wordMap.put(a,1);
            }
        });

        /*for(Map.Entry<String,Integer> map : wordMap.entrySet())
        {
            System.out.println(map.getKey() + " " + map.getValue());
        }*/

        SortedSet<Map.Entry<String, Integer>> sortedset = new TreeSet<Map.Entry<String, Integer>>(
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> e1,
                                       Map.Entry<String, Integer> e2) {
                        int compint = e2.getValue().compareTo(e1.getValue());

                        if (compint != 0) {
                            return compint;
                        }
                        return e1.getKey().compareTo(e2.getKey());
                    }
                });

        sortedset.addAll(wordMap.entrySet());

        //sortedset.stream().forEach(System.out::println);

        ArrayList<String> mostFrequentWords = new ArrayList<String>();
        int i =0;
        for(Map.Entry<String,Integer> word : sortedset){
            if(i < k)
                mostFrequentWords.add(word.getKey());
            i++;
        }

        return  mostFrequentWords;
    }

}
