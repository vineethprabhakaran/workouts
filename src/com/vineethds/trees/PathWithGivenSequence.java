package com.vineethds.trees;
/*
Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree.
Tc: O(N)
SC: O(N) - to store the recursive stack
 */

public class PathWithGivenSequence {

    public static boolean findPath(TreeNode root, int[] sequence){
        if(root == null)
            return sequence.length == 0;
        return findSequence(root,sequence,0);
    }

    public static boolean findSequence(TreeNode root, int[] sequence, int level){
        if(root == null)
            return false;

        if(level >= sequence.length || root.data != sequence[level])
            return false;

        if(root.left != null && root.right == null)
            return true;

        return findSequence(root.left, sequence, level +1) || findSequence(root.right, sequence, level +1);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }
}
