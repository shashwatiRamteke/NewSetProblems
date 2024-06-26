public class TreeTester {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
       // TreeNode rootOfBst = bst.defaultTree();
        TreeNode rootobalTree = bst.defaultBSTree();
        System.out.println(" Inorder ");
        bst.inorder(rootobalTree);
        /*System.out.println(" preorder ");

        bst.preorder(rootOfBst);
        System.out.println(" postorder ");

        bst.postorder(rootOfBst);

        System.out.println(" postorder ");*/
        //System.out.println(bst.find_height(rootOfBst));

        //bst.levelOrder(rootOfBst);

    }
}
