package com.vineethds.subsets;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2(int x) {
        val = x;
    }
};
public class UniqueTrees {
    public static List<TreeNode2> findUniqueTrees(int n) {
        if (n <= 0)
            return new ArrayList<TreeNode2>();
        return findUniqueTreesRecursive(1, n);
    }

    public static List<TreeNode2> findUniqueTreesRecursive(int start, int end) {
        List<TreeNode2> result = new ArrayList<>();
        // base condition, return 'null' for an empty sub-tree
        // consider n=1, in this case we will have start=end=1, this means we should have only one tree
        // we will have two recursive calls, findUniqueTreesRecursive(1, 0) & (2, 1)
        // both of these should return 'null' for the left and the right child
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            // making 'i' root of the tree
            List<TreeNode2> leftSubtrees = findUniqueTreesRecursive(start, i - 1);
            List<TreeNode2> rightSubtrees = findUniqueTreesRecursive(i + 1, end);
            for (TreeNode2 leftTree : leftSubtrees) {
                for (TreeNode2 rightTree : rightSubtrees) {
                    TreeNode2 root = new TreeNode2(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    result.add(root);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<TreeNode2> result = UniqueTrees.findUniqueTrees(2);
        System.out.print("Total trees: " + result.size());
    }
}
