public class BinarySearchTree {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode root = null;

    /**
     * 二叉搜索树的查找（左面比根小，右面比根大）
     * @param val
     * @return
     */
    public TreeNode Search(int val) {
        TreeNode cur = root;
        while(cur != null) {
            if(val > cur.val) {
                cur = cur.right;
            }else if(val < cur.val) {
                cur = cur.left;
            }else {
                return cur;
            }
        }
        return null;
    }

    /**
     * 二叉搜索树的插入
     * 在叶子节点插入
     * @param val
     * @return
     */
    public boolean insert(int val) {
        if(root == null) {
            TreeNode newNode = new TreeNode(val);
            root = newNode;
            return true;
        }
        TreeNode cur = root;
        TreeNode prev = null;
        while(cur != null) {
            if(val > cur.val) {
                prev = cur;
                cur = cur.right;
            }else if(val < cur.val) {
                prev = cur;
                cur = cur.left;
            }else {
                return false;
            }
        }
        //最终可能在左面和右面插入
        TreeNode newNode = new TreeNode(val);
        if(val < prev.val) {
            prev.left = newNode;
        }else {
            prev.right = newNode;
        }
        return true;
    }
    private void removeNode(TreeNode prev, TreeNode cur) {
        //删除分为三种情况
        //左树为空  右树为空  左右树都不为空
        if(cur.left == null) {
            //可能删除根节点  可能删除prev的右节点  可能删除prev的左节点
            if(cur == root) {
                root = root.right;
            }else if(cur == prev.right) {
                prev.right = cur.right;
            }else {
                prev.left = cur.right;
            }
        }else if(cur.right == null) {
            if(cur == root) {
                root = root.left;
            }else if(cur == prev.right) {
                prev.right = cur.left;
            }else {
                prev.left = cur.left;
            }

        }else {
            //替罪羊式删除法
            //左树中找最大的/右树中找最小的
            //就可以替换要被删除的元素，接下来只需删除左面最大或者右面最小的节点
            TreeNode target = cur.right;
            TreeNode targetParent = cur;
            while(target.left != null) {
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;
            //最终要删除的节点可能在targetParent左和右
            if(target == targetParent.left) {
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;
            }
        }
    }

    /**
     * 二叉搜索树的删除
     * @param val
     * @return
     */
    public boolean remove(int val) {
        TreeNode cur = root;
        TreeNode prev = null;
        while(cur != null) {
            if(val > cur.val) {
                prev = cur;
                cur = cur.right;
            }else if(val < cur.val) {
                prev = cur;
                cur = cur.left;
            }else {
                removeNode(prev, cur);
                return true;
            }
        }
        return false;
    }
    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

}
