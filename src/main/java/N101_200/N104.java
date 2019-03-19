package N101_200;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N104 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        return getNextDepth(root, 0);
    }

    private int getNextDepth(TreeNode root, int currentDepth) {
        if (root == null) {
            return currentDepth;
        } else {
            return Math.max(getNextDepth(root.left, currentDepth + 1), getNextDepth(root.right, currentDepth + 1));
        }
    }
}
