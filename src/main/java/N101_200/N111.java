package N101_200;

import common.TreeNode;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N111 {
    public int minDepth(TreeNode root) {
        return minDepth(root, 0);
    }

    private int minDepth(TreeNode root, int count) {
        int depth = count;
        if (root != null) {
            depth++;
            if (root.left == null) {
                depth = minDepth(root.right, depth);
            } else if (root.right == null) {
                depth = minDepth(root.left, depth);
            } else {
                depth = Math.min(minDepth(root.left, depth), minDepth(root.right, depth));
            }
        }
        return depth;
    }
}
