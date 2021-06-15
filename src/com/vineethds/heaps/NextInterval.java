package com.vineethds.heaps;

import com.vineethds.intervals.Interval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NextInterval {
    public static int[] findNextInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        Arrays.fill(result,-1);
        int indexCount = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a,b) -> Integer.compare(intervals[a].start, intervals[b].start));
        Interval currentInterval = intervals[0];
        for(int i = 1; i< intervals.length;i++){
            minHeap.offer(i);
        }
        while(!minHeap.isEmpty()){
            int nextIndex = minHeap.poll();
            Interval nextInterval = intervals[nextIndex];
            if(currentInterval.end <= nextInterval.start){
                result[indexCount++] = nextIndex;
                currentInterval = nextInterval;
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
