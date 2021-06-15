package com.vineethds.kelements;

import java.util.PriorityQueue;

class SumOfElements {

    public static int findSumOfElements(int[] nums, int k1, int k2) {
        int sum = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a-b);
        for(int num : nums){
            sum += num;
            minHeap.offer(num);
        }
        int i = 0;
        while(!minHeap.isEmpty()){
            int num = minHeap.poll();
            if(i < k1 || i >= k2 -1)
                sum = sum - num;

            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int result = SumOfElements.findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

        result = SumOfElements.findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
    }
}
