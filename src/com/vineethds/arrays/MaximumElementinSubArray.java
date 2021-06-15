package com.vineethds.arrays;

import java.util.PriorityQueue;
import java.util.TreeSet;

/*
Given input as an integer array and an integer 'k', find and print element with maximum value from each sub-array of size 'k'.
For example, for the input array {4,2,12,34,23,35,44,55} and for k = 3, output should be 12,34,34,35,44,55.
Observe that 12 is the largest element in the first sub-array {4,2,12}, 34 is the largest element
in the second and third sub-arrays - {2,12,34} and {12,34,23} and so on.
 */
public class MaximumElementinSubArray {

    public static int[] findMaxElement(int[] arr, int k){
        int[] result = new int[arr.length - 2];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b -a);
        int j = 0;
        for(int i = 0; i < arr.length; i++){
            maxHeap.offer(arr[i]);
            if(!maxHeap.isEmpty() && i >= k -1){
                result[j++] = maxHeap.peek();
                maxHeap.remove(arr[i + 1- k]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,12,34,23,35,44,55};
        int [] res = findMaxElement(arr, 3);
        for(int num : res){
            System.out.print(num+" ");
        }

    }
}
