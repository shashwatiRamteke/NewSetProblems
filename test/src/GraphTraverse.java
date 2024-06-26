import javax.naming.InsufficientResourcesException;
import java.util.*;

public class GraphTraverse {
    public static void main(String[] args) {

        HashSet<Integer> visted = new HashSet<>();

        HashMap<Integer,ArrayList> adjMap = new HashMap<>();
        adjMap.put(0,new ArrayList<>(Arrays.asList(1,2)));
        adjMap.put(1,new ArrayList<>(Arrays.asList(0,2,3,4)));
        adjMap.put(2,new ArrayList<>(Arrays.asList(1,0)));
        adjMap.put(3,new ArrayList<>(Arrays.asList(1)));
        adjMap.put(4,new ArrayList<>(Arrays.asList(1)));

        Integer num__cc = 0;
        for(Integer key : adjMap.keySet()){
            if(!visted.contains(key)){
                num__cc++;
                BFSgraph(adjMap,visted);
            }
        }

        System.out.println("Number of connected grapdh are, " + num__cc);

    }

    public static void BFSgraph(HashMap<Integer,ArrayList> adjMarp,HashSet<Integer> visted){

        visted.add(adjMarp.keySet().iterator().next());

        Queue bfsqueu = new LinkedList<Integer>();
        bfsqueu.add(adjMarp.keySet().iterator().next());
        while(!bfsqueu.isEmpty()){
            Integer topque = (Integer) bfsqueu.remove();
            ArrayList<Integer> edges = adjMarp.get(topque);
            for(Integer edge : edges ) {
                if (!visted.contains(edge)) {
                    bfsqueu.add(edge);
                    visted.add(edge);
                }
            }
        }
        return;
    }

    public static boolean BFSgraphWithCirle(HashMap<Integer,ArrayList> adjMarp,HashSet<Integer> visted){

        visted.add(adjMarp.keySet().iterator().next());
        boolean containsCycle = false;

        Queue bfsqueu = new LinkedList<Integer>();
        bfsqueu.add(adjMarp.keySet().iterator().next());
        Integer level =0;

        while(!bfsqueu.isEmpty()){
            Integer topque = (Integer) bfsqueu.remove();
            ArrayList<Integer> edges = adjMarp.get(topque);
            level++;
            for(Integer edge : edges ) {
                if(visted.contains(edge)){
                    if(edge != topque){
                        containsCycle = true;
                    }
                }
                else if (!visted.contains(edge)) {
                    bfsqueu.add(edge);
                    visted.add(edge);
                }

            }
        }
        return containsCycle;
    }

    public static boolean DFSgraphWithCirle(HashMap<Integer,ArrayList> adjMarp,HashSet<Integer> visted){

        visted.add(adjMarp.keySet().iterator().next());
        boolean containsCycle = false;

        Queue bfsqueu = new LinkedList<Integer>();
        bfsqueu.add(adjMarp.keySet().iterator().next());
        while(!bfsqueu.isEmpty()){
            Integer topque = (Integer) bfsqueu.remove();
            ArrayList<Integer> edges = adjMarp.get(topque);
            for(Integer edge : edges ) {
                if(visted.contains(edge)){
                    if(edge != topque){
                        containsCycle = true;
                    }
                }
                else if (!visted.contains(edge)) {
                    bfsqueu.add(edge);
                    visted.add(edge);
                }

            }
        }
        return containsCycle;
    }

    public static boolean BFSgraphCirleWithCrossEdge(HashMap<Integer,ArrayList> adjMarp,HashSet<Integer> visted,Integer start){
        boolean is_biparte = true;
        visted.add(adjMarp.keySet().iterator().next());
        HashMap came_from = new HashMap();
        HashMap<Integer,Integer> level = new HashMap<Integer,Integer>();
        level.put(start,0);
        Queue bfsqueu = new LinkedList<Integer>();
        bfsqueu.add(adjMarp.keySet().iterator().next());
        while(!bfsqueu.isEmpty()){
            Integer topque = (Integer) bfsqueu.remove();
            ArrayList<Integer> edges = adjMarp.get(topque);
            for(Integer edge : edges ) {
                if (!visted.contains(edge)) {
                    bfsqueu.add(edge);
                    visted.add(edge);
                    came_from.put(edge,topque);
                    level.put(edge,level.get(topque) + 1);
                }
                else if(visted.contains(edge)){
                    if(came_from.get(topque) != edge && level.get(topque) == level.get(edge)){
                        is_biparte = false;
                    }
                }
            }
        }
        return is_biparte;
    }
}

