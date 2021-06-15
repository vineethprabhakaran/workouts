package com.vineethds.kelements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Node{
    int value;
    int arrayIndex;
    int elementIndex;
    public Node(int value, int arrayIndex, int elementIndex){
        this.value = value;
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
    }
}

class KthSmallestInMSortedArrays {

    public static int findKthSmallest(List<Integer[]> lists, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);
        for(int i = 0;i < lists.size();i++){
            minHeap.offer(new Node((int)lists.get(i)[0], i, 0));
        }

        int count = 0;
        while(!minHeap.isEmpty()){
            Node node = minHeap.poll();
            count++;
            if(count == k)
                return node.value;

            int i = node.arrayIndex;
            int j = node.elementIndex + 1;
            if(j < lists.get(i).length){
                minHeap.offer(new Node((int)lists.get(i)[j], i, j));
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 2, 6, 8 };
        Integer[] l2 = new Integer[] { 3, 6, 7 };
        Integer[] l3 = new Integer[] { 1, 3, 4 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}
