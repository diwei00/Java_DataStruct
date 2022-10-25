public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTree("abc##de#g##f###");
        binaryTree.preOrder(root);
        System.out.println();
        binaryTree.inOrder(root);
        System.out.println();
        binaryTree.postOrder(root);
        System.out.println();
        int ret = binaryTree.size(root);
        System.out.println(ret);
        int ret2 = binaryTree.getLeafNodeCount(root);
        System.out.println(ret2);
        int ret3 = binaryTree.getKLevelNodeCount(root, 1);
        System.out.println(ret3);
        int ret4 = binaryTree.getHight(root);
        System.out.println(ret4);
        BinaryTree.TreeNode ret5 = binaryTree.find(root, 'a');
        System.out.println(ret5.val);
        binaryTree.levelOrder(root);

    }
}
