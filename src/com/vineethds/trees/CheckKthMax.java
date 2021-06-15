package com.vineethds.trees;

public class CheckKthMax {
    private static int count = 0;

    public static void main(String args[])
    {
        binarySearchTree bsT = new binarySearchTree();

        bsT.add(6);
        bsT.add(4);
        bsT.add(9);
        bsT.add(5);
        bsT.add(2);
        bsT.add(8);
        bsT.add(12);
        bsT.add(10);
        bsT.add(14);

       // bsT.printTree(bsT.getRoot());
        int result = findKthMax(bsT.getRoot(),6);
        System.out.println(result);
    }

    public static int findKthMax(Node root, int k) {

        if(root == null){
            return 0;
        }
        int x = findKthMax(root.getRightChild(),k);
        if(x != 0){
            return x;
        }
        count = count+1;
        if(count == k){
            return root.getData();
        }

        return findKthMax(root.getLeftChild(),k);
    }
}
