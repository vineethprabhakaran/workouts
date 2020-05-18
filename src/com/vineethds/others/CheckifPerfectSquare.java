package com.vineethds.others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/*
Problem: Check if the given number is perfect square.
@Author: Vineeth
@input: integer number
@Output: Return true if the given number is perfect square or else false
Main thing to know:
square root of the number num will always be less than num/2
so the problem breaks down into finding the element in the sequence of numbers which is similar to
searching a number in a sorted list of elements
 */
public class CheckifPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num < 2) return true;
        int start = 1;
        int end = num/2;
        while(start <= end){
            int mid = (start + end )/2;
            if(mid * mid == num) {
                return true;
            }
            else if ((mid * mid ) > num){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        CheckifPerfectSquare cp = new CheckifPerfectSquare();
        boolean res = cp.isPerfectSquare(625);
        System.out.println(res);
    }
}
