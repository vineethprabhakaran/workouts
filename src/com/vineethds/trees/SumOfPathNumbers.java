package com.vineethds.trees;

import sun.reflect.generics.tree.Tree;

/*
Given a binary tree where each node can only have a digit (0-9) value, each root-to-leaf path will represent a number.
Find the total sum of all the numbers represented by all paths.
 TC: O(N)
 SC: O(N)
 */
public class SumOfPathNumbers {

    public static int findSumOfPathNumbers(TreeNode root){
        return findSumOfPath(root, 0);
    }

    public static int findSumOfPath(TreeNode root, int pathSum){
        if(root == null){
            return 0;
        }

        pathSum = pathSum * 10 + root.data;
        if(root.left == null && root.right == null){
            return pathSum;
        }

        return findSumOfPath(root.left,pathSum) + findSumOfPath(root.right, pathSum);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}
