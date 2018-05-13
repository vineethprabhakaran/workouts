package com.vineethds.trees;

/**
 * Created by HP on 5/13/2018.
 */
public class DiameterOfTree {
    DiameterTreeNode root;
    public static void main(String a[]){
        DiameterOfTree dt = new DiameterOfTree();
        dt.createBinaryTree();
        System.out.println(dt.diameter());
    }

    private int diameter(){
        return diameter(root);
    }

    private int diameter(DiameterTreeNode node){
        if(node == null){
            return 0;
        }
        int lheight = height(node.left);
        int rheight = height(node.right);

        int ldiameter = diameter(node.left);
        int rdiameter = diameter(node.right);

        return Math.max(lheight+rheight+1,Math.max(ldiameter,rdiameter));
    }

    private int height(DiameterTreeNode node){
        if(node == null){
            return 0;
        }

        return Math.max(height(node.left),height(node.right))+1;
    }

    private void createBinaryTree() {
        root = new DiameterTreeNode(1);
        root.left = new DiameterTreeNode(2);
        root.right = new DiameterTreeNode(3);
        root.left.left = new DiameterTreeNode(4);
        root.left.right = new DiameterTreeNode(5);
    }

}

class DiameterTreeNode{
    int data;
    DiameterTreeNode left;
    DiameterTreeNode right;
    DiameterTreeNode(int data){
        this.data = data;
    }
}
