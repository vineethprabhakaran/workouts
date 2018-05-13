package com.vineethds.trees;

import sun.reflect.generics.tree.Tree;

/**
 * Created by Vineeth on 5/13/2018.
 */
public class HeightofTree {

    HeightTreeNode root;
    public static void main(String a[]){
        HeightofTree ht = new HeightofTree();
        ht.insertNodeInBST(2);
        System.out.println( ht.height());
    }

    private int height() {
        return height(root);
    }

    private int height(HeightTreeNode root) {
        if(root == null){
            return 0;
        }
        return  Math.max(height(root.left),height(root.right))+1;
    }


    private void insertNodeInBST(int value) {
        insertNodeInBST(root,value);
    }
    private  HeightTreeNode insertNodeInBST(HeightTreeNode node, int value) {
        HeightTreeNode newNode;
        if(node == null){
            newNode = new HeightTreeNode(value);
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

class HeightTreeNode{
    int data;
    HeightTreeNode left;
    HeightTreeNode right;
    HeightTreeNode(int data){
        this.data = data;
    }
}
