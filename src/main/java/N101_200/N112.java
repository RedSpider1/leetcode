package N101_200;

import common.TreeNode;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == sum;
        } else {
            sum -= root.val;
            return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        }
    }
}
