package com.vineethds.kelements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
/*
Given ‘M’ sorted arrays, find the smallest range that includes at least one number from each of the ‘M’ lists.

Input: L1=[1, 5, 8], L2=[4, 12], L3=[7, 8, 10]
Output: [4, 7]
Explanation: The range [4, 7] includes 5 from L1, 4 from L2 and 7 from L3.

TC: O(NLogM)
SC: O(M)

 */

class ENode{
    int arrayIndex;
    int elementIndex;
    public ENode(int arrayIndex, int elementIndex){
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
    }
}
public class SmallestNumberRange {

    public static int[] findSmallestRange(List<Integer[]> lists){
        PriorityQueue<ENode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> lists.get(a.arrayIndex)[a.elementIndex]));
        int currentMax = Integer.MIN_VALUE;
        for(int i = 0 ; i < lists.size() ;i++){
            minHeap.offer(new ENode(i,0));
            currentMax = Math.max(currentMax, lists.get(i)[0]);
        }
        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;
        while(minHeap.size() == lists.size()){
            ENode node = minHeap.poll();
            if(rangeEnd - rangeStart > currentMax - lists.get(node.arrayIndex)[node.elementIndex]){
                rangeStart = lists.get(node.arrayIndex)[node.elementIndex];
                rangeEnd = currentMax;
            }
            node.elementIndex++;
            if(lists.get(node.arrayIndex).length > node.elementIndex){
                minHeap.offer(new ENode(node.arrayIndex, node.elementIndex));
                currentMax = Math.max(currentMax, lists.get(node.arrayIndex)[node.elementIndex]);
            }
        }
        return new int[]{rangeStart, rangeEnd};
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 1, 5, 8 };
        Integer[] l2 = new Integer[] { 4, 12 };
        Integer[] l3 = new Integer[] { 7, 8, 10 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int[] result = SmallestNumberRange.findSmallestRange(lists);
        System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
    }
}
