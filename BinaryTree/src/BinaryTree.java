import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;
        public TreeNode(char val) {
            this.val = val;
        }
    }

    //前序
    public void preOrder(TreeNode root) {

        if(root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //中序
    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    //后序
    public void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
    //左子树节点个数 + 右子树节点个数 + 1
    public int size(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }
    //获取叶子节点个数（左边的叶子 + 右边的叶子）
    public int getLeafNodeCount(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.right == null && root.left == null) {
            return 1;
        }
        return getLeafNodeCount(root.left) + getLeafNodeCount(root.right);
    }
    //获取k行节点个数（子问题方法）
    public int getKLevelNodeCount(TreeNode root, int k) {
        if(root == null || k <= 0) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }
        return getKLevelNodeCount(root.left, k - 1) + getKLevelNodeCount(root.right, k - 1);
    }
    //左数和右树高度的最大值 + 1
    public int getHight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int tmp1 = getHight(root.left);
        int tmp2 = getHight(root.right);
        return tmp1 > tmp2 ? tmp1 + 1: tmp2 + 1;
    }
    //在递归左右树时就判断，如果找到直接返回
    public TreeNode find(TreeNode root, char val) {
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            return root;
        }
        TreeNode tmp1 = find(root.left, val);
        if(tmp1 != null) {
            return tmp1;
        }
        TreeNode tmp2 = find(root.right, val);
        if(tmp2 != null) {
            return tmp2;
        }
        return null;
    }
    //利用队列，用cur去遍历二叉树
    public void levelOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        queue.offer(cur);
        while(!queue.isEmpty()) {
            cur = queue.poll();
            System.out.print(cur.val + " ");
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            if(cur.right != null) {
                queue.offer(cur.right);
            }
        }

    }
    //根据字符串构造一颗二叉树（前序遍历）
    private static int i = 0;
    public static TreeNode createTree(String str) {

        //先构造根节点，然后递归构造左右子树
        char tmp = str.charAt(i);
        TreeNode newNode = null;
        if(tmp != '#') {
            i++;
            newNode = new TreeNode(tmp);
            newNode.left = createTree(str);
            newNode.right = createTree(str);
        }else {
            i++;
        }
        return newNode;
    }
    public TreeNode createBinaryTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }

}
