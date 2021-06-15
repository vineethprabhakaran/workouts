package com.vineethds.others;

import java.util.Arrays;
import java.util.PriorityQueue;

class Interval {
    int start = 0;
    int end = 0;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class NextInterval {
    public static int[] findNextInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> intervals[a].start - intervals[b].start);
        Interval currInterval = intervals[0];
        for(int i = 1;i< intervals.length;i++){
            minHeap.offer(i);
        }
        int index = 0;
        Arrays.fill(result,-1);
        while(!minHeap.isEmpty()){
            int i = minHeap.poll();
            Interval nextInterval = intervals[i];
            if(currInterval.end <= nextInterval.start){
                result[index++] = i;
                currInterval = nextInterval;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(5, 6) };
        int[] result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
        System.out.println();

        intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) };
        result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
    }
}