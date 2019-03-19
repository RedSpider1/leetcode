package N101_200;

import common.TreeNode;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = search(root.left, 0);
        int right = search(root.right, 0);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int search(TreeNode treeNode, int count) {
        if (treeNode == null) {
            return count;
        }
        return Math.max(search(treeNode.left, count + 1), search(treeNode.right, count + 1));
    }
}
