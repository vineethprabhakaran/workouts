package com.vineethds.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
/*
Given a binary tree and a number ‘S’, find all paths in the tree such that the sum of all the node values of each path equals ‘S’.
Please note that the paths can start or end at any node but all paths must follow direction from parent to child (top to bottom).

TC: O(N ^ 2)
SC: O(N)
 */
public class CountAllPathSum {
    public static int countPaths(TreeNode root, int S) {
        if(root == null)
            return -1;
        List<Integer> currpaths = new ArrayList<>();
        return findNumberOfPaths(root, S, currpaths);
    }

    public static int findNumberOfPaths(TreeNode root, int S, List<Integer> currpaths){
        if(root == null)
            return 0;
        int pathSum = 0, pathCount = 0;
        currpaths.add(root.data);
        ListIterator<Integer> itr = currpaths.listIterator(currpaths.size());
        while(itr.hasPrevious()){
            pathSum += itr.previous();
            if(pathSum == S){
                pathCount++;
            }
        }
        pathCount += findNumberOfPaths(root.left, S, currpaths);
        pathCount += findNumberOfPaths(root.right, S, currpaths);

        currpaths.remove(currpaths.size()-1);
        return pathCount;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
    }
}
