package com.vineethds.intervals;
/*
 Given a list of appointments, find all the conflicting appointments.

 Appointments: [[4,5], [2,3], [3,6], [5,7], [7,8]]
Output:
[4,5] and [3,6] conflict.
[3,6] and [5,7] conflict.
 */

import java.util.Arrays;

public class ConflictAppointments {

    public static void getConflictAppointments(Interval[] intervals){
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start,b.start));
        int start = intervals[0].start;
        int end = intervals[0].end;
        for(int i = 1;i < intervals.length;i++){
            if(intervals[i].start < end){
                System.out.println("["+start+" "+ end+"] ["+intervals[i].start+" "+intervals[i].end+"]");
            }else{
                start = intervals[i].start;
                end = intervals[i].end;
            }
        }
    }
    public static void main(String[] args) {
        Interval[] intervals = {new Interval(4,5),new Interval(2,3), new Interval(3,6), new Interval(5,7), new Interval(7,8)};
        ConflictAppointments.getConflictAppointments(intervals);
    }
}
