package N101_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N107 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<TreeNode> treeNodes = new ArrayList<>(1);
        if (root == null) {
            return new LinkedList<>();
        }
        treeNodes.add(root);
        return getThisLevel(treeNodes);
    }

    private List<List<Integer>> getThisLevel(List<TreeNode> treeNodes) {
        List<TreeNode> thisLevelTreeNodes = new LinkedList<>();
        List<Integer> thisLevelValues = treeNodes.stream().map(treeNode -> treeNode.val).collect(Collectors.toList());
        treeNodes.forEach(treeNode -> {
            if (treeNode.left != null) {
                thisLevelTreeNodes.add(treeNode.left);
            }
            if (treeNode.right != null) {
                thisLevelTreeNodes.add(treeNode.right);
            }
        });

        List<List<Integer>> result = new LinkedList<>();
        if (treeNodes.size() > 0) {
            List<List<Integer>> nextLevel = getThisLevel(thisLevelTreeNodes);
            if (nextLevel.get(0).size() > 0) {
                result.addAll(nextLevel);
            }
        }
        result.add(thisLevelValues);
        return result;
    }
}
