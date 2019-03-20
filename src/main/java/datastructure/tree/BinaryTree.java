package datastructure.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    //递归算法-前序遍历（中序、后序稍作改动）
    private List<Integer> list=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root!=null){
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return list;
    }
    //递归算法-树的最大深度
    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return 1+Math.max(left,right);
    }
    //递归算法-检查二叉树否是对称。
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }
    public boolean isMirror(TreeNode node1,TreeNode node2){
        if(node1==null&&node2==null){
            return true;
        }
        if(node1==null||node2==null){
            return false;
        }
        return (node1.val==node2.val)&&isMirror(node1.left,node2.right)&&isMirror(node1.right,node2.left);
    }
    //给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return sum - root.val == 0;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
    //从中序与后序遍历序列构造二叉树
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0||inorder.length==0){
            return null;
        }

        if(postorder.length!=inorder.length){
            return null;
        }

        int rootVal=postorder[postorder.length-1];
        TreeNode root=new TreeNode(rootVal);
        int rootIndex=-1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootVal){
                rootIndex=i;
                break;
            }
        }
        //也可以不用这么多temp数组，直接操作原数组，给定startIndex和endIndex，这样的话，参数是6个，但执行效率更快。
        int[] inorderLeft=new int[rootIndex];
        int[] inorderRight=new int[inorder.length-rootIndex-1];
        int[] postorderLetf=new int[rootIndex];
        int[] postorderRight=new int[inorder.length-rootIndex-1];
        for(int i=0;i<rootIndex;i++){
            inorderLeft[i]=inorder[i];
            postorderLetf[i]=postorder[i];
        }
        int j=0;
        for(int k=rootIndex+1;k<inorder.length;k++,j++){
            inorderRight[j]=inorder[k];
            postorderRight[j]=postorder[k-1];
        }

        root.left=buildTree(inorderLeft,postorderLetf);
        root.right=buildTree(inorderRight,postorderRight);
        return root;
    }
}

