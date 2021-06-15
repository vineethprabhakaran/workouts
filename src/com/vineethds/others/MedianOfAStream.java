package com.vineethds.others;

import java.util.PriorityQueue;

class MedianOfAStream {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a-b);
    public void insertNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.offer(num);
        else
            minHeap.offer(num);

        while(!maxHeap.isEmpty() && maxHeap.size() > minHeap.size() + 1)
            minHeap.offer(maxHeap.poll());

        while(!minHeap.isEmpty() && minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }

    }

    public double findMedian() {
        if(maxHeap.isEmpty())
            return 0.0;
        int size = maxHeap.size() + minHeap.size();
        if(size % 2 == 0){
            return (double)(minHeap.peek() + maxHeap.peek())/2;
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}