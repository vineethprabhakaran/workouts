package com.vineethds.trees;

import sun.reflect.generics.tree.Tree;

/**
 * Created by Vineeth on 5/13/2018.
 */
public class HeightofTree {

    TreeNode root;
    public static void main(String a[]){
        HeightofTree ht = new HeightofTree();
        ht.insertNodeInBST(2);
        System.out.println( ht.height());
    }

    private int height() {
        return height(root);
    }

    private int height(TreeNode root) {
        if(root == null){
            return 0;
        }
        return  Math.max(height(root.left),height(root.right))+1;
    }


    private void insertNodeInBST(int value) {
        insertNodeInBST(root,value);
    }
    private  TreeNode insertNodeInBST(TreeNode node, int value) {
       TreeNode newNode;
        if(node == null){
            newNode = new TreeNode(value);
            root = newNode;
            return newNode;
       }
       if(value < node.data){
            node.left = insertNodeInBST(node.left,value);
       }
       if(value > node.data){
           node.right = insertNodeInBST(node.right,value);
       }

       return node;
    }
}

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
    }
}
