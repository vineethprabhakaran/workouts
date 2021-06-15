package com.vineethds.kelements;

import java.util.Iterator;
import java.util.PriorityQueue;

/*
Design a class to efficiently find the Kth largest element in a stream of numbers.

The class should have the following two things:

The constructor of the class should accept an integer array containing initial numbers from the stream and an integer ‘K’.
The class should expose a function add(int num) which will store the given number and return the Kth largest number.

Input: [3, 1, 5, 12, 2, 11], K = 4
1. Calling add(6) should return '5'.
2. Calling add(13) should return '6'.
2. Calling add(4) should still return '6'.

 */
public class KthLargestNumberInStream {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a,b) -> a-b);
    private int K;
    public KthLargestNumberInStream(int[] nums, int k) {
        this.K = k;
        for(int num : nums){
            add(num);
        }
    }

    public int add(int num) {
        minHeap.offer(num);
        if(minHeap.size() > this.K){
            minHeap.poll();
        }


        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
        KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6));
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));
        System.out.println("4th largest number is: " + kthLargestNumber.add(4));
    }
}
