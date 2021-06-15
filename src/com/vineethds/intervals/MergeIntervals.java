package com.vineethds.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*
Given a list of intervals, merge all the overlapping
intervals to produce a list that has only mutually exclusive intervals.

Intervals: [[1,4], [2,5], [7,9]]
Output: [[1,5], [7,9]]
Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
one [1,5].

 */


public class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals){
        if(intervals.size() < 2){
            return null;
        }
        Collections.sort(intervals,(a,b) -> Integer.compare(a.start,b.start));
        List<Interval> mergeInterval = new ArrayList<>();
        Iterator<Interval> itr = intervals.iterator();
        Interval interval = itr.next();
        int start = interval.start;
        int end = interval.end;
        while(itr.hasNext()){
            interval = itr.next();
            if(interval.start <= end){
                end = Math.max(end,interval.end);
            }else {
                mergeInterval.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        mergeInterval.add(new Interval(start,end));
        return mergeInterval;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
