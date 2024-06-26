package Tree;

import com.sun.source.tree.Tree;

import java.awt.*;
import java.util.*;
import java.util.List;

public class TreeExecution {

    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public TreeNode root;

    public TreeExecution(int value){
            root = new TreeNode(value);
    }

    public void addToTree(int value){
        if(root == null){
            TreeNode newNode = new TreeNode(value);
            root = newNode;
        }
        else
        {
            TreeNode temp = root;
            TreeNode newNode = new TreeNode(value);
            boolean nodePlaced = false;

            while(!nodePlaced){
                if(temp.value < value && temp.right != null){
                    temp = temp.right;
                }else if(temp.value > value && temp.left != null){
                    temp = temp.left;
                }else if(temp.value < value && temp.right == null){
                    temp.right = newNode;
                    nodePlaced = true;
                }else if (temp.value > value && temp.left == null){
                    temp.left = newNode;
                    nodePlaced = true;
                }
            }
        }
    }

    public void inorder(TreeNode root1){
        if(root1 == null)
            return;
        inorder(root1.left);
        System.out.println(root1.value);
        inorder(root1.right);
    }

    public int diameterOfTree(TreeNode root1, int globalCurrdiameter){
        if(root1 == null)
            return 0;
        else {
            int currdiameter= 0;
            int leftheight = 0;
            int rightheight = 0;
            if(root1.left!= null) {
                leftheight = diameterOfTree(root1.left,globalCurrdiameter);
                currdiameter += leftheight + 1;
            }
            if(root1.right != null){
                rightheight = diameterOfTree(root1.right,globalCurrdiameter);
                currdiameter +=  rightheight + 1;
            }
            if(globalCurrdiameter > currdiameter)
            {
                globalCurrdiameter = currdiameter;
            }
            return Math.max(leftheight,rightheight) + 1;
        }
    }

    public boolean isBST(TreeNode root, TreeNode [] prev){
        if (root == null) return true;
        if (!isBST(root.left, prev)) return false;

        if (prev[0] != null && prev[0].value > root.value) return false;

        prev[0] = root;

        return isBST(root.right, prev);
    }



    public boolean pathSum(TreeNode root1, int sum, int valuestillnow){
        if(root1==null){
            return false;
        }
        if((root1.left == null && root1.right == null) && (valuestillnow - root1.value) == 0 ){
            return true;
        }
        boolean leftfound = pathSum(root1.left, sum, valuestillnow - root1.value);
        boolean rightfound = pathSum(root1.right, sum, valuestillnow - root1.value);
        if(leftfound || rightfound){
            return true;
        }
        else {
            return false;
        }

    }

    public boolean pathAllSum(TreeNode root1, int sum, int valuestillnow, ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path){
        if(root1==null){
             return false;
        }
        if((root1.left == null && root1.right == null) && (valuestillnow - root1.value) == 0 ){
            path.add(root1.value);
            paths.add(new ArrayList<>(path));
            path.remove(Integer.valueOf(root1.value));
            return true;
        }
        path.add(root1.value);
        boolean leftfound = pathAllSum(root1.left, sum, valuestillnow - root1.value,paths,path);
        boolean rightfound = pathAllSum(root1.right, sum, valuestillnow - root1.value,paths,path);
        path.remove(Integer.valueOf(root1.value));
        if(leftfound || rightfound){
            return true;
        }
        else {
            return false;
        }

    }

    public void LowestCommonAncestor(TreeNode root1, HashMap<Integer,Boolean> visited, ArrayList<TreeNode> parentNode){
        if(root1 == null)
            return;
        LowestCommonAncestor(root1.left, visited,parentNode);
        if(root1.left!= null && visited.containsKey(root1.left.value)){
            if(!visited.get(root1.left.value)){
                visited.put(root1.left.value,true);
            }
        }
        LowestCommonAncestor(root1.right,visited,parentNode);
        if(root1.right!=null && visited.containsKey(root1.right.value)){
            if(!visited.get(root1.right.value)){
                visited.put(root1.right.value,true);
            }
        }


        Boolean allValueSet = Boolean.TRUE;
        for(Boolean curr : visited.values()){
            if(!curr){
                allValueSet = false;
            }
        }

        if(allValueSet){
            parentNode.add(root1);
            for(Map.Entry<Integer,Boolean> curr : visited.entrySet()){
                visited.put(curr.getKey(),Boolean.FALSE);
            }
        }

    }

    public void allParentOfNode(ArrayList<TreeNode> listofParents, TreeNode root1, HashMap<Integer, Boolean> nodeTOFind){
        if(root1 == null){
            return;
        }
        if(root1.value == this.root.value){
            Integer key = nodeTOFind.keySet().stream().findFirst().get();
            if(nodeTOFind.get(key)) {
                listofParents.add(root1);
                return;
            }
        }

        if(nodeTOFind.containsKey(root1.value)){
            nodeTOFind.put(root1.value,true);
        }else {
            Integer key = nodeTOFind.keySet().stream().findFirst().get();
            if(!nodeTOFind.get(key)) {
                allParentOfNode(listofParents, root1.left, nodeTOFind);
            }
            if(!nodeTOFind.get(key)) {
                allParentOfNode(listofParents, root1.right, nodeTOFind);
            }
            if(nodeTOFind.get(key)) {
                listofParents.add(root1);
            }
        }
    }

    public List<Integer> breathFirstSearch(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        else
        {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            ArrayList<Integer> ListOfLevels = new ArrayList<>();

            while(!queue.isEmpty()){
                TreeNode currNode = queue.remove();
                ListOfLevels.add(currNode.value);
                if(currNode.left != null){
                    queue.add(currNode.left);
                }
                if(currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            return ListOfLevels;
        }
    }

    public TreeExecution invertTree(TreeNode root1){
        if(root1 == null){
            return null;
        }
        else
        {

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            Queue<TreeNode> newQueue = new LinkedList<TreeNode>();
            queue.add(root1);
            TreeExecution tree2 = new TreeExecution(root1.value);
            TreeNode tempTraversal = tree2.root;
            newQueue.add(tempTraversal);

            ArrayList<Integer> ListOfLevels = new ArrayList<>();
            while(!queue.isEmpty()) {
                int n = queue.size();
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    TreeNode currNode = queue.remove();
                    tempTraversal = newQueue.remove();
                    temp.add(currNode.value);
                    if (currNode.right != null) {
                        queue.add(currNode.right);
                        tempTraversal.left = new TreeNode(currNode.right.value);
                        newQueue.add(tempTraversal.left);
                    }
                    if (currNode.left != null) {
                        queue.add(currNode.left);
                        tempTraversal.right = new TreeNode(currNode.left.value);
                        newQueue.add(tempTraversal.right);

                    }
                }
            }
            return tree2;
        }
    }

    public List<Integer> rightSideView(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        else
        {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            ArrayList<Integer> ListOfLevels = new ArrayList<>();

            while(!queue.isEmpty()){
                int n = queue.size();
                ArrayList<Integer> temp = new ArrayList<>();

                for(int i=0;i<n;i++) {
                    TreeNode currNode = queue.remove();
                    temp.add(currNode.value);
                    if (currNode.right != null) {
                        queue.add(currNode.right);
                    }
                    if (currNode.left != null) {
                        queue.add(currNode.left);
                    }
                }
                ListOfLevels.add(temp.get(0));
            }
            return ListOfLevels;
        }
    }



    public static void main(String[] args) {

        TreeExecution tree1 = new TreeExecution(19);
        tree1.addToTree(10);
        tree1.addToTree(4);
        tree1.addToTree(15);
        tree1.addToTree(5);
        tree1.addToTree(12);
        tree1.addToTree(17);
        tree1.addToTree(25);
        tree1.addToTree(20);
        tree1.addToTree(45);

        tree1.inorder(tree1.root);
        /*(HashMap<Integer,Boolean> kv = new HashMap<>();
        kv.put(4,false);
        kv.put(5,false);
        ArrayList<TreeNode> parentNode = new ArrayList<>();
        //tree1.LowestCommonAncestor(tree1.root,kv,parentNode );
        //System.out.println("curre node "+ parentNode.get(0).value);*/

        /*ArrayList<TreeNode> listofParents = new ArrayList<>();

        HashMap<Integer, Boolean> nodeTOFind = new HashMap<>();
        nodeTOFind.put(5,false);

        tree1.allParentOfNode(listofParents, tree1.root, nodeTOFind);
        System.out.println(" Printing parents");
        listofParents.stream().forEach(a -> System.out.println(a.value));*/

        /*List<Integer> t1 = tree1.rightSideView(tree1.root);
        System.out.println("Printing Breadth First List");
        System.out.println(t1);*/

        //System.out.println(tree1.pathSum(tree1.root,38,38));

        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<>();
        System.out.println(tree1.pathAllSum(tree1.root,38,38,paths, path));
        paths.stream().forEach(System.out::println);

        /*TreeExecution treeReverted = tree1.invertTree(tree1.root);
        System.out.println(treeReverted.breathFirstSearch(treeReverted.root));

        System.out.println(tree1.breathFirstSearch(tree1.root));*/


    }




}
