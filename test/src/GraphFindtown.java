import java.util.ArrayList;
import java.util.HashMap;

public class GraphFindtown {

    public static void main(String[] args) {

    }

   /* {
        "n": 4,
            "trust": [
[1, 4],
[2, 4],
[3, 4]
]
    }*/

    static Integer find_town_judge(Integer n, ArrayList<ArrayList<Integer>> trust) {

        HashMap<Integer,ArrayList<Integer>> adjmap = new HashMap();
        for(ArrayList<Integer> arrlst : trust){

            adjmap.put(arrlst.get(1),new ArrayList<Integer>());



        }

        // Write your code here.
        return 0;
    }

    static ArrayList<ArrayList<Integer>> convert_edge_list_to_adjacency_list(Integer n, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        return new ArrayList();
    }


}
