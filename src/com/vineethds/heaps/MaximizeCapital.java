package com.vineethds.heaps;

import java.util.PriorityQueue;

public class MaximizeCapital {
    public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>((a, b) -> profits[b]-profits[a]);
        PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<>((a,b) -> capital[a]-capital[b]);
        int availableCapital = initialCapital;
        for(int i = 0;i < capital.length;i++){
            minCapitalHeap.offer(i);
        }
        for(int i = 0; i <numberOfProjects;i++ ){
            while(!minCapitalHeap.isEmpty() && capital[minCapitalHeap.peek()] <= availableCapital)
                maxProfitHeap.offer(minCapitalHeap.poll());

            if(maxProfitHeap.isEmpty())
                break;

            availableCapital += profits[maxProfitHeap.peek()];
        }

        return availableCapital;
    }

    public static void main(String[] args) {
        int result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
        System.out.println("Maximum capital: " + result);
        result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
        System.out.println("Maximum capital: " + result);
    }
}