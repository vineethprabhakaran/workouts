package com.vineethds.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by HP on 5/17/2018.
 */
class TreeTopViewNode{
    int data;
    TreeTopViewNode left,right;
    TreeTopViewNode(int data){
        this.data = data;
        left = right = null;
    }
}
class QueryEntry{
    int hd;
    TreeTopViewNode node;
    QueryEntry(TreeTopViewNode node, int hd){
        this.node = node;
        this.hd =hd;
    }
}
public class TreeTopView {
    TreeTopViewNode root;
    public static void main(String a[]){
        TreeTopView top = new TreeTopView();
        top.createTree();
        top.printTopView();
    }

    private void printTopView() {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        printTopView(root,map);
        printMap(map);
    }

    private void printMap(HashMap<Integer, Integer> map) {
        for (Map.Entry me: map.entrySet()){
            System.out.print(me.getValue()+" ");
        }
    }

    private void printTopView(TreeTopViewNode root, HashMap<Integer, Integer> map) {
        int currhd = 0;
        LinkedList<QueryEntry> queue = new LinkedList<QueryEntry>();
        queue.add(new QueryEntry(root,1));
        while(!queue.isEmpty()){
            QueryEntry qe = queue.remove();
            TreeTopViewNode node = qe.node;
            if(map.get(qe.hd) == null){
                map.put(qe.hd,node.data);

            }
            if(node.left != null){
                queue.add(new QueryEntry(node.left,qe.hd-1));
            }
            if(node.right != null){
                queue.add(new QueryEntry(node.right,qe.hd+1));
            }
        }


    }

    private void createTree() {
        root = new TreeTopViewNode(1);
        root.left = new TreeTopViewNode(2);
        root.right = new TreeTopViewNode(3);
        root.left.left = new TreeTopViewNode(4);
        root.left.right = new TreeTopViewNode(5);
        root.right.left = new TreeTopViewNode(6);
        root.right.right = new TreeTopViewNode(7);
    }

}
