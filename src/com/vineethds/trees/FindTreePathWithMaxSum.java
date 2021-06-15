package com.vineethds.trees;

import java.util.ArrayList;
import java.util.List;
/*
Given a binary tree, Find the root to leaf path with the maximum sum
Tc: O(N ^ 2)
SC: O(N)
 */
public class FindTreePathWithMaxSum {
public static int maxSum = 0;
    public static List<List<Integer>> findPaths(TreeNode root) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<Integer>();
        findPathsRecursive(root, 0, currentPath, allPaths);
        return allPaths;
    }

    private static void findPathsRecursive(TreeNode currentNode, int sum,List<Integer> currentPath,
                                           List<List<Integer>> allPaths) {
        if (currentNode == null)
            return;

        currentPath.add(currentNode.data);
        sum = sum + currentNode.data;
        // if the current node is a leaf and its value is equal to sum, save the current path
        if (sum > maxSum && currentNode.left == null && currentNode.right == null) {
            if(allPaths.size() > 0){
                allPaths.remove(allPaths.size()-1);
            }
            maxSum = sum;
            allPaths.add(new ArrayList<Integer>(currentPath));
        } else {
            // traverse the left sub-tree
            findPathsRecursive(currentNode.left, sum ,currentPath, allPaths);
            // traverse the right sub-tree
            findPathsRecursive(currentNode.right, sum,currentPath, allPaths);
        }

        // remove the current node from the path to backtrack,
        // we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() - 1);
        sum = sum - currentNode.data;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = FindTreePathWithMaxSum.findPaths(root);
        System.out.println("Tree paths with sum : " + result);
    }
}
