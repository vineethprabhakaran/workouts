package com.vineethds.trees;
/*
Find the path with the maximum sum in a given binary tree. Write a function that returns the maximum sum.

A path can be defined as a sequence of nodes between any two nodes and doesn’t necessarily pass through the root.
The path must contain at least one node.

TC: O(N)
SC: O(N)
 */
public class MaximumPathSum {
    public static int globalMaxSum;
    public static int findMaximumPathSum(TreeNode root){
        if(root == null)
            return -1;
        globalMaxSum = Integer.MIN_VALUE;
        findMaximumSum(root);
        return globalMaxSum;
    }

    public static int findMaximumSum(TreeNode root){
        if(root == null)
            return 0;

        int maxSumLeft = findMaximumSum(root.left);
        int maxSumRight = findMaximumSum(root.right);

        maxSumLeft = Math.max(maxSumLeft,0);
        maxSumRight = Math.max(maxSumRight,0);

        int localSum = maxSumLeft + maxSumRight + root.data;
        globalMaxSum = Math.max(globalMaxSum, localSum);

        return Math.max(maxSumLeft,maxSumRight) + root.data;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    }
}
