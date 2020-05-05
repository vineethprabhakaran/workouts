package com.vineethds.trees;


class TreeNode{
    int data;
    TreeNode left,right;
    TreeNode(int data){
        this.data = data;
    }
}

public class ValidateBST {
    public boolean isValid(TreeNode node){
        return isValid(node,null,null);
    }

    public boolean isValid(TreeNode node , Integer low, Integer high){
        if(node == null){
            return true;
        }
        if(low != null && node.data <= low) return false;
        if(high!= null && node.data >= high) return false;

        return isValid(node.left,low,node.data) && isValid(node.right,node.data,high);
    }
    public static void main(String[] args) {
        TreeNode tn = new TreeNode(4);
        TreeNode tnl = new TreeNode(6);
        TreeNode tnr = new TreeNode(5);
        tn.left = tnl;
        tn.right = tnr;

        ValidateBST vb = new ValidateBST();
        boolean res = vb.isValid(tn);
        System.out.println(res);
    }
}

