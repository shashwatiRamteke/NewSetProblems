import java.util.*;

public class BinarySearchTree {

    TreeNode root;


    TreeNode defaultTree(){

        ArrayList<Integer> arrInt = new ArrayList<>(Arrays.asList(15,13,12,14,18,11,17,10,5,4,16,19));
        for(int i=0; i<arrInt.size();i++){
            int valuetemp = arrInt.get(i);
            if(this.root == null){
                this.root = new TreeNode(valuetemp);
            }
            else {
                addTotree(root, valuetemp);
            }
        }

        return root;
    }

    TreeNode defaultBSTree(){

        ArrayList<Integer> arrInt = new ArrayList<>(Arrays.asList(8, 10, 12, 15, 16, 20, 25));

        TreeNode finalbst = defaultBSTHelper(arrInt,0,arrInt.size()-1);

        return finalbst;
    }

    TreeNode defaultBSTHelper(ArrayList<Integer> arr, int start, int end)
    {
        if(start > end){
            return null;
        }

        int mid = start + (end - start)/2;
        TreeNode temproot = new TreeNode(arr.get(mid));
        temproot.left = defaultBSTHelper(arr,start, mid-1);
        temproot.right = defaultBSTHelper(arr,mid+1,end);
        return temproot;
    }

    TreeNode constructTree(){

        String flag = String.valueOf('N');
        do {
            System.out.println("Input node value");
            Scanner input = new Scanner(System.in);
            int value = input.nextInt();
            if(this.root == null){
                this.root = new TreeNode(value);
            }
            else {
                addTotree(root, value);
            }
            System.out.println("Do you still want to add more ? Y/N");
            flag = input.next();
        }while(flag.toUpperCase().equals("Y"));

        return root;
    }

    public void addTotree(TreeNode root, int value){
        TreeNode nextValue = new TreeNode(value);


        TreeNode temp = root;
        while(temp.value >= value && temp.left != null){
            temp = temp.left;
        }
        if(temp.value >= value && temp.left == null){
            temp.left = nextValue;
            return;
        }

        while(temp.value < value && temp.right != null){
            temp = temp.right;
        }
        if(temp.value < value && temp.right == null){
            temp.right = nextValue;
            return;
        }
        return;
    }

    public void inorder(TreeNode temp){
        if(temp == null){
            return;
        }
        else {
            inorder(temp.left);
            System.out.print(temp.value + " ");
            inorder(temp.right);
        }
    }

    public void preorder(TreeNode temp){
        if(temp == null){
            return;
        }
        else {
            System.out.print(temp.value + " ");
            preorder(temp.left);
            preorder(temp.right);
        }
    }

    public Integer find_height(TreeNode root) {
       int sum = 0;
       int result = find_height2(root,sum);
       return result;
    }

    public Integer find_height2(TreeNode root,int sum){
        if(root == null)
        {
            return sum + 0;
        }
        else {

            int leftsum = 1 + find_height2(root.left,sum);
            int rightsum = 1 + find_height2(root.right,sum);
            sum = Math.max(leftsum,rightsum);
            return sum;
        }

    }


    public void postorder(TreeNode temp){
        if(temp == null){
            return;
        }
        else {
            postorder(temp.left);
            postorder(temp.right);
            System.out.print(temp.value + " ");

        }
    }

    public void levelOrder(TreeNode temp){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(temp);
        while(!queue.isEmpty()){
            TreeNode temp1 = queue.remove();
            System.out.print(temp1.value + " ");
            if(temp1.left != null)
                queue.add(temp1.left);
            if(temp1.right != null)
                queue.add(temp1.right);
        }

    }



}
