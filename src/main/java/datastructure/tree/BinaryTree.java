package datastructure.tree;

import common.Node;
import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
    //从前序与中序遍历序列构造二叉树
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length==0){
            return null;
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode build(int[] preorder, int preLeft,int preRight,int[] inorder,int inLeft,int inRight){
        if (inLeft > inRight || preLeft >preRight) {
            return null;
        }
        int rootValue=preorder[preLeft];
        TreeNode root=new TreeNode(rootValue);
        if(preLeft==preRight){
            return root;
        }
        int rootIndex=-1;
        for(int i=inLeft;i<=inRight;i++){
            if(inorder[i]==rootValue){
                rootIndex=i;
            }
        }
        //左子树的长度
        int leftLength=rootIndex-inLeft;
        //前序序列中左子树的最后一个节点
        int leftPreEnd = preLeft + leftLength;
        root.left=build(preorder,preLeft+1,leftPreEnd,inorder,inLeft,rootIndex-1);
        root.right=build(preorder,leftPreEnd+1,preRight,inorder,rootIndex+1,inRight);
        return root;
    }
    //填充每个节点的下一个右侧节点指针
    //给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        if(root.left!=null){
            //完美二叉树，所以有左孩子必定有右孩子
            root.left.next=root.right;
            if(root.next!=null){
                root.right.next=root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
    //填充每个节点的下一个右侧节点指针 II
    //填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
    public Node connect2(Node root) {
        if(root==null){
            return null;
        }
        Node rootNextFirstChildNode=null;
        Node p=root.next;
        //找到root的兄弟节点中从左往右第一个不为空的孩子节点。
        while(p!=null){
            if(p.left!=null){
                rootNextFirstChildNode=p.left;
                break;
            }else if(p.right!=null){
                rootNextFirstChildNode=p.right;
                break;
            }
            p=p.next;
        }
        if(root.left!=null){
            root.left.next=root.right==null?rootNextFirstChildNode:root.right;
        }
        if(root.right!=null){
            root.right.next=rootNextFirstChildNode;
        }
        connect2(root.right);
        connect2(root.left);
        return root;
    }
    public static String serialize(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        LinkedList<TreeNode> queue=new LinkedList<>();
        List<Integer> temp=new ArrayList<>();
        if(root==null){
            return result.toString();
        }
        queue.offer(root);
        boolean flag=true;
        while(!queue.isEmpty()&&flag){
            flag=false;
            result.addAll(temp);
            temp.clear();
            int n=queue.size();
            for(int i=0;i<n;i++){
                TreeNode node=queue.poll();
                if(node==null){
                    temp.add(null);
                    queue.offer(null);
                    queue.offer(null);
                }else{
                    temp.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                    flag=true;
                }
            }
        }
        return result.toString().replace(" ","" );

    }
    public static TreeNode deserialize(String data) {
        if(data.length()<=2){
            return null;
        }
        String data2=data.substring(1,data.length()-1);
        List<String> list=Arrays.asList(data2.split(","));
        TreeNode root=new TreeNode(Integer.parseInt(list.get(0)));
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        for(int i=1;Math.pow(2,i)<=list.size();i++) {
            for (int j = (int) (Math.pow(2, i) - 1); j < Math.pow(2, i + 1) - 1; j=j+2) {
                String left = list.get(j);
                TreeNode leftNode = String2Node(left);
                TreeNode rightNode=null;
                if(j+1<Math.pow(2, i + 1) - 1){
                    String right = list.get(j + 1);
                    rightNode= String2Node(right);
                }
                TreeNode oldNode = queue.poll();
                oldNode.left = leftNode;
                oldNode.right = rightNode;
                if (leftNode != null) {
                    queue.offer(leftNode);
                }
                if (rightNode != null) {
                    queue.offer(rightNode);
                }
            }
        }
        return root;
    }
    public static TreeNode String2Node(String s){
        TreeNode node;
        if ("null".equals(s)) {
            node = null;
        } else {
            int val = Integer.parseInt(s);
            node = new TreeNode(val);
        }
        return node;
    }
    public static void main(String[] args){
        TreeNode result=deserialize("[1,2,3,null,null,4,5]");
        System.out.println(serialize(result));
        TreeNode result2=deserialize(serialize(result));
        System.out.println(serialize(result2));
    }
}

